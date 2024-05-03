package lk.coop.controller;

import lk.coop.dto.request.EmployeeRequest;
import lk.coop.dto.request.EmployeeUpdateRequest;
import lk.coop.dto.response.EmployeeResponse;
import lk.coop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Employee")
@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeResponse> save(@Valid @RequestBody EmployeeRequest request){
        EmployeeResponse save = employeeService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<EmployeeResponse> update(@Valid @RequestBody EmployeeUpdateRequest request){
        EmployeeResponse updated = employeeService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable("id") @NotBlank Integer id){
        EmployeeResponse get = employeeService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<EmployeeResponse>> getAll(){
        List<EmployeeResponse> getall = employeeService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = employeeService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}