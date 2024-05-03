package lk.coop.repository.authentication;

import lk.coop.entity.authentication.Role;
import org.springframework.data.jpa.repository.JpaRepository; import lk.coop.enums.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByName(String name);

//    List<Role> findByStatusAndIsDeleted(Status status, Deleted isDeleted);
//
//    List<Role> findByIsDeleted(Deleted isDeleted);

}