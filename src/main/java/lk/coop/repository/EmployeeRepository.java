package lk.coop.repository;

import lk.coop.entity.Employee;
import lk.coop.enums.Deleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import lk.enums.Deleted;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> , JpaSpecificationExecutor {


    List<Employee> findByIsDeleted(Deleted deleted);


}