package lk.coop.service.authentication.impl;

import lk.coop.converters.DateFormatConverter;

import lk.coop.dto.authentication.request.AuthoritySaveRequest;
import lk.coop.dto.authentication.request.AuthorityTypeRequest;
import lk.coop.dto.authentication.request.AuthorityUpdateRequest;
import lk.coop.dto.authentication.request.MIFormRequest;
import lk.coop.dto.authentication.response.AuthorityResponse;
import lk.coop.dto.authentication.response.AuthorityTypeResponse;
import lk.coop.dto.authentication.response.MenuItemResponse;
import lk.coop.entity.authentication.AuMenuItems;
import lk.coop.entity.authentication.Authority;
import lk.coop.entity.authentication.AuthorityType;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.AuthorityRepository;
import lk.coop.service.authentication.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authority;

    @Override
    public AuthorityResponse save(AuthoritySaveRequest authoritySaveRequest) {
        Authority save = authority.save(convert(authoritySaveRequest));
        return convertAuthority(save);
    }

    @Override
    public AuthorityResponse update(AuthorityUpdateRequest request) {
        try {
            Authority authorityReq = this.authority.getOne(Deleted.NO, request.getId());
            Authority update = this.authority.save(convert(request, authorityReq));
            return convertAuthority(update);
        } catch (Exception e) {
            log.error("Error Update Authority {} ", request.getId());
            return null;
        }
    }

    @Override
    public AuthorityResponse delete(Integer id) {
        try {
            Authority authorityReq = this.authority.getOne(Deleted.NO, id);
            Authority delete = this.authority.save(convertDelete(authorityReq));
            return convertAuthority(delete);
        } catch (Exception e) {
            log.error("Error Delete Authority {} ", id);
            return null;
        }
    }


    @Override
    public AuthorityResponse getById(Integer id) {
        try {
            return convertAuthority(authority.getOne(Deleted.NO, id));
        } catch (Exception e) {
            log.error("Error getById Authority {} ", id);
            return null;
        }

    }

    @Override
    public List<AuthorityResponse> getAll() {
        return authority.findByIsDeleted(Deleted.NO).stream().map(AuthorityServiceImpl::convertAuthority).collect(Collectors.toList());
    }

    @Override
    public List<AuthorityResponse> getAllActive() {
        return authority.findByIsDeletedAndStatus(Deleted.NO, Status.ACTIVE).stream().map(AuthorityServiceImpl::convertAuthority).collect(Collectors.toList());
    }


    //SAVE
    private Authority convert(AuthoritySaveRequest authoritySaveRequest) {
        Authority authorityReq = new Authority();
        authorityReq.setAuthorityType(convertAuthorityType(authoritySaveRequest.getAuthorityType()));
        authorityReq.setAuthLimit(authoritySaveRequest.getLimit());
        authorityReq.setEffectiveFrom(authoritySaveRequest.getEffectiveFrom());
        authorityReq.setEffectiveTo(authoritySaveRequest.getEffectiveTo());
        authorityReq.setInactiveReason("");
        authorityReq.setStatus(Status.ACTIVE);
        authorityReq.setIsDeleted(Deleted.NO);

        return authorityReq;
    }


    /**
     * UPDATE
     */
    private Authority convert(AuthorityUpdateRequest authorityUpdateRequest, Authority authority) {
        authority.setAuthorityType(convertAuthorityType(authorityUpdateRequest.getAuthorityType()));
        authority.setAuthLimit(authorityUpdateRequest.getLimit());
        authority.setEffectiveFrom(authorityUpdateRequest.getEffectiveFrom());
        authority.setEffectiveTo(authorityUpdateRequest.getEffectiveTo());
        authority.setStatus(authorityUpdateRequest.getStatus());
        authority.setInactiveReason((authorityUpdateRequest.getStatus().equals(Status.INACTIVE)) ? authorityUpdateRequest.getInactiveReason() : "");
        authority.setIsDeleted(Deleted.NO);

        return authority;
    }

    /**
     * DELETE
     */
    private Authority convertDelete(Authority authority) {
        authority.setIsDeleted(Deleted.YES);
        return authority;
    }

    /**
     * CONVERT AUTHORITY TYPE
     */
    private AuthorityType convertAuthorityType(AuthorityTypeRequest authorityTypeRequest) {
        AuthorityType authorityType = new AuthorityType();
        authorityType.setId(authorityTypeRequest.getId());

        return authorityType;
    }

    /**
     * AUTHORITY TYPE RESPONSE Convert
     */
    private static AuthorityTypeResponse convertAuthorityType(AuthorityType authorityType) {
        if (authorityType == null) {
            return null;
        }

        DateFormatConverter df = new DateFormatConverter();
        return new AuthorityTypeResponse(authorityType.getId(), authorityType.getName(), authorityType.getDescription(), authorityType.getStatus(),
                authorityType.getInactiveReason(), authorityType.getCreatedBy(), (authorityType.getCreatedDateTime() != null) ? df.patternDate(authorityType.getCreatedDateTime()) : "", authorityType.getModifiedBy(), (authorityType.getCreatedDateTime() != null) ? df.patternDate(authorityType.getModifiedDateTime()) : "");
    }


    //AUTHORITY RESPONSE CONVERT
    private static AuthorityResponse convertAuthority(Authority authority) {
        DateFormatConverter df = new DateFormatConverter();
        if (authority == null) {
            return null;
        }

        return new AuthorityResponse(authority.getId(), convertAuthorityType(authority.getAuthorityType()), authority.getAuthLimit(),df.patternDate(authority.getEffectiveFrom()),
                df.patternDate(authority.getEffectiveTo()), authority.getStatus(), authority.getInactiveReason(),
                authority.getCreatedBy(), df.patternDate(authority.getCreatedDateTime()), authority.getModifiedBy(),
                df.patternDate(authority.getModifiedDateTime()));
    }
}
