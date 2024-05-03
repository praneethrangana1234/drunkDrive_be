package lk.coop.service;

import lk.coop.dto.request.LocRequest;
import lk.coop.dto.request.LocUpdateRequest;
import lk.coop.dto.response.LocResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocService {

    LocResponse save(LocRequest request);

    LocResponse update(LocUpdateRequest request);

    LocResponse getById(Integer id);

    List<LocResponse> getAll();


    Integer delete(Integer id);
}