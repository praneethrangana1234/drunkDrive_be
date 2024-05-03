package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="ROOT")
@Data
public class Root  extends BaseEntity{

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(nullable=false)
//private Integer id;

@Column(name="ROOT_DISCRIPTION",length=345)
private String rootDiscription;

@Column(name="ROOT_NAME",length=245)
private String rootName;

}