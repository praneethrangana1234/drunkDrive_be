package lk.coop.service;

import lk.coop.dto.request.TypeRequest;
import lk.coop.dto.request.TypeUpdateRequest;
import lk.coop.dto.response.TypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    TypeResponse save(TypeRequest request);

    TypeResponse update(TypeUpdateRequest request);

    TypeResponse getById(Integer id);

    List<TypeResponse> getAll();


    Integer delete(Integer id);
}