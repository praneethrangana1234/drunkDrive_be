package lk.coop.service.authentication.impl;

import lk.coop.converters.DateFormatConverter;
import lk.coop.dto.authentication.request.ActionSaveRequest;
import lk.coop.dto.authentication.request.FormSaveRequest;
import lk.coop.dto.authentication.request.FormUpdateRequest;
import lk.coop.dto.authentication.request.MIFormRequest;
import lk.coop.dto.authentication.response.ActionResponse;
import lk.coop.dto.authentication.response.FormSaveResponse;
import lk.coop.dto.authentication.response.FormsResponse;
import lk.coop.dto.authentication.response.MenuItemResponse;
import lk.coop.entity.authentication.Action;
import lk.coop.entity.authentication.AuMenuItems;
import lk.coop.entity.authentication.Forms;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.FormsRepository;
import lk.coop.service.authentication.FormsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FormsServiceImpl implements FormsService {

    @Autowired
    FormsRepository forms;

    @Override
    public FormSaveResponse save(FormSaveRequest formSaveRequest) {
        Forms save = forms.save(convert(formSaveRequest));
        return convertFormsSave(save);
    }

    @Override
    public FormSaveResponse update(FormUpdateRequest request) {
        try {
            Forms formsReq = this.forms.getOne(Deleted.NO, request.getId());
            if (formsReq == null) {
                return null;
            }
            Forms update = this.forms.save(convert(request, formsReq));
            return convertFormsSave(update);
        } catch (Exception e) {
            log.error("Error Update Forms {} ", request.getId());
            return null;
        }
    }

    @Override
    public FormsResponse delete(Integer id) {
        try {
            Forms formsReq = this.forms.getOne(Deleted.NO, id);
            if (formsReq == null) {
                return null;
            }
            Forms delete = this.forms.save(convertDelete(formsReq));
            return convertForms(delete);
        } catch (Exception e) {
            log.error("Error Delete Forms {} ", id);
            return null;
        }
    }


    @Override
    public FormsResponse getById(Integer id) {
        try {
            return convertForms(forms.getOne(Deleted.NO, id));
        } catch (Exception e) {
            log.error("Error getById Forms {} ", id);
            return null;
        }

    }

    @Override
    public List<FormsResponse> getAll() {
        return forms.findByIsDeleted(Deleted.NO).stream().map(FormsServiceImpl::convertForms).collect(Collectors.toList());
    }

    @Override
    public List<FormsResponse> getAllActive() {
        return forms.findByIsDeletedAndStatus(Deleted.NO, Status.ACTIVE).stream().map(FormsServiceImpl::convertForms).collect(Collectors.toList());
    }


    //SAVE
    private Forms convert(FormSaveRequest formsSaveRequest) {
        Forms formsSave = new Forms();
        formsSave.setName(formsSaveRequest.getName());
        formsSave.setAlias(formsSaveRequest.getAlias());
        formsSave.setMenuItems(convertMenuItem(formsSaveRequest.getMenuItem()));
        formsSave.setInactiveReason("");
        formsSave.setStatus(Status.ACTIVE);
        formsSave.setIsDeleted(Deleted.NO);
        formsSave.setActions(convertAction(formsSaveRequest.getActions(),formsSave));
        return formsSave;
    }


    /**
     * UPDATE
     */
    private Forms convert(FormUpdateRequest formUpdateRequest, Forms forms) {
        forms.setName(formUpdateRequest.getName());
        forms.setAlias(formUpdateRequest.getAlias());
        forms.setStatus(formUpdateRequest.getStatus());
        forms.setInactiveReason(formUpdateRequest.getInactiveReason());
        forms.setIsDeleted(Deleted.NO);
        forms.setMenuItems(convertMenuItem(formUpdateRequest.getMenuItem()));
        forms.setActions(convertAction(formUpdateRequest.getActions(),forms));

        return forms;
    }

    /**
     * DELETE
     */
    private Forms convertDelete(Forms forms) {
        forms.setIsDeleted(Deleted.YES);
        return forms;
    }

    /**FORM SAVE RESPONSE CONVERT*/
    private static FormSaveResponse convertFormsSave(Forms forms) {
        DateFormatConverter df = new DateFormatConverter();
        if (forms == null) {
            return null;
        }

        return new FormSaveResponse(forms.getId(), forms.getName(), forms.getAlias(), forms.getStatus(), forms.getInactiveReason(), forms.getCreatedBy(), df.patternDate(forms.getCreatedDateTime()), forms.getModifiedBy(),
                df.patternDate(forms.getModifiedDateTime()));
    }

    //FORM RESPONSE CONVERT
    private static FormsResponse convertForms(Forms forms) {
        DateFormatConverter df = new DateFormatConverter();
        if (forms == null) {
            return null;
        }

        return new FormsResponse(forms.getId(), forms.getName(), forms.getAlias(), convertMenuItem(forms.getMenuItems()),
                convertActionResponse(forms.getActions()), forms.getStatus(), forms.getInactiveReason(), forms.getCreatedBy(), df.patternDate(forms.getCreatedDateTime()), forms.getModifiedBy(),
                df.patternDate(forms.getModifiedDateTime()));
    }


    private AuMenuItems convertMenuItem(MIFormRequest miFormRequest) {
        AuMenuItems menuItem = new AuMenuItems();
        menuItem.setId(miFormRequest.getId());

        return menuItem;
    }

    /**
     * Action List Save Convert
     */
    private static List<Action> convertAction(List<ActionSaveRequest> actions,Forms form) {
        if (actions == null) {
            return null;
        }
        List<Action> actionList = new ArrayList<>();
        for (ActionSaveRequest actionRequest : actions) {
            Action action = new Action();
            action.setId(actionRequest.getId());
            action.setName(actionRequest.getName());
            action.setAlias(actionRequest.getAlias());
            action.setDescription(actionRequest.getDescription());
            action.setInactiveReason("");
            action.setStatus(Status.ACTIVE);
            action.setIsDeleted(Deleted.NO);
            action.setForm(form);
            actionList.add(action);
        }

        return actionList;
    }

    /**
     * Menu Item Convert
     */
    private static MenuItemResponse convertMenuItem(AuMenuItems menuItem) {
        if (menuItem == null) {
            return null;
        }

        DateFormatConverter df = new DateFormatConverter();
        return new MenuItemResponse(menuItem.getId(), menuItem.getName(), menuItem.getAlias(), menuItem.getStatus(),
                menuItem.getInactiveReason(), menuItem.getCreatedBy(), df.patternDate(menuItem.getCreatedDateTime()), menuItem.getModifiedBy(), df.patternDate(menuItem.getModifiedDateTime()));
    }

    /**
     * Action List Convert
     */
    private static List<ActionResponse> convertActionResponse(List<Action> actions) {
        if (actions == null) {
            return null;
        }

        DateFormatConverter df = new DateFormatConverter();
        List<ActionResponse> actionResponses = new ArrayList<>();
        for (Action action : actions) {
            actionResponses.add(new ActionResponse(action.getId(), action.getName(), action.getAlias(), action.getDescription(),convertFormsSave(action.getForm()),
                    action.getStatus(), action.getInactiveReason(), action.getCreatedBy(), df.patternDate(action.getCreatedDateTime()), action.getModifiedBy(), df.patternDate(action.getModifiedDateTime())));
        }

        return actionResponses;
    }
}
