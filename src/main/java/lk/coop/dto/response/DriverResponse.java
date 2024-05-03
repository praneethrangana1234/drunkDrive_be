package lk.coop.dto.response;


import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;
import java.util.Date;
//import lk.enums.Deleted;

@Data
public class DriverResponse {

private String age;

private String dob;

private String driverAdd;

private String driverName;

private String gender;

private Integer id;

private String lizenno;

private String marrages;

private String nic;

private String rootId;

private String telNo;

private String type;

private String vehicleId;

 private String createdBy;
 
 private String createdDateTime;
 
 private String modifiedBy;
 
 private String modifiedDateTime;
 
 private Deleted isDeleted;
 private Status status;

 }