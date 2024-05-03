package lk.coop.dto.authentication.response;

import lk.coop.entity.authentication.User;
import lombok.Value; import lk.coop.enums.*;

@Value
public class AuthTokenResponse {

    private Object user;

    private String token;
}
