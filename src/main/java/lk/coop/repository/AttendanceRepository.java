package lk.coop.repository;

import lk.coop.entity.Attendance;
import lk.coop.enums.Deleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> , JpaSpecificationExecutor {


   // List<Attendance> findByEpfOrderByEpfAsc(String Epf);
    List<Attendance> findTop10ByEpfOrderByDateDescTimeeDesc(String Epf);
    //Integer sendmailtotop(String epf, String date, String time);

}