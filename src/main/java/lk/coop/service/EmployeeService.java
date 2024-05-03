package lk.coop.service;

import lk.coop.dto.request.EmployeeRequest;
import lk.coop.dto.request.EmployeeUpdateRequest;
import lk.coop.dto.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeResponse save(EmployeeRequest request);

    EmployeeResponse update(EmployeeUpdateRequest request);

    EmployeeResponse getById(Integer id);

    List<EmployeeResponse> getAll();


    Integer delete(Integer id);
}