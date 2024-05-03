package lk.coop.controller;

import lk.coop.dto.request.ComplainRequest;
import lk.coop.dto.request.ComplainUpdateRequest;
import lk.coop.dto.response.ComplainResponse;
import lk.coop.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Complain")
@RestController
@CrossOrigin
public class ComplainController {

    @Autowired
    private ComplainService complainService;


    @PostMapping
    public ResponseEntity<ComplainResponse> save(@Valid @RequestBody ComplainRequest request){
        ComplainResponse save = complainService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<ComplainResponse> update(@Valid @RequestBody ComplainUpdateRequest request){
        ComplainResponse updated = complainService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<ComplainResponse> getById(@PathVariable("id") @NotBlank Integer id){
        ComplainResponse get = complainService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<ComplainResponse>> getAll(){
        List<ComplainResponse> getall = complainService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = complainService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}