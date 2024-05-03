package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data; import lk.coop.enums.*;

import java.util.Date;

@Data
public class AuthorityUpdateRequest {
    private  Integer id;
    private AuthorityTypeRequest authorityType;
    private Float limit;
    private Date effectiveFrom;
    private Date effectiveTo;
    private Status status;
    private String inactiveReason;
}