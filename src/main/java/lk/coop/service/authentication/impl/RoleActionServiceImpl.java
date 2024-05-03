package lk.coop.service.authentication.impl;

import lk.coop.converters.DateFormatConverter;
import lk.coop.dto.authentication.request.*;
import lk.coop.dto.authentication.response.*;
import lk.coop.entity.authentication.*;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.RoleActionRepository;
import lk.coop.service.authentication.RoleActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleActionServiceImpl implements RoleActionService {

    @Autowired
    RoleActionRepository roleAction;

    @Override
    public RoleActionSResponse save(RoleActionSaveRequest roleActionSaveRequest) {
        RoleAction save = roleAction.save(convert(roleActionSaveRequest));
        return convertRoleActionS(save);
    }

    @Override
    public RoleActionSResponse update(RoleActionUpdateRequest request) {
        try {
            RoleAction roleActionReq = this.roleAction.getOne(Deleted.NO, request.getId());

            RoleAction update = this.roleAction.save(convert(request, roleActionReq));
            return convertRoleActionS(update);
        } catch (Exception e) {
            log.error("Error Update RoleAction {} ", request.getId());
            return null;
        }
    }

    @Override
    public RoleActionSResponse delete(Integer id) {
        try {
            RoleAction roleActionReq = this.roleAction.getOne(Deleted.NO, id);
            RoleAction delete = this.roleAction.save(convertDelete(roleActionReq));
            return convertRoleActionS(delete);
        } catch (Exception e) {
            log.error("Error Delete RoleAction {} ", id);
            return null;
        }
    }


    @Override
    public RoleActionResponse getById(Integer id) {
        try {
            return convertRoleAction(roleAction.getOne(Deleted.NO, id));
        } catch (Exception e) {
            log.error("Error getById RoleAction {} ", id);
            return null;
        }

    }

    @Override
    public List<RoleActionSResponse> getAll() {
        return roleAction.findByIsDeleted(Deleted.NO).stream().map(RoleActionServiceImpl::convertRoleActionS).collect(Collectors.toList());
    }

    @Override
    public List<RoleActionSResponse> getAllActive() {
        return roleAction.findByIsDeletedAndStatus(Deleted.NO, Status.ACTIVE).stream().map(RoleActionServiceImpl::convertRoleActionS).collect(Collectors.toList());
    }


    //SAVE
    private RoleAction convert(RoleActionSaveRequest roleActionSaveRequest) {
        RoleAction roleActionSave = new RoleAction();
        roleActionSave.setName(roleActionSaveRequest.getName());
        roleActionSave.setAlias(roleActionSaveRequest.getAlias());
        roleActionSave.setDescription(roleActionSaveRequest.getDescription());
        roleActionSave.setRole(convertRole(roleActionSaveRequest.getRole()));
        roleActionSave.setActions(convertAction(roleActionSaveRequest.getActions()));
        roleActionSave.setInactiveReason("");
        roleActionSave.setStatus(Status.ACTIVE);
        roleActionSave.setIsDeleted(Deleted.NO);

        return roleActionSave;
    }


    /**
     * UPDATE
     */
    private RoleAction convert(RoleActionUpdateRequest roleActionUpdateRequest, RoleAction roleAction) {
        roleAction.setName(roleActionUpdateRequest.getName());
        roleAction.setAlias(roleActionUpdateRequest.getAlias());
        roleAction.setDescription(roleActionUpdateRequest.getDescription());
        roleAction.setRole(convertRole(roleActionUpdateRequest.getRole()));
        roleAction.setActions(convertAction(roleActionUpdateRequest.getActions()));
        roleAction.setStatus(roleActionUpdateRequest.getStatus());
        roleAction.setInactiveReason(roleActionUpdateRequest.getInactiveReason());

        roleAction.setIsDeleted(Deleted.NO);

        return roleAction;
    }

    /**
     * DELETE
     */
    private RoleAction convertDelete(RoleAction roleAction) {
        roleAction.setIsDeleted(Deleted.YES);
        return roleAction;
    }


    /**
     * SAVE
     * Actions List Save Convert
     */
    private static List<Action> convertAction(Set<ActFormRequest> actions) {
        if (actions == null) {
            return null;
        }
        List<Action> actionList = new ArrayList<>();
        for (ActFormRequest actFormRequest : actions) {
            Action action = new Action();
            action.setId(actFormRequest.getId());
            actionList.add(action);
        }

        return actionList;
    }

    /**
     * SAVE
     * ROLE Save Convert
     */
    private Role convertRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setId(roleRequest.getId());

        return role;
    }

    /**
     * RESPONSE
     */

    private static RoleResponse convertRoleResponse(Role role) {
        if (role == null) {
            return null;
        }
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        roleResponse.setDescription(role.getDescription());
        return roleResponse;
    }

    /**
     * ACTION List Convert
     */
    private static List<ActionResponse> convertActionResponse(List<Action> actions) {
        if (actions == null) {
            return null;
        }

        DateFormatConverter df = new DateFormatConverter();
        List<ActionResponse> actionResponses = new ArrayList<>();
        for (Action action : actions) {
            actionResponses.add(new ActionResponse(action.getId(), action.getName(), action.getAlias(), action.getDescription(),
                    convertFormsSave(action.getForm()), action.getStatus(), action.getInactiveReason(), action.getCreatedBy(), df.patternDate(action.getCreatedDateTime()), action.getModifiedBy(), df.patternDate(action.getModifiedDateTime())));
        }

        return actionResponses;
    }

    /**
     * ROLE ACTION RESPONSE CONVERT
     */
    private static RoleActionSResponse convertRoleActionS(RoleAction roleAction) {
        DateFormatConverter df = new DateFormatConverter();
        if (roleAction == null) {
            return null;
        }

        return new RoleActionSResponse(roleAction.getId(), roleAction.getName(), roleAction.getAlias(), roleAction.getDescription(), roleAction.getStatus(), roleAction.getInactiveReason(),
                roleAction.getCreatedBy(), df.patternDate(roleAction.getCreatedDateTime()), roleAction.getModifiedBy(),
                df.patternDate(roleAction.getModifiedDateTime()));
    }

    /**
     * ROLE ACTION DETAILS RESPONSE CONVERT
     */
    private static RoleActionResponse convertRoleAction(RoleAction roleAction) {
        DateFormatConverter df = new DateFormatConverter();
        if (roleAction == null) {
            return null;
        }

        return new RoleActionResponse(roleAction.getId(), roleAction.getName(), roleAction.getDescription(), roleAction.getAlias(),
                convertRoleResponse(roleAction.getRole()), convertActionResponse(roleAction.getActions()), roleAction.getStatus(), roleAction.getInactiveReason(),
                roleAction.getCreatedBy(), df.patternDate(roleAction.getCreatedDateTime()), roleAction.getModifiedBy(),
                df.patternDate(roleAction.getModifiedDateTime()));
    }

    /**
     * FORM SAVE RESPONSE CONVERT
     */
    private static FormSaveResponse convertFormsSave(Forms forms) {
        DateFormatConverter df = new DateFormatConverter();
        if (forms == null) {
            return null;
        }

        return new FormSaveResponse(forms.getId(), forms.getName(), forms.getAlias(), forms.getStatus(), forms.getInactiveReason(), forms.getCreatedBy(), df.patternDate(forms.getCreatedDateTime()), forms.getModifiedBy(),
                df.patternDate(forms.getModifiedDateTime()));
    }
}
