package lk.coop.controller.authentication;


import lk.coop.dto.authentication.request.ActionSaveRequest;
import lk.coop.dto.authentication.request.ActionUpdateRequest;
import lk.coop.dto.authentication.response.ActionResponse;
import lk.coop.service.authentication.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;


    @PostMapping
    public ResponseEntity<ActionResponse> save(@Valid @RequestBody ActionSaveRequest request) {
        ActionResponse save = actionService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<ActionResponse> update(@Valid @RequestBody ActionUpdateRequest updateRequest) {
        ActionResponse update = actionService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ActionResponse> remove(@PathVariable("id")  Integer id) {
        ActionResponse deleted = actionService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<ActionResponse>> getAll() {
        List<ActionResponse> responses = actionService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<ActionResponse>> getAllActive() {
        List<ActionResponse> responses = actionService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<ActionResponse> getOne(@PathVariable("id")  Integer id) {
        ActionResponse detailResponse = actionService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
