package lk.coop.dto.authentication.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@Valid
public class UserUpdateRequest {

    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String businessTitle;
    private String epfNo;
    private Set<RoleSaveRequest> roles;
    @NotNull
    private UserLocationRequest userLocation;

}
