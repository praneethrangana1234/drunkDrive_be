package lk.coop.controller.authentication;


import lk.coop.dto.authentication.request.AuthorityTypeSaveRequest;
import lk.coop.dto.authentication.request.AuthorityTypeUpdateRequest;
import lk.coop.dto.authentication.response.AuthorityTypeResponse;
import lk.coop.service.authentication.AuthorityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/authorityType")
public class AuthorityTypeController {

    @Autowired
    private AuthorityTypeService authorityTypeService;


    @PostMapping
    public ResponseEntity<AuthorityTypeResponse> save(@Valid @RequestBody AuthorityTypeSaveRequest request) {
        AuthorityTypeResponse save = this.authorityTypeService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<AuthorityTypeResponse> update(@Valid @RequestBody AuthorityTypeUpdateRequest updateRequest) {
        AuthorityTypeResponse update = this.authorityTypeService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AuthorityTypeResponse> remove(@PathVariable("id")  Integer id) {
        AuthorityTypeResponse deleted = this.authorityTypeService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<AuthorityTypeResponse>> getAll() {
        List<AuthorityTypeResponse> responses = this.authorityTypeService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<AuthorityTypeResponse>> getAllActive() {
        List<AuthorityTypeResponse> responses = this.authorityTypeService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorityTypeResponse> getOne(@PathVariable("id")  Integer id) {
        AuthorityTypeResponse detailResponse = this.authorityTypeService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
