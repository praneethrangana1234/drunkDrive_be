package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "AUTHORITY_TBL")
public class Authority extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "AUTHORITY_TYPE_ID", referencedColumnName = "ID")
    private AuthorityType authorityType;

    @Column(name = "AUTH_LIMIT",scale=2,nullable = false)
    private Float authLimit;

    @Column(name = "EFFECTIVE_FROM",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effectiveFrom;

    @Column(name = "EFFECTIVE_TO",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effectiveTo;

    @Column(name = "INACTIVE_REASON", length = 100)
    private String inactiveReason;

}