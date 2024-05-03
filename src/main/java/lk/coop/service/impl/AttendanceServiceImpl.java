package lk.coop.service.impl;

import lk.coop.dto.request.AttendanceRequest;
import lk.coop.dto.request.AttendanceUpdateRequest;
import lk.coop.dto.response.AttendanceResponse;
import lk.coop.entity.Attendance;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.AttendanceRepository;
import lk.coop.service.AttendanceService;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;



    @Override
@Transactional
    public AttendanceResponse save(AttendanceRequest request) {

        Attendance attendance=new Attendance();
attendance.setDate(request.getDate());
attendance.setEpf(request.getEpf());
attendance.setLocation(request.getLocation());
attendance.setTimee(request.getTimee());
        attendance.setDr_status(request.getDrStatus());
        attendance.setIsDeleted(Deleted.NO);
        attendance.setStatus(Status.ACTIVE);

Attendance save=attendanceRepository.save(attendance);

        return convert(save);
    }

    @Override
    @Transactional
    public AttendanceResponse update(AttendanceUpdateRequest request) {

Attendance attendance = attendanceRepository.findById(request.getId()).orElse(null);
        if(attendance==null){
            return null;
        }

attendance.setId(request.getId());
attendance.setDate(request.getDate());
attendance.setEpf(request.getEpf());
attendance.setId(request.getId());
attendance.setLocation(request.getLocation());
attendance.setTimee(request.getTimee());
attendance.setDr_status(request.getDrStatus());
Attendance updated=attendanceRepository.save(attendance);

        return (convert(updated));
    }

    @Override
    public List<AttendanceResponse> findTop10ByEpfOrderByDateDescTimeeDesc(String id) {

       return attendanceRepository.findTop10ByEpfOrderByDateDescTimeeDesc(id).stream().map(AttendanceServiceImpl::convert).collect(Collectors.toList());
    }

    @Override
    public List<AttendanceResponse> getAll() {

        return  attendanceRepository.findAll()
                .stream().map(AttendanceServiceImpl::convert).collect(Collectors.toList());

    }

    @Override
    public Integer sendmailtotop(String epf, String date, String time) {
        System.out.println("Done one");

        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        final String username = "praneethrangana76@gmail.com";
        final String password = "btbsqggzfxcwxupr";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        //  Session sessio= Session.class.geti

        System.out.println("Done two");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {
            Message message = new MimeMessage(session);
            // Message message = new MimeMessage((MimeMessage) session);
            message.setFrom(new InternetAddress("praneethrangana76@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("praneethrangana777@gmail.com")
            );
            message.setSubject("Appointment");
            message.setText("Dear Sir,"
                    + "\n\n EPF : "+epf+"\n\n"
                            + "\n\n Date : "+date
                            + "\n\n Time : "+time
                            +"\n\n Drunk test positive");

            Transport.send(message);

            System.out.println("Done");
            return 1;
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    @Transactional
    public Integer delete(Integer id) {

Attendance got=attendanceRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }
      //  got.setIsDeleted(Deleted.YES);
        attendanceRepository.save(got);

        return  1;
    }

private static AttendanceResponse convert(Attendance attendance){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        AttendanceResponse typeResponse=new AttendanceResponse();
typeResponse.setDate(attendance.getDate());
typeResponse.setEpf(attendance.getEpf());
typeResponse.setId(attendance.getId());
typeResponse.setLocation(attendance.getLocation());
typeResponse.setTimee(attendance.getTimee());
        typeResponse.setId(attendance.getId());
    typeResponse.setDrStatus(attendance.getDr_status());
        typeResponse.setCreatedBy(attendance.getCreatedBy());
        typeResponse.setCreatedDateTime(sdf.format(attendance.getCreatedDateTime()));
        typeResponse.setModifiedBy(attendance.getModifiedBy());
        typeResponse.setModifiedDateTime(sdf.format(attendance.getModifiedDateTime()));
       typeResponse.setIsDeleted(attendance.getIsDeleted());
    typeResponse.setStatus(attendance.getStatus());
return typeResponse;
    }
}