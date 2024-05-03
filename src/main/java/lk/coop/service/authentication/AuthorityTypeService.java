package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.AuthorityTypeSaveRequest;
import lk.coop.dto.authentication.request.AuthorityTypeUpdateRequest;
import lk.coop.dto.authentication.response.AuthorityTypeResponse;

import java.util.List;

public interface AuthorityTypeService {

    AuthorityTypeResponse save(AuthorityTypeSaveRequest authoritySaveRequest);

    AuthorityTypeResponse update(AuthorityTypeUpdateRequest request);

    AuthorityTypeResponse getById(Integer id);

    List<AuthorityTypeResponse> getAll();

    List<AuthorityTypeResponse> getAllActive();

    AuthorityTypeResponse delete(Integer id);
}
