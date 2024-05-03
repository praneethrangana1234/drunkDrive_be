package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

import java.util.Set;

@Data
public class RoleActionUpdateRequest {
    private Integer id;
    private String name;
    private String alias;
    private String description;
    private RoleRequest role;
    private Set<ActFormRequest> actions;
    private Status status;
    private String inactiveReason;
}
