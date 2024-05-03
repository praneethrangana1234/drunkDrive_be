package lk.coop.controller.authentication;

import lk.coop.dto.authentication.request.FormSaveRequest;
import lk.coop.dto.authentication.request.FormUpdateRequest;
import lk.coop.dto.authentication.response.FormSaveResponse;
import lk.coop.dto.authentication.response.FormsResponse;
import lk.coop.service.authentication.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private FormsService formsService;


    @PostMapping
    public ResponseEntity<FormSaveResponse> save(@Valid @RequestBody FormSaveRequest request) {
        FormSaveResponse save = formsService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<FormSaveResponse> update(@Valid @RequestBody FormUpdateRequest updateRequest) {
        FormSaveResponse update = formsService.update(updateRequest);
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FormsResponse> remove(@PathVariable("id")  Integer id) {
        FormsResponse deleted = formsService.delete(id);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }


    @GetMapping
    private ResponseEntity<List<FormsResponse>> getAll() {
        List<FormsResponse> responses = formsService.getAll();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("active")
    private ResponseEntity<List<FormsResponse>> getAllActive() {
        List<FormsResponse> responses = formsService.getAllActive();
        if (responses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<FormsResponse> getOne(@PathVariable("id")  Integer id) {
        FormsResponse detailResponse = formsService.getById(id);
        if (detailResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailResponse);
    }
}
