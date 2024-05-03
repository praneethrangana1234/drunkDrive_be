package lk.coop.service.authentication;


import lk.coop.dto.authentication.request.RoleActionSaveRequest;
import lk.coop.dto.authentication.request.RoleActionUpdateRequest;
import lk.coop.dto.authentication.request.RoleMItemSaveRequest;
import lk.coop.dto.authentication.request.RoleMItemUpdateRequest;
import lk.coop.dto.authentication.response.RoleActionResponse;
import lk.coop.dto.authentication.response.RoleActionSResponse;
import lk.coop.dto.authentication.response.RoleMItemResponse;
import lk.coop.dto.authentication.response.RoleMItemSResponse;

import java.util.List;

public interface RoleActionService {

    RoleActionSResponse save(RoleActionSaveRequest request);

    RoleActionSResponse update(RoleActionUpdateRequest request);

    RoleActionResponse getById(Integer id);

    List<RoleActionSResponse> getAll();

    List<RoleActionSResponse> getAllActive();

    RoleActionSResponse delete(Integer id);
}
