package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Value;

import java.util.Date;
import java.util.Set;

@Value
public class RoleAuthoritySResponse {
    private  Integer id;
    private String name;
    private String description;
    private Status status;
    private String inactiveReason;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
}
