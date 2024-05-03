package lk.coop.repository;

import lk.coop.entity.Driver;
import lk.coop.enums.Deleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import lk.enums.Deleted;
import java.util.Date;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> , JpaSpecificationExecutor {


    List<Driver> findByIsDeleted(Deleted deleted);


}