package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

@Data
public class ActionUpdateRequest {
    private Integer id;
    private String name;
    private String alias;
    private String description;
    private Status status;
    private String inactiveReason;
}
