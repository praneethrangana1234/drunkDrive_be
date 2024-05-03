package lk.coop.entity.authentication;


import lombok.Data;  import lk.coop.enums.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@Entity
public class Role {

  /*  @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private String id;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Integer id;


    @Column
    private String name;

    @Column
    private String description;
}
