package lk.coop.controller;

import lk.coop.dto.request.RootRequest;
import lk.coop.dto.request.RootUpdateRequest;
import lk.coop.dto.response.RootResponse;
import lk.coop.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Root")
@RestController
@CrossOrigin
public class RootController {

    @Autowired
    private RootService rootService;


    @PostMapping
    public ResponseEntity<RootResponse> save(@Valid @RequestBody RootRequest request){
        RootResponse save = rootService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<RootResponse> update(@Valid @RequestBody RootUpdateRequest request){
        RootResponse updated = rootService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<RootResponse> getById(@PathVariable("id") @NotBlank Integer id){
        RootResponse get = rootService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<RootResponse>> getAll(){
        List<RootResponse> getall = rootService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = rootService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}