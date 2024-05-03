package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Value;

@Value
public class AuthorityTypeResponse {
    private  Integer id;
    private String name;
    private String description;
    private Status status;
    private String inactiveReason;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
