package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class EmployeeRequest {

private String adress;

private String age;

private String currentOcation;

private String dob;

private String empType;

private String gender;

private String name;

private String nic;

private String vehicleId;
 private Status status;

 }