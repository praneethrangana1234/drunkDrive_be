package lk.coop.dto.authentication.request;

import lombok.Data;

import java.util.Set;

@Data
public class RoleMItemSaveRequest {
    private String name;
    private String description;
    private RoleRequest role;
    private Set<MIFormRequest> menuItems;
}
