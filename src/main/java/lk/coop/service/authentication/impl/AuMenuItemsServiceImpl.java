package lk.coop.service.authentication.impl;

import lk.coop.dto.authentication.request.AuMenuItemsSaveRequest;
import lk.coop.dto.authentication.request.AuMenuItemsUpdateRequest;
import lk.coop.dto.authentication.response.AuMenuItemsResponse;
import lk.coop.entity.authentication.AuMenuItems;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.authentication.AuMenuItemsRepository;
import lk.coop.service.authentication.AuMenuItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuMenuItemsServiceImpl implements AuMenuItemsService {
    @Autowired
    AuMenuItemsRepository auMenuItemsRepository;

    private static AuMenuItemsResponse convert(AuMenuItems auMenuItems){
        AuMenuItemsResponse auMenuItemsResponse=new AuMenuItemsResponse();

        auMenuItemsResponse.setId(auMenuItems.getId());
        auMenuItemsResponse.setName(auMenuItems.getName());
        auMenuItemsResponse.setAlias(auMenuItems.getAlias());
        auMenuItemsResponse.setCreatedDateTime(auMenuItems.getCreatedDateTime());
        auMenuItemsResponse.setCreatedBy(auMenuItems.getCreatedBy());
        auMenuItemsResponse.setCreatedBy(auMenuItems.getCreatedBy());
        auMenuItemsResponse.setModifiedDateTime(auMenuItems.getModifiedDateTime());
        auMenuItemsResponse.setModifiedBy(auMenuItems.getModifiedBy());
        auMenuItemsResponse.setStatus(auMenuItems.getStatus());
        auMenuItemsResponse.setInactiveReason(auMenuItems.getInactiveReason());
        auMenuItemsResponse.setIsDeleted(auMenuItems.getIsDeleted());

        return auMenuItemsResponse;
    }

    @Override
    public AuMenuItemsResponse save(AuMenuItemsSaveRequest request) {
        AuMenuItems auMenuItems=new AuMenuItems();
        auMenuItems.setName(request.getName());
        auMenuItems.setAlias(request.getAlias());
        auMenuItems.setParentId(request.getParentId());
        auMenuItems.setStatus(Status.ACTIVE);
        auMenuItems.setInactiveReason("");
        auMenuItems.setIsDeleted(Deleted.NO);

        AuMenuItems save=auMenuItemsRepository.save(auMenuItems);
        return convert(save);
    }

    @Override
    public AuMenuItemsResponse update(AuMenuItemsUpdateRequest updateRequest) {
        AuMenuItems auMenuItems=auMenuItemsRepository.getById(updateRequest.getId().toString());
        auMenuItems.setName(updateRequest.getName());
        auMenuItems.setAlias(updateRequest.getAlias());
        auMenuItems.setStatus(updateRequest.getStatus());
        auMenuItems.setInactiveReason(updateRequest.getInactiveReason());

        AuMenuItems updated=auMenuItemsRepository.save(auMenuItems);
        return convert(updated);
    }

    @Override
    public AuMenuItemsResponse delete(Integer id) {
        try {
            AuMenuItems auMenuItems= auMenuItemsRepository.getById(id.toString());
            if (auMenuItems == null) {
                return null;
            }
            AuMenuItems delete = this.auMenuItemsRepository.save(convertDelete(auMenuItems));
            return convert(delete);
        } catch (Exception e) {
            log.error("Error Delete MenuItem {} ", id);
            return null;
        }
    }

    /**
     * DELETE
     */
    private AuMenuItems convertDelete(AuMenuItems menuItems) {
        menuItems.setIsDeleted(Deleted.YES);
        return menuItems;
    }

    @Override
    public AuMenuItemsResponse getById(Integer id) {
        return convert(auMenuItemsRepository.findByIdAndIsDeleted(id,Deleted.NO));
    }

    @Override
    public List<AuMenuItemsResponse> getAllActive() {
        return auMenuItemsRepository.findByStatusAndIsDeletedOrderByIdAsc
                (Status.ACTIVE,Deleted.NO).stream().map(AuMenuItemsServiceImpl::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuMenuItemsResponse> getNotDeleted() {
        return auMenuItemsRepository.findByIsDeletedOrderByIdAsc(Deleted.NO).
                stream().map(AuMenuItemsServiceImpl::convert).collect(Collectors.toList());
    }

    @Override
    public List<AuMenuItemsResponse> findByAlias(String alias) {
        return auMenuItemsRepository.findByAlias(alias).stream().map(AuMenuItemsServiceImpl::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuMenuItemsResponse> findByParentId(String parentId) {
        return auMenuItemsRepository.findByParentIdAndStatusAndIsDeletedOrderByIdAsc
                (parentId,Status.ACTIVE,Deleted.NO).stream().map(AuMenuItemsServiceImpl::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuMenuItemsResponse> navigationMenuItems() {

        return auMenuItemsRepository.findByParentIdIsNullAndStatusAndIsDeletedOrderByIdAsc
                        (Status.ACTIVE,Deleted.NO).stream().map(AuMenuItemsServiceImpl::convert)
                .collect(Collectors.toList());
    }
}
