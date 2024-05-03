package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;


@Data
@Valid
public class RoleAuthorityUpdateRequest {
    private  Integer id;
    private String name;
    private String description;
    private RoleRequest role;
    private List<AuthorityRoleSaveRequest> authorities;
    private Status status;
    private String inactiveReason;
}
