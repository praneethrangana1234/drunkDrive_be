package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Value;

import java.util.List;


@Value
public class FormsResponse {
    private  Integer id;
    private String name;
    private String alias;
    private MenuItemResponse menuItem;
    private List<ActionResponse> actions;
    private Status status;
    private String inactiveReason;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
