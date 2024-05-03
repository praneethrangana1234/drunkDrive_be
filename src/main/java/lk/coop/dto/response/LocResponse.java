package lk.coop.dto.response;


import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;
import java.util.Date;


@Data
public class LocResponse {

private String locCode;

private String locName;

private Integer locid;

 private String createdBy;
 
 private String createdDateTime;
 
 private String modifiedBy;
 
 private String modifiedDateTime;

 private Deleted isDeleted;
 private Status status;
 }