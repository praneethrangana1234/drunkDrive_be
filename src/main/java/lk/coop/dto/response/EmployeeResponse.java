package lk.coop.dto.response;


import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lombok.Data;
import java.util.Date;
//import lk.enums.Deleted;

@Data
public class EmployeeResponse {

private String adress;

private String age;

private String currentOcation;

private String dob;

private String empType;

private String gender;

private Integer id;

private String name;

private String nic;

private String vehicleId;

 private String createdBy;
 
 private String createdDateTime;
 
 private String modifiedBy;
 
 private String modifiedDateTime;
 
 private Deleted isDeleted;
 private Status status;
 }