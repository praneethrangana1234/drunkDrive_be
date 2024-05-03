package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
//import lk.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="TYPE")
@Data
public class Type  extends BaseEntity{

@Column(length=45,nullable=false)
private String code;

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable=false)
//private Integer id;

@Column(length=245,nullable=false)
private String type;

}