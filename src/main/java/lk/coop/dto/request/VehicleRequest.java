package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class VehicleRequest {

private String owner;

private String rootId;

private String seatCount;

private String type;

private String vehicleNo;

private String year;
 private Status status;

 }