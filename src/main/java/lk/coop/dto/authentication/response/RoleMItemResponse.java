package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Value;

import java.util.List;


@Value
public class RoleMItemResponse {
    private  Integer id;
    private String name;
    private String description;
    private RoleResponse role;
    private List<MenuItemResponse> menuItems;
    private Status status;
    private String inactiveReason;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
