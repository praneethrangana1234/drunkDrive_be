package lk.coop.service;

import lk.coop.dto.request.VehicleRequest;
import lk.coop.dto.request.VehicleUpdateRequest;
import lk.coop.dto.response.VehicleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    VehicleResponse save(VehicleRequest request);

    VehicleResponse update(VehicleUpdateRequest request);

    VehicleResponse getById(Integer id);

    List<VehicleResponse> getAll();


    Integer delete(Integer id);
}