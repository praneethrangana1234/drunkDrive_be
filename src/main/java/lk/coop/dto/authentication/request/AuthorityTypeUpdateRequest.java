package lk.coop.dto.authentication.request;

import lk.coop.enums.Status;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthorityTypeUpdateRequest {
    private  Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Status status;
    private String inactiveReason;
}