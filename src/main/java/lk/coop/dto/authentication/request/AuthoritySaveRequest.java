package lk.coop.dto.authentication.request;

import lombok.Data; import lk.coop.enums.*;

import java.util.Date;

@Data
public class AuthoritySaveRequest {
    private AuthorityTypeRequest authorityType;
    private Float limit;
    private Date effectiveFrom;
    private Date effectiveTo;
}