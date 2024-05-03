package lk.coop.dto.authentication.request;

import lombok.Data;

import javax.validation.Valid;
import java.util.Set;


@Data
@Valid
public class UserLocationRequest {
    private  Integer id;
}
