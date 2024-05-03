package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
//import lk.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="DRIVER")
@Data
public class Driver  extends BaseEntity{

@Column(length=3)
private String age;

@Column(length=15)
private String dob;

@Column(name="DRIVER_ADD",length=545)
private String driverAdd;

@Column(name="DRIVER_NAME",length=345)
private String driverName;

@Column(length=10)
private String gender;

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable=false)
//private Integer id;

@Column(length=45)
private String lizenno;

@Column(length=45)
private String marrages;

@Column(length=45)
private String nic;

@Column(name="ROOT_ID",length=5)
private String rootId;

@Column(name="TEL_NO",length=15)
private String telNo;

@Column(length=10)
private String type;

@Column(name="VEHICLE_ID",length=45)
private String vehicleId;

}