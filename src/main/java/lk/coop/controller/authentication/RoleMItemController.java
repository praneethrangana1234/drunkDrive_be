package lk.coop.controller.authentication;


import lk.coop.dto.authentication.request.RoleMItemSaveRequest;
import lk.coop.dto.authentication.request.RoleMItemUpdateRequest;
import lk.coop.dto.authentication.response.RoleMItemResponse;
import lk.coop.dto.authentication.response.RoleMItemSResponse;
import lk.coop.service.authentication.RoleMItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/role_mitem")
public class RoleMItemController {

    @Autowired
    private RoleMItemService roleMItemService;


    @PostMapping
    public ResponseEntity<RoleMItemSResponse> save(@Valid @RequestBody RoleMItemSaveRequest request) {
        RoleMItemSResponse save = this.roleMItemService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<RoleMItemSResponse> update(@Valid @RequestBody RoleMItemUpdateRequest updateRequest) {
        RoleMItemSResponse update = this.roleMItemService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RoleMItemSResponse> remove(@PathVariable("id")  Integer id) {
        RoleMItemSResponse deleted = this.roleMItemService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<RoleMItemSResponse>> getAll() {
        List<RoleMItemSResponse> responses = this.roleMItemService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<RoleMItemSResponse>> getAllActive() {
        List<RoleMItemSResponse> responses = this.roleMItemService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleMItemResponse> getOne(@PathVariable("id")  Integer id) {
        RoleMItemResponse detailResponse = this.roleMItemService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
