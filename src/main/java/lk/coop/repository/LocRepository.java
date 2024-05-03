package lk.coop.repository;

import lk.coop.entity.Loc;
import lk.coop.enums.Deleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface LocRepository extends JpaRepository<Loc,Integer> , JpaSpecificationExecutor {


    //List<Loc> findByIsDeleted(Deleted deleted);


}