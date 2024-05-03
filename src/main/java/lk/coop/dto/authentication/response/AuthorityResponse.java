package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Value;

import java.util.Date;

@Value
public class AuthorityResponse {
    private  Integer id;
    private AuthorityTypeResponse authorityType;
    private Float limit;
    private String effectiveFrom;
    private String effectiveTo;
    private Status status;
    private String inactiveReason;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
