package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.RoleMItemSaveRequest;
import lk.coop.dto.authentication.request.RoleMItemUpdateRequest;
import lk.coop.dto.authentication.response.RoleMItemResponse;
import lk.coop.dto.authentication.response.RoleMItemSResponse;

import java.util.List;

public interface RoleMItemService {

    RoleMItemSResponse save(RoleMItemSaveRequest request);

    RoleMItemSResponse update(RoleMItemUpdateRequest request);

    RoleMItemResponse getById(Integer id);

    List<RoleMItemSResponse> getAll();

    List<RoleMItemSResponse> getAllActive();

    RoleMItemSResponse delete(Integer id);
}
