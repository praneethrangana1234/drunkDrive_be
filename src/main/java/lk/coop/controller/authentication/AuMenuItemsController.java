package lk.coop.controller.authentication;

import lk.coop.dto.authentication.request.AuMenuItemsSaveRequest;
import lk.coop.dto.authentication.request.AuMenuItemsUpdateRequest;
import lk.coop.dto.authentication.response.AuMenuItemsResponse;
import lk.coop.service.authentication.AuMenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("AuMenuItems")
public class AuMenuItemsController {
    @Autowired
    AuMenuItemsService auMenuItemsService;

    @PostMapping
    public ResponseEntity<AuMenuItemsResponse> save(@RequestBody AuMenuItemsSaveRequest request){
        AuMenuItemsResponse save=auMenuItemsService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<AuMenuItemsResponse> update(@RequestBody AuMenuItemsUpdateRequest updateRequest){
        AuMenuItemsResponse update=auMenuItemsService.update(updateRequest);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AuMenuItemsResponse> delete(@PathVariable("id") @NotBlank Integer id){
        AuMenuItemsResponse deleted = auMenuItemsService.delete(id);
        if(deleted==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuMenuItemsResponse> getOneById(@PathVariable Integer id){
        AuMenuItemsResponse get=auMenuItemsService.getById(id);

        if(get==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }

    @GetMapping("Active")
    public ResponseEntity<List<AuMenuItemsResponse>> getActiveList(){
        List<AuMenuItemsResponse> active = auMenuItemsService.getAllActive();
        return ResponseEntity.ok(active);
    }

    @GetMapping("")
    public ResponseEntity<List<AuMenuItemsResponse>> getNotDeletedList(){
        List<AuMenuItemsResponse> notDeleted = auMenuItemsService.getNotDeleted();
        return ResponseEntity.ok(notDeleted);
    }

    @GetMapping("GetByAlias/{alias}")
    public ResponseEntity<List<AuMenuItemsResponse>> getOneByAlias(@PathVariable String alias){
        List<AuMenuItemsResponse> one=auMenuItemsService.findByAlias(alias);

        if(one==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(one);
    }

    @GetMapping("GetByParentId/{parentId}")
    public @ResponseBody ResponseEntity<List<AuMenuItemsResponse>> getListByParentId(@PathVariable String parentId){
        List<AuMenuItemsResponse> list=auMenuItemsService.findByParentId(parentId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("NavigationMenuItems")
    public @ResponseBody ResponseEntity<List<AuMenuItemsResponse>> getNavigationMenuItems(@PathVariable String parentId){
        List<AuMenuItemsResponse> list=auMenuItemsService.navigationMenuItems();
        return ResponseEntity.ok(list);
    }
}
