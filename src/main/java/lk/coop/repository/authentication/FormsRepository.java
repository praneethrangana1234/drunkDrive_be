package lk.coop.repository.authentication;

import lk.coop.entity.authentication.Forms;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FormsRepository extends CrudRepository<Forms,  String> {

    List<Forms> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From Forms b where b.isDeleted=:isDelete and b.id=:id")
    Forms getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<Forms> findByIsDeleted(Deleted isDelete);

}