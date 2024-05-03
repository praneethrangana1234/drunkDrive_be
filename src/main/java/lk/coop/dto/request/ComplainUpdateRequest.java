package lk.coop.dto.request;


import lk.coop.enums.Status;
import lombok.Data;

@Data
public class ComplainUpdateRequest {

private String date;

private String driverId;

private Integer id;

private String name;

 private Status status;

 }