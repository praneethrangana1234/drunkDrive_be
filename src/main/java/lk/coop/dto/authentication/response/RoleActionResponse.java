package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Value;

import java.util.List;


@Value
public class RoleActionResponse {
    private  Integer id;
    private String name;
    private String description;
    private String alias;
    private RoleResponse role;
    private List<ActionResponse> actions;
    private Status status;
    private String inactiveReason;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
