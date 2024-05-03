package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "au_forms")
public class Forms extends BaseEntity {

    @Column
    private String name;

    @Column
    private String alias;

    @Column(length = 50)
    private String inactiveReason;

    @ManyToOne
    @JoinColumn(name = "MENU_ITEM_ID", nullable = false)
    private AuMenuItems menuItems;

    @OneToMany(mappedBy = "form",
            cascade = {CascadeType.ALL
            })
    private List<Action> actions;

}