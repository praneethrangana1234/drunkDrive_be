package lk.coop.dto.authentication.response;

import lombok.Value;

@Value
public class UserLocationResponse {
    private  Integer id;
    private String initialName;
    private String code;
}
