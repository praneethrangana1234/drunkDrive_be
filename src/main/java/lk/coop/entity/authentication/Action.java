package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "au_action")
public class Action extends BaseEntity {

    @Column
    private String name;

    @Column
    private String alias;

    @Column
    private String description;

    @Column(length = 50)
    private String inactiveReason;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="form_id", nullable=false)
    private Forms form;

}