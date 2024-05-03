package lk.coop.repository.authentication;

import lk.coop.entity.authentication.Authority;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorityRepository extends CrudRepository<Authority,  String> {

    List<Authority> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From Authority b where b.isDeleted=:isDelete and b.id=:id")
    Authority getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<Authority> findByIsDeleted(Deleted isDelete);

}