package lk.coop.repository;

import lk.coop.entity.Complain;
import lk.coop.enums.Deleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import lk.enums.Deleted;
import java.util.Date;
import java.util.List;

public interface ComplainRepository extends JpaRepository<Complain,Integer> , JpaSpecificationExecutor {


    List<Complain> findByIsDeleted(Deleted deleted);


}