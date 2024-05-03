package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "au_role_action")
public class RoleAction extends BaseEntity {

    @Column
    private String name;

    @Column
    private String alias;

    @Column
    private String description;

    @Column(length = 100)
    private String inactiveReason;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RO_AC",
            joinColumns = {
                    @JoinColumn(name = "RO_AC_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "AC_ID") })
    private List<Action> actions = new ArrayList<>();

}