package lk.coop.controller.authentication;


import lk.coop.dto.authentication.request.AuthoritySaveRequest;
import lk.coop.dto.authentication.request.AuthorityUpdateRequest;
import lk.coop.dto.authentication.response.AuthorityResponse;
import lk.coop.service.authentication.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;


    @PostMapping
    public ResponseEntity<AuthorityResponse> save(@Valid @RequestBody AuthoritySaveRequest request) {
        AuthorityResponse save = authorityService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<AuthorityResponse> update(@Valid @RequestBody AuthorityUpdateRequest updateRequest) {
        AuthorityResponse update = authorityService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AuthorityResponse> remove(@PathVariable("id")  Integer id) {
        AuthorityResponse deleted = authorityService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<AuthorityResponse>> getAll() {
        List<AuthorityResponse> responses = authorityService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<AuthorityResponse>> getAllActive() {
        List<AuthorityResponse> responses = authorityService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorityResponse> getOne(@PathVariable("id")  Integer id) {
        AuthorityResponse detailResponse = authorityService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
