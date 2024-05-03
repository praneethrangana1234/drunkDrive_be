package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
//import lk.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="EMPLOYEE")
@Data
public class Employee  extends BaseEntity{

@Column(length=545)
private String adress;

@Column(length=45)
private String age;

@Column(name="CURRENT_OCATION",length=145)
private String currentOcation;

@Column(length=45)
private String dob;

@Column(name="EMP_TYPE",length=45)
private String empType;

@Column(length=45)
private String gender;

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable=false)
//private Integer id;

@Column(length=445)
private String name;

@Column(length=45)
private String nic;

@Column(name="VEHICLE_ID",length=45)
private String vehicleId;

}