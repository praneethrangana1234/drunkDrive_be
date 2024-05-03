package lk.coop.controller;

import lk.coop.dto.request.VehicleRequest;
import lk.coop.dto.request.VehicleUpdateRequest;
import lk.coop.dto.response.VehicleResponse;
import lk.coop.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Vehicle")
@RestController
@CrossOrigin
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<VehicleResponse> save(@Valid @RequestBody VehicleRequest request){
        VehicleResponse save = vehicleService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<VehicleResponse> update(@Valid @RequestBody VehicleUpdateRequest request){
        VehicleResponse updated = vehicleService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<VehicleResponse> getById(@PathVariable("id") @NotBlank Integer id){
        VehicleResponse get = vehicleService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<VehicleResponse>> getAll(){
        List<VehicleResponse> getall = vehicleService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = vehicleService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}