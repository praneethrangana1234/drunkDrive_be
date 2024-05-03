package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class RootUpdateRequest {

private Integer id;

private String rootDiscription;

private String rootName;
 private Status status;

 }