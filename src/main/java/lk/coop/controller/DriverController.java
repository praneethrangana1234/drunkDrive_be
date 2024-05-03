package lk.coop.controller;

import lk.coop.dto.request.DriverRequest;
import lk.coop.dto.request.DriverUpdateRequest;
import lk.coop.dto.response.DriverResponse;
import lk.coop.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Driver")
@RestController
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService driverService;


    @PostMapping
    public ResponseEntity<DriverResponse> save(@Valid @RequestBody DriverRequest request){
        DriverResponse save = driverService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<DriverResponse> update(@Valid @RequestBody DriverUpdateRequest request){
        DriverResponse updated = driverService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<DriverResponse> getById(@PathVariable("id") @NotBlank Integer id){
        DriverResponse get = driverService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<DriverResponse>> getAll(){
        List<DriverResponse> getall = driverService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = driverService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}