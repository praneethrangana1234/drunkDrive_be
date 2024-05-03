package lk.coop.dto.authentication.request;

import lombok.Data;

import java.util.List;

@Data
public class FormSaveRequest {
    private String name;
    private String alias;
    private MIFormRequest menuItem;
    private List<ActionSaveRequest> actions;
}
