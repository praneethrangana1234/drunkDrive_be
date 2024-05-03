package lk.coop.dto.authentication.request;

import lombok.Data;

import java.util.Set;

@Data
public class RoleActionSaveRequest {
    private String name;
    private String alias;
    private String description;
    private RoleRequest role;
    private Set<ActFormRequest> actions;
}
