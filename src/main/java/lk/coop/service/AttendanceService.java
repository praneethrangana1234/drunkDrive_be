package lk.coop.service;

import lk.coop.dto.request.AttendanceRequest;
import lk.coop.dto.request.AttendanceUpdateRequest;
import lk.coop.dto.response.AttendanceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {

    AttendanceResponse save(AttendanceRequest request);

    AttendanceResponse update(AttendanceUpdateRequest request);

    List<AttendanceResponse> findTop10ByEpfOrderByDateDescTimeeDesc(String id);

    List<AttendanceResponse> getAll();
    Integer  sendmailtotop(String epf, String date, String time);

    Integer delete(Integer id);
}