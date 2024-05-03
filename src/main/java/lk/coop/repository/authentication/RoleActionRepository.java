package lk.coop.repository.authentication;

import lk.coop.entity.authentication.RoleAction;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleActionRepository extends CrudRepository<RoleAction,  String> {

    List<RoleAction> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From RoleAction b where b.isDeleted=:isDelete and b.id=:id")
    RoleAction getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<RoleAction> findByIsDeleted(Deleted isDelete);

}