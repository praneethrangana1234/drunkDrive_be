package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "au_role_mitem")
public class RoleMItem extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column(length = 100)
    private String inactiveReason;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RO_MI",
            joinColumns = {
                    @JoinColumn(name = "RO_MI_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "MI_ID") })
    private List<AuMenuItems> menuItems = new ArrayList<>();

}