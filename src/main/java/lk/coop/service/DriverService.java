package lk.coop.service;

import lk.coop.dto.request.DriverRequest;
import lk.coop.dto.request.DriverUpdateRequest;
import lk.coop.dto.response.DriverResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {

    DriverResponse save(DriverRequest request);

    DriverResponse update(DriverUpdateRequest request);

    DriverResponse getById(Integer id);

    List<DriverResponse> getAll();


    Integer delete(Integer id);
}