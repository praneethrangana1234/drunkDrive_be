package lk.coop.dto.authentication.request;

import lombok.Data;

@Data
public class ActionSaveRequest {
    private  Integer id;
    private String name;
    private String alias;
    private String description;
}
