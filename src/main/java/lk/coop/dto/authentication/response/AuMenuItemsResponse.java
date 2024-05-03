package lk.coop.dto.authentication.response;

import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class AuMenuItemsResponse {
    private Integer id;
    private String name;
    private String alias;
    private Long parentId;
    private Date createdDateTime;
    private String createdBy;
    private Date modifiedDateTime;
    private String modifiedBy;
    private Status status;
    private String inactiveReason;
    private Deleted isDeleted;
}
