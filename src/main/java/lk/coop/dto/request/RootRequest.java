package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class RootRequest {

private String rootDiscription;

private String rootName;
 private Status status;

 }