package lk.coop.service.authentication;



import lk.coop.dto.authentication.request.AuthoritySaveRequest;
import lk.coop.dto.authentication.request.AuthorityUpdateRequest;
import lk.coop.dto.authentication.response.AuthorityResponse;

import java.util.List;

public interface AuthorityService {

    AuthorityResponse save(AuthoritySaveRequest authoritySaveRequest);

    AuthorityResponse update(AuthorityUpdateRequest request);

    AuthorityResponse getById(Integer id);

    List<AuthorityResponse> getAll();

    List<AuthorityResponse> getAllActive();

    AuthorityResponse delete(Integer id);
}
