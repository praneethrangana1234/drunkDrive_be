package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data; import lk.coop.enums.*;

import javax.validation.Valid;
import java.util.List;


@Data
@Valid
public class RoleAuthoritySaveRequest {
    private String name;
    private String description;
    private RoleRequest role;
    private List<AuthorityRoleSaveRequest> authorities;
}
