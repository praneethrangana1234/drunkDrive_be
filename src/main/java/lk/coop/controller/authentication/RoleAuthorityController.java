package lk.coop.controller.authentication;


import lk.coop.dto.authentication.request.RoleAuthoritySaveRequest;
import lk.coop.dto.authentication.request.RoleAuthorityUpdateRequest;
import lk.coop.dto.authentication.response.RoleAuthorityResponse;
import lk.coop.dto.authentication.response.RoleAuthoritySResponse;
import lk.coop.service.authentication.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/roleAuthority")
public class RoleAuthorityController {

    @Autowired
    private RoleAuthorityService roleAuthorityService;



    @PostMapping
    public ResponseEntity<RoleAuthoritySResponse> save(@Valid @RequestBody RoleAuthoritySaveRequest request) {
        RoleAuthoritySResponse save = this.roleAuthorityService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<RoleAuthoritySResponse> update(@Valid @RequestBody RoleAuthorityUpdateRequest updateRequest) {
        RoleAuthoritySResponse update = this.roleAuthorityService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RoleAuthoritySResponse> remove(@PathVariable("id")  Integer id) {
        RoleAuthoritySResponse deleted = this.roleAuthorityService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<RoleAuthoritySResponse>> getAll() {
        List<RoleAuthoritySResponse> responses = this.roleAuthorityService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<RoleAuthoritySResponse>> getAllActive() {
        List<RoleAuthoritySResponse> responses = this.roleAuthorityService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleAuthorityResponse> getOne(@PathVariable("id")  Integer id) {
        RoleAuthorityResponse detailResponse = roleAuthorityService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
