package lk.coop.repository;

import lk.coop.entity.Type;
import lk.coop.enums.Deleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import lk.enums.Deleted;
import java.util.Date;
import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Integer> , JpaSpecificationExecutor {


    List<Type> findByIsDeleted(Deleted deleted);


}