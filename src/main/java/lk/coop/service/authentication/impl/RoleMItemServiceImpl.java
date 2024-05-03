package lk.coop.service.authentication.impl;

import lk.coop.converters.DateFormatConverter;
import lk.coop.dto.authentication.request.*;
import lk.coop.dto.authentication.response.*;
import lk.coop.entity.authentication.AuMenuItems;
import lk.coop.entity.authentication.Role;
import lk.coop.entity.authentication.RoleMItem;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.RoleMItemRepository;
import lk.coop.service.authentication.RoleMItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleMItemServiceImpl implements RoleMItemService {

    @Autowired
    RoleMItemRepository roleMItem;

    @Override
    public RoleMItemSResponse save(RoleMItemSaveRequest roleMItemSaveRequest) {
        RoleMItem save = roleMItem.save(convert(roleMItemSaveRequest));
        return convertRoleMItemS(save);
    }

    @Override
    public RoleMItemSResponse update(RoleMItemUpdateRequest request) {
        try {
            RoleMItem roleMItemReq = this.roleMItem.getOne(Deleted.NO,request.getId());

            RoleMItem update = this.roleMItem.save(convert(request, roleMItemReq));
            return convertRoleMItemS(update);
        } catch (Exception e) {
            log.error("Error Update RoleMItem {} ",request.getId());
            return null;
        }
    }

    @Override
    public RoleMItemSResponse delete(Integer id) {
        try {
            RoleMItem roleMItemReq = this.roleMItem.getOne(Deleted.NO,id);
            RoleMItem delete = this.roleMItem.save(convertDelete(roleMItemReq));
            return convertRoleMItemS(delete);
        } catch (Exception e) {
            log.error("Error Delete RoleMItem {} ",id);
            return null;
        }
    }


    @Override
    public RoleMItemResponse getById(Integer id) {
        try {
            return convertRoleMItem(roleMItem.getOne(Deleted.NO, id));
        } catch (Exception e) {
            log.error("Error getById RoleMItem {} ",id);
            return null;
        }

    }

    @Override
    public List<RoleMItemSResponse> getAll() {
        return roleMItem.findByIsDeleted(Deleted.NO).stream().map(RoleMItemServiceImpl::convertRoleMItemS).collect(Collectors.toList());
    }

    @Override
    public List<RoleMItemSResponse> getAllActive() {
        return roleMItem.findByIsDeletedAndStatus(Deleted.NO,Status.ACTIVE).stream().map(RoleMItemServiceImpl::convertRoleMItemS).collect(Collectors.toList());
    }



    //SAVE
    private RoleMItem convert(RoleMItemSaveRequest roleMItemSaveRequest) {
        RoleMItem roleMItemSave = new RoleMItem();
        roleMItemSave.setName(roleMItemSaveRequest.getName());
        roleMItemSave.setDescription(roleMItemSaveRequest.getDescription());
        roleMItemSave.setRole(convertRole(roleMItemSaveRequest.getRole()));
        roleMItemSave.setMenuItems(convertMenuItem(roleMItemSaveRequest.getMenuItems()));
        roleMItemSave.setInactiveReason("");
        roleMItemSave.setStatus(Status.ACTIVE);
        roleMItemSave.setIsDeleted(Deleted.NO);

        return roleMItemSave;
    }


    /**
     * UPDATE
     */
    private RoleMItem convert(RoleMItemUpdateRequest roleMItemUpdateRequest, RoleMItem roleMItem) {
        roleMItem.setName(roleMItemUpdateRequest.getName());
        roleMItem.setDescription(roleMItemUpdateRequest.getDescription());
        roleMItem.setRole(convertRole(roleMItemUpdateRequest.getRole()));
        roleMItem.setMenuItems(convertMenuItem(roleMItemUpdateRequest.getMenuItems()));
        roleMItem.setStatus(roleMItemUpdateRequest.getStatus());
        roleMItem.setInactiveReason(roleMItemUpdateRequest.getInactiveReason());

        roleMItem.setIsDeleted(Deleted.NO);

        return roleMItem;
    }

    /**
     * DELETE
     */
    private RoleMItem convertDelete(RoleMItem roleMItem) {
        roleMItem.setIsDeleted(Deleted.YES);
        return roleMItem;
    }


    /** SAVE
     * AuMenuItems List Save Convert
     */
    private static List<AuMenuItems> convertMenuItem(Set<MIFormRequest> menuItems) {
        if (menuItems == null) {
            return null;
        }
        List<AuMenuItems> menuItemsList = new ArrayList<>();
        for (MIFormRequest menuItemReq : menuItems) {
            AuMenuItems menuItem = new AuMenuItems();
            menuItem.setId(menuItemReq.getId());
            menuItemsList.add(menuItem);
        }

        return menuItemsList;
    }

    /** SAVE
     * ROLE Save Convert
     */
    private Role convertRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setId(roleRequest.getId());

        return role;
    }

    /**
     * RESPONSE
     * */

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
     * MenuItem List Convert
     */
    private static List<MenuItemResponse> convertMenuItemResponse(List<AuMenuItems> menuItems) {
        if (menuItems == null) {
            return null;
        }

        DateFormatConverter df = new DateFormatConverter();
        List<MenuItemResponse> menuItemResponses = new ArrayList<>();
        for (AuMenuItems menuItem : menuItems) {
            menuItemResponses.add(new MenuItemResponse(menuItem.getId(), menuItem.getName(), menuItem.getAlias(),
                    menuItem.getStatus(), menuItem.getInactiveReason(), menuItem.getCreatedBy(), df.patternDate(menuItem.getCreatedDateTime()), menuItem.getModifiedBy(), df.patternDate(menuItem.getModifiedDateTime())));
        }

        return menuItemResponses;
    }

    /**
     * ROLEMITEM RESPONSE CONVERT
     */
    private static RoleMItemSResponse convertRoleMItemS(RoleMItem roleMItem) {
        DateFormatConverter df=new DateFormatConverter();
        if (roleMItem == null) {
            return null;
        }

        return new RoleMItemSResponse(roleMItem.getId(),roleMItem.getName(),roleMItem.getDescription(),roleMItem.getStatus(),roleMItem.getInactiveReason(),
                roleMItem.getCreatedBy(),df.patternDate(roleMItem.getCreatedDateTime()),roleMItem.getModifiedBy(),
                df.patternDate(roleMItem.getModifiedDateTime()));
    }

    /**
     * ROLEMITEM DETAILS RESPONSE CONVERT
     */
    private static RoleMItemResponse convertRoleMItem(RoleMItem roleMItem) {
        DateFormatConverter df=new DateFormatConverter();
        if (roleMItem == null) {
            return null;
        }

        return new RoleMItemResponse(roleMItem.getId(),roleMItem.getName(),roleMItem.getDescription(),
                convertRoleResponse(roleMItem.getRole()), convertMenuItemResponse(roleMItem.getMenuItems()),roleMItem.getStatus(),roleMItem.getInactiveReason(),
                roleMItem.getCreatedBy(),df.patternDate(roleMItem.getCreatedDateTime()),roleMItem.getModifiedBy(),
                df.patternDate(roleMItem.getModifiedDateTime()));
    }
}
