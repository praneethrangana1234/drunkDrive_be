package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="ATTENDANCE")
@Data
public class Attendance  extends BaseEntity{

@Column(length=45)
private String date;

@Column(length=45)
private String epf;



@Column(length=345)
private String location;

@Column(length=45)
private String timee;

@Column(length=45)
private String dr_status;
}