package lk.coop.repository.authentication;

import lk.coop.entity.authentication.Action;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActionRepository extends CrudRepository<Action,  String> {

    List<Action> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From Action b where b.isDeleted=:isDelete and b.id=:id")
    Action getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<Action> findByIsDeleted(Deleted isDelete);

}