package lk.coop.repository.authentication;

import lk.coop.entity.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository; import lk.coop.enums.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String userName);


    @Modifying
    @Query("update User c set c.password=?1  where c.id=?2")
    Integer updateUser(String password, Integer id);


}