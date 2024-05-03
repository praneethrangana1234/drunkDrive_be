package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class TypeUpdateRequest {

private String code;

private Integer id;

private String type;
 private Status status;

 }