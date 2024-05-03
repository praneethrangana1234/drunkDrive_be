package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
//import lk.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="VEHICLE")
@Data
public class Vehicle  extends BaseEntity{

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable=false)
//private Integer id;

@Column(length=445)
private String owner;

@Column(name="ROOT_ID",length=45)
private String rootId;

@Column(name="SEAT_COUNT",length=45)
private String seatCount;

@Column(length=45)
private String type;

@Column(name="VEHICLE_NO",length=45)
private String vehicleNo;

@Column(length=45)
private String year;

}