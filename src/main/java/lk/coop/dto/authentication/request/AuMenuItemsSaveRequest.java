package lk.coop.dto.authentication.request;

import lombok.Data;

@Data
public class AuMenuItemsSaveRequest {
    private String name;
    private String alias;
    private String parentId;
}
