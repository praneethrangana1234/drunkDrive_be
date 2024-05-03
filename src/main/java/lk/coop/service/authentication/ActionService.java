package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.ActionSaveRequest;
import lk.coop.dto.authentication.request.ActionUpdateRequest;
import lk.coop.dto.authentication.response.ActionResponse;

import java.util.List;

public interface ActionService {

    ActionResponse save(ActionSaveRequest request);

    ActionResponse update(ActionUpdateRequest request);

    ActionResponse getById(Integer id);

    List<ActionResponse> getAll();

    List<ActionResponse> getAllActive();

    ActionResponse delete(Integer id);
}
