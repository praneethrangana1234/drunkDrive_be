package lk.coop.repository.authentication;

import lk.coop.entity.authentication.RoleMItem;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleMItemRepository extends CrudRepository<RoleMItem,  String> {

    List<RoleMItem> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From RoleMItem b where b.isDeleted=:isDelete and b.id=:id")
    RoleMItem getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<RoleMItem> findByIsDeleted(Deleted isDelete);

}