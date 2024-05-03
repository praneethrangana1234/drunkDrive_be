package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "AUTHORITY_TYPE")
public class AuthorityType extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column(length = 50)
    private String inactiveReason;
}