package lk.coop.repository;

import lk.coop.entity.Attendance;
import lk.coop.enums.Deleted;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> , JpaSpecificationExecutor {


   // List<Attendance> findByEpfOrderByEpfAsc(String Epf);
    List<Attendance> findTop10ByEpfOrderByDateDescTimeeDesc(String Epf);
    List<Attendance> findByDateBetween(String fromDate, String toDate , Sort sort);
    List<Attendance> findByEpfAndDateBetween(String epf,String fromDate, String toDate , Sort sort);


    //Integer sendmailtotop(String epf, String date, String time);

}