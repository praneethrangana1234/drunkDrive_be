package lk.coop.entity.authentication;

import lk.coop.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "AU_MENU_ITEMS")
public class AuMenuItems extends BaseEntity {


    @Column(name = "NAME",nullable = false,length = 50)
    private String name;

    @Column(name = "ALIAS",nullable = false,unique = true,length = 20)
    private String alias;

    @Column(name = "PARENT_ID")
    @ColumnDefault("0")
    private String parentId;

    @Column(length = 50)
    private String inactiveReason;
}
