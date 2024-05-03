package lk.coop.dto.response;


import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;
import java.util.Date;
//import lk.enums.Deleted;

@Data
public class TypeResponse {

private String code;

private Integer id;

private String type;

 private String createdBy;
 
 private String createdDateTime;
 
 private String modifiedBy;
 
 private String modifiedDateTime;
 
 private Deleted isDeleted;
 private Status status;
 }