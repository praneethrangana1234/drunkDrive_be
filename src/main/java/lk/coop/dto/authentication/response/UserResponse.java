package lk.coop.dto.authentication.response;

import lombok.Value;

import java.util.List;

@Value
public class UserResponse {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String name;
    private String businessTitle;
    private String epfNo;
    private List<RoleResponse> roles;
    private LocationResponse location;
}
