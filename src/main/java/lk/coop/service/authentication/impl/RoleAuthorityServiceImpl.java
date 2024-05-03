package lk.coop.service.authentication.impl;


import lk.coop.dto.authentication.request.AuthorityRoleSaveRequest;
import lk.coop.dto.authentication.request.RoleAuthoritySaveRequest;
import lk.coop.dto.authentication.request.RoleAuthorityUpdateRequest;
import lk.coop.dto.authentication.request.RoleRequest;
import lk.coop.dto.authentication.response.AuthorityRoleResponse;
import lk.coop.dto.authentication.response.RoleAuthorityResponse;
import lk.coop.dto.authentication.response.RoleAuthoritySResponse;
import lk.coop.dto.authentication.response.RoleResponse;
import lk.coop.entity.authentication.Authority;
import lk.coop.entity.authentication.Role;
import lk.coop.entity.authentication.RoleAuthority;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.RoleAuthorityRepository;
import lk.coop.service.authentication.RoleAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

    @Autowired
    RoleAuthorityRepository roleAuthority;


    @Override
    public RoleAuthoritySResponse save(RoleAuthoritySaveRequest roleAuthoritySaveRequest) {
        try {
            RoleAuthority save = this.roleAuthority.save(convert(roleAuthoritySaveRequest));
            return convertRoleAuthoritySave(save);
        } catch (Exception e) {
            log.error("Error Save RoleAuthority {} ", roleAuthoritySaveRequest.getName());
            return null;
        }


    }

    @Override
    public RoleAuthoritySResponse update(RoleAuthorityUpdateRequest request) {
        try {
            RoleAuthority roleAuthorityReq = this.roleAuthority.getOne(Deleted.NO, request.getId());
            RoleAuthority update = this.roleAuthority.save(convertUpdate(request, roleAuthorityReq));
            return convertRoleAuthoritySave(update);
        } catch (Exception e) {
            log.error("Error Update RoleAuthority {} ", request.getId());
            return null;
        }
    }

    @Override
    public RoleAuthorityResponse getById(Integer id) {
        try {
            return convertRoleAuthority(this.roleAuthority.getOne(Deleted.NO, id));
        } catch (Exception e) {
            log.error("Error getById RoleAuthority {} ", id);
            return null;
        }
    }

    @Override
    public List<RoleAuthoritySResponse> getAll() {
        return roleAuthority.findByIsDeleted(Deleted.NO).stream().map(RoleAuthorityServiceImpl::convertRoleAuthoritySave).collect(Collectors.toList());
    }

    @Override
    public List<RoleAuthoritySResponse> getAllActive() {
        return roleAuthority.findByIsDeletedAndStatus(Deleted.NO, Status.ACTIVE).stream().map(RoleAuthorityServiceImpl::convertRoleAuthoritySave).collect(Collectors.toList());
    }

    @Override
    public RoleAuthoritySResponse delete(Integer id) {
        try {
            RoleAuthority roleAuthorityReq = this.roleAuthority.getOne(Deleted.NO, id);
            RoleAuthority delete = this.roleAuthority.save(convertDelete(roleAuthorityReq));
            return convertRoleAuthoritySave(delete);
        } catch (Exception e) {
            log.error("Error Delete RoleAuthority {} ", id);
            return null;
        }
    }

    /**
     * SAVE
     */
    private RoleAuthority convert(RoleAuthoritySaveRequest roleAuthoritySaveRequest) {
        RoleAuthority roleAuthority = new RoleAuthority();
        roleAuthority.setName(roleAuthoritySaveRequest.getName());
        roleAuthority.setDescription(roleAuthoritySaveRequest.getDescription());
        roleAuthority.setRole(convertRole(roleAuthoritySaveRequest.getRole()));
        roleAuthority.setInactiveReason("");
        roleAuthority.setStatus(Status.ACTIVE);
        roleAuthority.setIsDeleted(Deleted.NO);
        roleAuthority.setAuthorities(convertAuthoritySave(roleAuthoritySaveRequest.getAuthorities()));

        return roleAuthority;
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

    private List<Authority> convertAuthoritySave(List<AuthorityRoleSaveRequest> authorityRoleSaveRequests) {

        List<Authority> authorities = new ArrayList<>();
        for (AuthorityRoleSaveRequest authorityRoleSaveRequest : authorityRoleSaveRequests) {
            Authority authority = new Authority();
            authority.setId(authorityRoleSaveRequest.getId());

            authorities.add(authority);
        }

        return authorities;
    }

    /**
     * UPDATE
     */
    private RoleAuthority convertUpdate(RoleAuthorityUpdateRequest roleAuthorityUpdateRequest, RoleAuthority roleAuthority) {
        roleAuthority.setName(roleAuthorityUpdateRequest.getName());
        roleAuthority.setDescription(roleAuthorityUpdateRequest.getDescription());
        roleAuthority.setRole(convertRole(roleAuthorityUpdateRequest.getRole()));
        roleAuthority.setInactiveReason(roleAuthorityUpdateRequest.getInactiveReason());
        roleAuthority.setStatus(roleAuthorityUpdateRequest.getStatus());
        roleAuthority.setIsDeleted(Deleted.NO);
        roleAuthority.setAuthorities(convertAuthoritySave(roleAuthorityUpdateRequest.getAuthorities()));

        return roleAuthority;
    }

    /**
     * DELETE
     */
    private RoleAuthority convertDelete(RoleAuthority roleAuthority) {
        roleAuthority.setIsDeleted(Deleted.YES);
        return roleAuthority;
    }

    /**
     * VIEW LIST
     */
    private static RoleAuthorityResponse convertRoleAuthority(RoleAuthority roleAuthority) {
        if (roleAuthority == null) {
            return null;
        }

        return new RoleAuthorityResponse(roleAuthority.getId(), roleAuthority.getName(), roleAuthority.getDescription(),
                convertRoleResponse(roleAuthority.getRole()), convertAuthorityRole(roleAuthority.getAuthorities()), roleAuthority.getStatus(), roleAuthority.getInactiveReason(), roleAuthority.getCreatedBy(), roleAuthority.getCreatedDateTime(), roleAuthority.getModifiedBy(), roleAuthority.getModifiedDateTime());
    }

    /**
     * SAVE AND UPDATE RESPONSE
     */
    private static RoleAuthoritySResponse convertRoleAuthoritySave(RoleAuthority roleAuthority) {
        if (roleAuthority == null) {
            return null;
        }

        return new RoleAuthoritySResponse(roleAuthority.getId(), roleAuthority.getName(), roleAuthority.getDescription(),
                roleAuthority.getStatus(), roleAuthority.getInactiveReason(), roleAuthority.getCreatedBy(), roleAuthority.getCreatedDateTime(),
                roleAuthority.getModifiedBy(), roleAuthority.getModifiedDateTime());
    }

    private static Set<AuthorityRoleResponse> convertAuthorityRole(List<Authority> authorities) {
        Set<AuthorityRoleResponse> authorityRoleResponses = new HashSet<>();
        for (Authority authority : authorities) {
            AuthorityRoleResponse authorityRoleResponse = new AuthorityRoleResponse();
            authorityRoleResponse.setId(authority.getId());
            authorityRoleResponse.setLimit(authority.getAuthLimit());
            authorityRoleResponse.setEffectiveFrom(authority.getEffectiveFrom());
            authorityRoleResponse.setEffectiveTo(authority.getEffectiveTo());
            authorityRoleResponse.setStatus(authority.getStatus());
            authorityRoleResponse.setInactiveReason(authority.getInactiveReason());
            authorityRoleResponses.add(authorityRoleResponse);
        }

        return authorityRoleResponses;
    }

    /**
     * RESPONSE
     */

    private static RoleResponse convertRoleResponse(Role role) {
        if (role == null) {
            return null;
        }
        RoleResponse roleResponse=new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        roleResponse.setDescription(role.getDescription());

        return roleResponse;
    }


}
