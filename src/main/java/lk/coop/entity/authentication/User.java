package lk.coop.entity.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "USER_TABLE")
public class User {

   // @Id
   // @GeneratedValue(generator = "UUID")
   // @GenericGenerator(
           // name = "UUID",
           // strategy = "org.hibernate.id.UUIDGenerator",
          //  parameters = {
           //         @org.hibernate.annotations.Parameter(
           //                 name = "uuid_gen_strategy_class",
           //                 value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
           //         )
       //     }
   // )
  //  private String id;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Integer id;

    @Column(unique = true)
    private String username;
    @Column

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column
    private String name;

    @Column
    private String businessTitle;
    @Column
    private String intmdPackageName;
    @Column
    private String intmdPackageId;

    @Column(unique = true)
    private String epfNo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")})
    private List<Role> roles;

    @NotNull
    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

}