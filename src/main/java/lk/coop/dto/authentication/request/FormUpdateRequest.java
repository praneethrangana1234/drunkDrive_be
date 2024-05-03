package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

import java.util.List;

@Data
public class FormUpdateRequest {
    private Integer id;
    private String name;
    private String alias;
    private MIFormRequest menuItem;
    private List<ActionSaveRequest> actions;
    private Status status;
    private String inactiveReason;
}
