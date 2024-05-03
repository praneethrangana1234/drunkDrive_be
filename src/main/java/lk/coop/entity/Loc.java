package lk.coop.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="LOC")
@Data
public class Loc  extends BaseEntity{

@Column(name="LOC_CODE",length=45)
private String locCode;

@Column(name="LOC_NAME",length=345)
private String locName;



}