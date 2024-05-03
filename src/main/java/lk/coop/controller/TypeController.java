package lk.coop.controller;

import lk.coop.dto.request.TypeRequest;
import lk.coop.dto.request.TypeUpdateRequest;
import lk.coop.dto.response.TypeResponse;
import lk.coop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Type")
@RestController
@CrossOrigin
public class TypeController {

    @Autowired
    private TypeService typeService;


    @PostMapping
    public ResponseEntity<TypeResponse> save(@Valid @RequestBody TypeRequest request){
        TypeResponse save = typeService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<TypeResponse> update(@Valid @RequestBody TypeUpdateRequest request){
        TypeResponse updated = typeService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<TypeResponse> getById(@PathVariable("id") @NotBlank Integer id){
        TypeResponse get = typeService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<TypeResponse>> getAll(){
        List<TypeResponse> getall = typeService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = typeService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}