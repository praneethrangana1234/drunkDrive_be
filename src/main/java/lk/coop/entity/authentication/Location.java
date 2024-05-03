package lk.coop.entity.authentication;


import lk.coop.entity.BaseEntity;
import lk.coop.enums.IsLocal;
import lk.coop.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="LOCATION")
@Data
public class Location extends BaseEntity {


    @Column(name="COMPANY_ID",nullable = false)
    private String companyId;

    @Column(name="BRANCH_TYPE_ID",nullable = false)
    private String branchTypeId;

    @Column(name="INITIAL_NAME",nullable = false,length=100)
    private  String initialName;

    @Column(name="CODE",nullable = false,length=10)
    private  String code;

    @Column(name="EMAIL",nullable = true,length=100)
    private String email;

    @Column(name="IS_LOCAL_ENTITY",nullable = false)
    private IsLocal isLocalEntity;

    @Column(name="BRANCH_GRADE_ID",nullable = true)
    private String branchGradeId;

    @Column(name="LOCATION_HEAD_ID",nullable = true)
    private String locationHeadId;

    @Column(name="IS_ATTACHED",nullable = true)
    private Integer isAttached;

    @Column(name="START_DATE",nullable = true)
    private Date startDate;

    @Column(name="END_DATE",nullable = true)
    private Date endDate;

    @Column(nullable=false)
    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    @Column(name="INACTIVE_REASON", length=100,nullable = true)
    private String inactiveReason;



//    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
//    private List<LocationMap> locationMaps;

//    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
//    private List<LocationBackUp> locationBackUps;

}














