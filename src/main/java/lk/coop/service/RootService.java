package lk.coop.service;

import lk.coop.dto.request.RootRequest;
import lk.coop.dto.request.RootUpdateRequest;
import lk.coop.dto.response.RootResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RootService {

    RootResponse save(RootRequest request);

    RootResponse update(RootUpdateRequest request);

    RootResponse getById(Integer id);

    List<RootResponse> getAll();


    Integer delete(Integer id);
}