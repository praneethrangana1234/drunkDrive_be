package lk.coop.controller;

import lk.coop.dto.request.AttendanceRequest;
import lk.coop.dto.request.AttendanceUpdateRequest;
import lk.coop.dto.response.AttendanceResponse;
import lk.coop.entity.Attendance;
import lk.coop.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    @GetMapping("/findByDateBetween")
    public ResponseEntity<List<Attendance>> findByDateBetween(@RequestParam String fromDate, @RequestParam String toDate) {
        List<Attendance> attendanceList = attendanceService.findByDateBetween(fromDate, toDate);
        return ResponseEntity.ok(attendanceList);
    }
    @GetMapping("/findByEpfAndDateBetween")
    public ResponseEntity<List<Attendance>> findByEpfAndDateBetween(@RequestParam String epf,@RequestParam String fromDate, @RequestParam String toDate) {
        List<Attendance> attendanceList = attendanceService.findByEpfAndDateBetween(epf,fromDate, toDate);
        return ResponseEntity.ok(attendanceList);
    }
    @GetMapping("PrintAppointment")
    public ResponseEntity<Resource> PrintAppointment(@RequestParam String epf,@RequestParam String fromDate, @RequestParam String toDate) {

        try {
            File printGenerate = this.attendanceService.printappoinmentall(epf,fromDate, toDate);
            Path path = Paths.get(printGenerate.getAbsolutePath());
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Content-Disposition", "attachment; filename=" + printGenerate.getName());
            return (ResponseEntity.ok().headers(headers)).contentLength(printGenerate.length()).contentType(MediaType.parseMediaType("application/pdf")).body(resource);

        } catch (Exception var6) {
            var6.printStackTrace();

        }

        return null;

    }
   // public File printappoinment(String fromDate, String toDate) {
        @GetMapping("PrintAppointmentall")
        public ResponseEntity<Resource> printappoinmentall(@RequestParam String fromDate, @RequestParam String toDate) {

            try {
                File printGenerate = this.attendanceService.printappoinment(fromDate, toDate);
                Path path = Paths.get(printGenerate.getAbsolutePath());
                ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");
                headers.add("Content-Disposition", "attachment; filename=" + printGenerate.getName());
                return (ResponseEntity.ok().headers(headers)).contentLength(printGenerate.length()).contentType(MediaType.parseMediaType("application/pdf")).body(resource);

            } catch (Exception var6) {
                var6.printStackTrace();

            }

            return null;

        }



    }