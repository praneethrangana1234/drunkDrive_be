package lk.coop.dto.authentication.response;

import lombok.Value;

import java.util.Date;


@Value
public class LocationResponse {
    private  Integer id;
    private String initialName;
    private String code;
    private String email;
    private String startDate;
    private String endDate;
}
