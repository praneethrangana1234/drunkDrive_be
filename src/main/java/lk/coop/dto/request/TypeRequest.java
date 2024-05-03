package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class TypeRequest {

private String code;

private String type;
 private Status status;

 }