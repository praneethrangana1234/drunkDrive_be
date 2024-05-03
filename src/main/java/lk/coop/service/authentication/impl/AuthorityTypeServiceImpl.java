package lk.coop.service.authentication.impl;

import lk.coop.converters.DateFormatConverter;
import lk.coop.dto.authentication.request.AuthorityTypeSaveRequest;
import lk.coop.dto.authentication.request.AuthorityTypeUpdateRequest;
import lk.coop.dto.authentication.response.AuthorityTypeResponse;
import lk.coop.entity.authentication.AuthorityType;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.AuthorityTypeRepository;
import lk.coop.service.authentication.AuthorityTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthorityTypeServiceImpl implements AuthorityTypeService {

    @Autowired
    AuthorityTypeRepository authorityType;

    @Override
    public AuthorityTypeResponse save(AuthorityTypeSaveRequest request) {
        AuthorityType save = this.authorityType.save(convert(request));
        return convertAuthorityType(save);
    }

    @Override
    public AuthorityTypeResponse update(AuthorityTypeUpdateRequest request) {
        try {
            AuthorityType authorityTypeReq = this.authorityType.getOne(Deleted.NO,request.getId());
            AuthorityType update = this.authorityType.save(convert(request, authorityTypeReq));
            return convertAuthorityType(update);
        } catch (Exception e) {
            log.error("Error Update AuthorityType {} ",request.getId());
            return null;
        }
    }

    @Override
    public AuthorityTypeResponse delete(Integer id) {
        try {
            AuthorityType authorityTypeReq = this.authorityType.getOne(Deleted.NO,id);
            AuthorityType delete = this.authorityType.save(convertDelete(authorityTypeReq));
            return convertAuthorityType(delete);
        } catch (Exception e) {
            log.error("Error Delete AuthorityType {} ",id);
            return null;
        }
    }


    @Override
    public AuthorityTypeResponse getById(Integer id) {
        try {
            return convertAuthorityType(authorityType.getOne(Deleted.NO, id));
        } catch (Exception e) {
            log.error("Error getById AuthorityType {} ",id);
            return null;
        }

    }

    @Override
    public List<AuthorityTypeResponse> getAll() {
        return authorityType.findByIsDeleted(Deleted.NO).stream().map(AuthorityTypeServiceImpl::convertAuthorityType).collect(Collectors.toList());
    }

    @Override
    public List<AuthorityTypeResponse> getAllActive() {
        return authorityType.findByIsDeletedAndStatus(Deleted.NO,Status.ACTIVE).stream().map(AuthorityTypeServiceImpl::convertAuthorityType).collect(Collectors.toList());
    }



    //SAVE
    private AuthorityType convert(AuthorityTypeSaveRequest authorityTypeSaveRequest) {
        AuthorityType authorityTypeReq = new AuthorityType();
        authorityTypeReq.setName(authorityTypeSaveRequest.getName());
        authorityTypeReq.setDescription(authorityTypeSaveRequest.getDescription());
        authorityTypeReq.setStatus(Status.ACTIVE);
        authorityTypeReq.setInactiveReason("");
        authorityTypeReq.setIsDeleted(Deleted.NO);

        return authorityTypeReq;
    }


    /**
     * UPDATE
     */
    private AuthorityType convert(AuthorityTypeUpdateRequest authorityTypeUpdateRequest, AuthorityType authorityType) {
        authorityType.setName(authorityTypeUpdateRequest.getName());
        authorityType.setDescription(authorityTypeUpdateRequest.getDescription());
        authorityType.setStatus(authorityTypeUpdateRequest.getStatus());
        authorityType.setInactiveReason((authorityTypeUpdateRequest.getStatus().equals(Status.INACTIVE)) ? authorityTypeUpdateRequest.getInactiveReason() :  "");
        authorityType.setIsDeleted(Deleted.NO);

        return authorityType;
    }

    /**
     * DELETE
     */
    private AuthorityType convertDelete(AuthorityType authorityType) {
        authorityType.setIsDeleted(Deleted.YES);
        return authorityType;
    }


    //AUTHORITY RESPONSE CONVERT
    private static AuthorityTypeResponse convertAuthorityType(AuthorityType authorityType) {
        DateFormatConverter df=new DateFormatConverter();
        if (authorityType == null) {
            return null;
        }

        return new AuthorityTypeResponse(authorityType.getId(),authorityType.getName(),authorityType.getDescription(),
                authorityType.getStatus(),authorityType.getInactiveReason(),authorityType.getCreatedBy(),
                df.patternDate(authorityType.getCreatedDateTime()),authorityType.getModifiedBy(),
                df.patternDate(authorityType.getModifiedDateTime()));
    }
}
