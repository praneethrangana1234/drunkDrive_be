package lk.coop.dto.request;


import lombok.Data;

@Data
public class AttendanceUpdateRequest {

private String date;

private String epf;

private Integer id;

private String location;

private String timee;
private String drStatus;
 }