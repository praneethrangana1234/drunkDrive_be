package lk.coop.controller;

import lk.coop.dto.request.LocRequest;
import lk.coop.dto.request.LocUpdateRequest;
import lk.coop.dto.response.LocResponse;
import lk.coop.service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Loc")
@RestController
@CrossOrigin
public class LocController {

    @Autowired
    private LocService locService;


    @PostMapping
    public ResponseEntity<LocResponse> save(@Valid @RequestBody LocRequest request){
        LocResponse save = locService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<LocResponse> update(@Valid @RequestBody LocUpdateRequest request){
        LocResponse updated = locService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<LocResponse> getById(@PathVariable("id") @NotBlank Integer id){
        LocResponse get = locService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<LocResponse>> getAll(){
        List<LocResponse> getall = locService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = locService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}