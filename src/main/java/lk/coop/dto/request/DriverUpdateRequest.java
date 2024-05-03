package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class DriverUpdateRequest {

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
 private Status status;

 }