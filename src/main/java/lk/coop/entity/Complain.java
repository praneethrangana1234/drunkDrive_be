package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
//import lk.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="COMPLAIN")
@Data
public class Complain  extends BaseEntity{

@Column(length=45)
private String date;

@Column(name="DRIVER_ID",length=45)
private String driverId;

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable=false)
//private Integer id;

@Column(length=345)
private String name;

//@Column(length=45)
//private String status;

}