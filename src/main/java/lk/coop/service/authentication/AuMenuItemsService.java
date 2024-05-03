package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.AuMenuItemsSaveRequest;
import lk.coop.dto.authentication.request.AuMenuItemsUpdateRequest;
import lk.coop.dto.authentication.response.AuMenuItemsResponse;

import java.util.List;

public interface AuMenuItemsService {
    AuMenuItemsResponse save(AuMenuItemsSaveRequest request);

    AuMenuItemsResponse update(AuMenuItemsUpdateRequest updateRequest);

    AuMenuItemsResponse delete(Integer id);

    AuMenuItemsResponse getById(Integer id);

    List<AuMenuItemsResponse> getAllActive();

    List<AuMenuItemsResponse> getNotDeleted();

    List<AuMenuItemsResponse> findByAlias(String alias);

    List<AuMenuItemsResponse> findByParentId(String parentId);

    List<AuMenuItemsResponse> navigationMenuItems();

//    List<AuMenuItemsResponse> findByRoleId(String roleId);
//
//    List<AuMenuItemsResponse> findByParentAndRoleIds(String roleId,String parentId);
}
