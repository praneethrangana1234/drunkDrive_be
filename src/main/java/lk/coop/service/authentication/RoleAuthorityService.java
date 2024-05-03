package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.RoleAuthoritySaveRequest;
import lk.coop.dto.authentication.request.RoleAuthorityUpdateRequest;
import lk.coop.dto.authentication.response.RoleAuthorityResponse;
import lk.coop.dto.authentication.response.RoleAuthoritySResponse;

import java.util.List;

public interface RoleAuthorityService {

    RoleAuthoritySResponse save(RoleAuthoritySaveRequest roleAuthoritySaveRequest);
    RoleAuthoritySResponse update(RoleAuthorityUpdateRequest request);
    RoleAuthorityResponse getById(Integer id);
    List<RoleAuthoritySResponse> getAll();
    List<RoleAuthoritySResponse> getAllActive();
    RoleAuthoritySResponse delete(Integer id);
}
