package lk.coop.controller.authentication;


import lk.coop.dto.authentication.request.RoleActionSaveRequest;
import lk.coop.dto.authentication.request.RoleActionUpdateRequest;
import lk.coop.dto.authentication.response.RoleActionResponse;
import lk.coop.dto.authentication.response.RoleActionSResponse;
import lk.coop.service.authentication.RoleActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/role_action")
public class RoleActionController {

    @Autowired
    private RoleActionService roleActionService;


    @PostMapping
    public ResponseEntity<RoleActionSResponse> save(@Valid @RequestBody RoleActionSaveRequest request) {
        RoleActionSResponse save = this.roleActionService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<RoleActionSResponse> update(@Valid @RequestBody RoleActionUpdateRequest updateRequest) {
        RoleActionSResponse update = this.roleActionService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RoleActionSResponse> remove(@PathVariable("id")  Integer id) {
        RoleActionSResponse deleted = this.roleActionService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<RoleActionSResponse>> getAll() {
        List<RoleActionSResponse> responses = this.roleActionService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<RoleActionSResponse>> getAllActive() {
        List<RoleActionSResponse> responses = this.roleActionService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleActionResponse> getOne(@PathVariable("id")  Integer id) {
        RoleActionResponse detailResponse = this.roleActionService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
