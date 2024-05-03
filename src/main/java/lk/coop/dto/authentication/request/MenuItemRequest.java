package lk.coop.dto.authentication.request;

import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;


@Data
@Valid
public class MenuItemRequest {
    private Integer id;
    private String name;
    private String alias;
    private Long parentId;
    private Status status;
    private String inactiveReason;
    private Deleted isDeleted;
}
