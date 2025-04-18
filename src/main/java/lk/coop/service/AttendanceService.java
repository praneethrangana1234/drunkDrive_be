package lk.coop.service;

import lk.coop.dto.request.AttendanceRequest;
import lk.coop.dto.request.AttendanceUpdateRequest;
import lk.coop.dto.response.AttendanceResponse;
import lk.coop.entity.Attendance;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public interface AttendanceService {

    AttendanceResponse save(AttendanceRequest request);

    AttendanceResponse update(AttendanceUpdateRequest request);

    List<AttendanceResponse> findTop10ByEpfOrderByDateDescTimeeDesc(String id);
    List<Attendance> findByDateBetween(String fromDate, String toDate);
    List<Attendance> findByEpfAndDateBetween(String epf,String fromDate, String toDate );

    List<AttendanceResponse> getAll();
    Integer  sendmailtotop(String epf, String date, String time);

    Integer delete(Integer id);
    File printappoinmentall(String epf,String fromDate, String toDate );
    File printappoinment(String fromDate, String toDate );

}