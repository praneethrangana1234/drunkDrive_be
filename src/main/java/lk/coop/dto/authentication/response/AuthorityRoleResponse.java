package lk.coop.dto.authentication.response;

import lk.coop.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class AuthorityRoleResponse {
    private  Integer id;
    private AuthorityTypeResponse authorityType;
    private Float limit;
    private Date effectiveFrom;
    private Date effectiveTo;
    private Status status;
    private String inactiveReason;
}
