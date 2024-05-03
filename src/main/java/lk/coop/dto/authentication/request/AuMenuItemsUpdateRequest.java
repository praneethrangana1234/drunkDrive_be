package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class AuMenuItemsUpdateRequest {
    private Integer id;
    private String name;
    private String alias;
    private Status status;
    private String inactiveReason;
}
