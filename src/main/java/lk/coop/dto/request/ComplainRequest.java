package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class ComplainRequest {

private String date;

private String driverId;

private String name;

 private Status status;
 }