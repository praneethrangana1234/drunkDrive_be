package lk.coop.dto.authentication.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthorityTypeSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private String description;
}
