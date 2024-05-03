package lk.coop.service;

import lk.coop.dto.request.ComplainRequest;
import lk.coop.dto.request.ComplainUpdateRequest;
import lk.coop.dto.response.ComplainResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplainService {

    ComplainResponse save(ComplainRequest request);

    ComplainResponse update(ComplainUpdateRequest request);

    ComplainResponse getById(Integer id);

    List<ComplainResponse> getAll();


    Integer delete(Integer id);
}