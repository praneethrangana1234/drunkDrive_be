package lk.coop.controller;

import lk.coop.dto.request.AttendanceRequest;
import lk.coop.dto.request.AttendanceUpdateRequest;
import lk.coop.dto.response.AttendanceResponse;
import lk.coop.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Attendance")
@RestController
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    @PostMapping
    public ResponseEntity<AttendanceResponse> save(@Valid @RequestBody AttendanceRequest request){
        AttendanceResponse save = attendanceService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<AttendanceResponse> update(@Valid @RequestBody AttendanceUpdateRequest request){
        AttendanceResponse updated = attendanceService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<List<AttendanceResponse>> getById(@PathVariable("id") @NotBlank String id){
        List<AttendanceResponse> get = attendanceService.findTop10ByEpfOrderByDateDescTimeeDesc(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<AttendanceResponse>> getAll(){
        List<AttendanceResponse> getall = attendanceService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = attendanceService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
    @GetMapping("sendmail/{epf}/{date}/{time}")

    public ResponseEntity<Integer> sendmailtotop(@PathVariable("epf") String epf, @PathVariable("date") String date, @PathVariable("time") String time) {

        int sendtotop = attendanceService.sendmailtotop(epf, date, time);
        if (sendtotop == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sendtotop);
    }

}