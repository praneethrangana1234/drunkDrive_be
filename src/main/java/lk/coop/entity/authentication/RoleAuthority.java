package lk.coop.entity.authentication;


import lk.coop.entity.BaseEntity;
import lk.coop.enums.Status;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "ROLE_AUTHORITY")
public class RoleAuthority extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(name = "RO_AUTH",
            joinColumns = {
                    @JoinColumn(name = "RO_AUTH_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "AUTH_ID") })
    private List<Authority> authorities = new ArrayList<>();

    @Column(name = "INACTIVE_REASON", length = 100)
    private String inactiveReason;

}
