package lk.coop.repository.authentication;

import lk.coop.entity.authentication.AuthorityType;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorityTypeRepository extends CrudRepository<AuthorityType,  String> {

    List<AuthorityType> findByIsDeletedAndStatus(Deleted isDeleted, Status status);

    @Query("From AuthorityType b where b.isDeleted=:isDelete and b.id=:id")
    AuthorityType getOne(@Param("isDelete") Deleted isDelete, @Param("id")  Integer id);

    List<AuthorityType> findByIsDeleted(Deleted isDelete);

}