package lk.coop.dto.response;


import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;
import java.util.Date;
//import lk.enums.Deleted;

@Data
public class RootResponse {

private Integer id;

private String rootDiscription;

private String rootName;

 private String createdBy;
 
 private String createdDateTime;
 
 private String modifiedBy;
 
 private String modifiedDateTime;
 
 private Deleted isDeleted;
 private Status status;
 }