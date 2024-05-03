package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class RoleMItemUpdateRequest {
    private Integer id;
    private String name;
    private String description;
    private RoleRequest role;
    private Set<MIFormRequest> menuItems;
    private Status status;
    private String inactiveReason;
}
