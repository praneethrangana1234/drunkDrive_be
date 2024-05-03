package lk.coop.repository.authentication;

import lk.coop.entity.authentication.RoleAuthority;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleAuthorityRepository extends CrudRepository<RoleAuthority,  String> {

    List<RoleAuthority> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From RoleAuthority b where b.isDeleted=:isDelete and b.id=:id")
    RoleAuthority getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<RoleAuthority> findByIsDeleted(Deleted isDelete);

}