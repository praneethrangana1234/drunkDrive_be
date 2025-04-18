package lk.coop.dto.response;


import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;
import java.util.Date;


@Data
public class AttendanceResponse {

private String date;

private String epf;

private Integer id;

private String location;

private String timee;

private String createdBy;
 
private Date createdDateTime;
 
private String modifiedBy;
 
private Date modifiedDateTime;
private Deleted isDeleted;
private Status status;
private String drStatus;
 }