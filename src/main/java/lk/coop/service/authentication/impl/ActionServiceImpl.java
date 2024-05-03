package lk.coop.service.authentication.impl;

import lk.coop.converters.DateFormatConverter;
import lk.coop.dto.authentication.request.ActionSaveRequest;
import lk.coop.dto.authentication.request.ActionUpdateRequest;
import lk.coop.dto.authentication.response.ActionResponse;
import lk.coop.dto.authentication.response.FormSaveResponse;
import lk.coop.entity.authentication.Action;
import lk.coop.entity.authentication.Forms;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.ActionRepository;
import lk.coop.service.authentication.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionRepository action;

    @Override
    public ActionResponse save(ActionSaveRequest actionSaveRequest) {
        Action save = action.save(convert(actionSaveRequest));
        return convertAction(save);
    }

    @Override
    public ActionResponse update(ActionUpdateRequest request) {
        try {
            Action actionReq = this.action.getOne(Deleted.NO,request.getId());

            Action update = this.action.save(convert(request, actionReq));
            return convertAction(update);
        } catch (Exception e) {
            log.error("Error Update Action {} ",request.getId());
            return null;
        }
    }

    @Override
    public ActionResponse delete(Integer id) {
        try {
            Action actionReq = this.action.getOne(Deleted.NO,id);
            Action delete = this.action.save(convertDelete(actionReq));
            return convertAction(delete);
        } catch (Exception e) {
            log.error("Error Delete Action {} ",id);
            return null;
        }
    }


    @Override
    public ActionResponse getById(Integer id) {
        try {
            return convertAction(action.getOne(Deleted.NO, id));
        } catch (Exception e) {
            System.out.println(e);
            log.error("Error getById Action {} ",id);
            return null;
        }

    }

    @Override
    public List<ActionResponse> getAll() {
        return action.findByIsDeleted(Deleted.NO).stream().map(ActionServiceImpl::convertAction).collect(Collectors.toList());
    }

    @Override
    public List<ActionResponse> getAllActive() {
        return action.findByIsDeletedAndStatus(Deleted.NO,Status.ACTIVE).stream().map(ActionServiceImpl::convertAction).collect(Collectors.toList());
    }



    //SAVE
    private Action convert(ActionSaveRequest actionSaveRequest) {
        Action actionSave = new Action();
        actionSave.setName(actionSaveRequest.getName());
        actionSave.setAlias(actionSaveRequest.getAlias());
        actionSave.setDescription(actionSaveRequest.getDescription());
        actionSave.setInactiveReason("");
        actionSave.setStatus(Status.ACTIVE);
        actionSave.setIsDeleted(Deleted.NO);

        return actionSave;
    }


    /**
     * UPDATE
     */
    private Action convert(ActionUpdateRequest actionUpdateRequest, Action action) {
        action.setName(actionUpdateRequest.getName());
        action.setAlias(actionUpdateRequest.getAlias());
        action.setDescription(actionUpdateRequest.getDescription());
        action.setStatus(actionUpdateRequest.getStatus());
        action.setInactiveReason(actionUpdateRequest.getInactiveReason());

        action.setIsDeleted(Deleted.NO);

        return action;
    }

    /**
     * DELETE
     */
    private Action convertDelete(Action action) {
        action.setIsDeleted(Deleted.YES);
        return action;
    }


    //AUTHORITY RESPONSE CONVERT
    private static ActionResponse convertAction(Action action) {
        DateFormatConverter df=new DateFormatConverter();
        if (action == null) {
            return null;
        }

        return new ActionResponse(action.getId(),action.getName(),action.getAlias(),action.getDescription(),convertForms(action.getForm()),action.getStatus(),action.getInactiveReason(),
                action.getCreatedBy(),df.patternDate(action.getCreatedDateTime()),action.getModifiedBy(),
                df.patternDate(action.getModifiedDateTime()));
    }

    //FORM RESPONSE CONVERT
    private static FormSaveResponse convertForms(Forms form) {
        DateFormatConverter df=new DateFormatConverter();
        if (form == null) {
            return null;
        }

        return new FormSaveResponse(form.getId(),form.getName(),form.getAlias(),form.getStatus(),form.getInactiveReason(),
                form.getCreatedBy(),df.patternDate(form.getCreatedDateTime()),form.getModifiedBy(),
                df.patternDate(form.getModifiedDateTime()));
    }
}
