package lk.coop.service.impl;

import lk.coop.dto.request.EmployeeRequest;
import lk.coop.dto.request.EmployeeUpdateRequest;
import lk.coop.dto.response.EmployeeResponse;
import lk.coop.entity.Employee;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.EmployeeRepository;
import lk.coop.service.EmployeeService;
//import lk.utils.ConvertUtils;
//import lk.enums.Deleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
@Transactional
    public EmployeeResponse save(EmployeeRequest request) {

        Employee employee=new Employee();
employee.setAdress(request.getAdress());
employee.setAge(request.getAge());
employee.setCurrentOcation(request.getCurrentOcation());
employee.setDob(request.getDob());
employee.setEmpType(request.getEmpType());
employee.setGender(request.getGender());
employee.setName(request.getName());
employee.setNic(request.getNic());
employee.setVehicleId(request.getVehicleId());
employee.setIsDeleted(Deleted.NO);
employee.setStatus(Status.ACTIVE);
Employee save=employeeRepository.save(employee);

        return convert(save);
    }

    @Override
    @Transactional
    public EmployeeResponse update(EmployeeUpdateRequest request) {

Employee employee = employeeRepository.findById(request.getId()).orElse(null);
        if(employee==null){
            return null;
        }

employee.setId(request.getId());
employee.setAdress(request.getAdress());
employee.setAge(request.getAge());
employee.setCurrentOcation(request.getCurrentOcation());
employee.setDob(request.getDob());
employee.setEmpType(request.getEmpType());
employee.setGender(request.getGender());
employee.setId(request.getId());
employee.setName(request.getName());
employee.setNic(request.getNic());
employee.setVehicleId(request.getVehicleId());
employee.setStatus(request.getStatus());
Employee updated=employeeRepository.save(employee);

        return (convert(updated));
    }

    @Override
    public EmployeeResponse getById(Integer id) {

       return employeeRepository.findById(id).map(EmployeeServiceImpl::convert).orElse(null);
    }

    @Override
    public List<EmployeeResponse> getAll() {

        return  employeeRepository.findByIsDeleted(Deleted.NO)
                .stream().map(EmployeeServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Employee got=employeeRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
        got.setIsDeleted(Deleted.YES);
        employeeRepository.save(got);

        return  1;
    }

private static EmployeeResponse convert(Employee employee){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeResponse typeResponse=new EmployeeResponse();
typeResponse.setAdress(employee.getAdress());
typeResponse.setAge(employee.getAge());
typeResponse.setCurrentOcation(employee.getCurrentOcation());
typeResponse.setDob(employee.getDob());
typeResponse.setEmpType(employee.getEmpType());
typeResponse.setGender(employee.getGender());
typeResponse.setId(employee.getId());
typeResponse.setName(employee.getName());
typeResponse.setNic(employee.getNic());
typeResponse.setVehicleId(employee.getVehicleId());
        typeResponse.setId(employee.getId());
        typeResponse.setCreatedBy(employee.getCreatedBy());
       typeResponse.setCreatedDateTime(sdf.format(employee.getCreatedDateTime()));
        typeResponse.setModifiedBy(employee.getModifiedBy());
       typeResponse.setModifiedDateTime(sdf.format(employee.getModifiedDateTime()));
        typeResponse.setIsDeleted(employee.getIsDeleted());
        typeResponse.setStatus(employee.getStatus());

return typeResponse;
    }
}