package lk.coop.service.impl;

import lk.coop.dto.request.AttendanceRequest;
import lk.coop.dto.request.AttendanceUpdateRequest;
import lk.coop.dto.response.AttendanceResponse;
import lk.coop.entity.Attendance;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import lk.coop.repository.AttendanceRepository;
import lk.coop.service.AttendanceService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
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
    public List<Attendance> findByDateBetween(String fromDate, String toDate) {
        // Assuming your repository method is named findByDateBetween
        Sort sort = Sort.by(Sort.Direction.ASC, "date");
        return attendanceRepository.findByDateBetween(fromDate, toDate,sort);
    }

    @Override
    public List<Attendance> findByEpfAndDateBetween(String epf,String fromDate, String toDate) {
        // Assuming your repository method is named findByDateBetween
        Sort sort = Sort.by(Sort.Direction.ASC, "date");
        return attendanceRepository.findByEpfAndDateBetween( epf,fromDate, toDate,sort);
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
            message.setSubject("Notification");
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
            //typeResponse.setCreatedDateTime(sdf.format(attendance.getCreatedDateTime()));
    typeResponse.setCreatedDateTime((attendance.getCreatedDateTime()));

    typeResponse.setModifiedBy(attendance.getModifiedBy());
            typeResponse.setModifiedDateTime((attendance.getModifiedDateTime()));

       typeResponse.setIsDeleted(attendance.getIsDeleted());
    typeResponse.setStatus(attendance.getStatus());
return typeResponse;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public File printappoinmentall(String epf,String fromDate, String toDate ) {

        File pdf = null;
        try {
            File file = new File("C:\\Users\\HP\\Desktop\\jobs.jrxml");
//////////////////////////////


            HashMap map1 = new HashMap();
            ArrayList<HashMap> al = new ArrayList<>();

            Connection co = null;
            try {


                co = jdbc.con();
                Statement st1 = co.createStatement();
              //  String sql = "SELECT a.id,a.consult_id,a.country_id ,a.job_id,a.time_range,a.apply_date,a.approve,cs.name,c.name,j.job_type,se.name FROM the_job.appointment a inner join consultant cs on cs.id=a.consult_id inner join country c on c.id=a.country_id inner join job_type j on j.id=a.job_id inner join seeker se on se.id=a.seeker_id  order by a.apply_date desc";
                String sql = "SELECT * FROM drunken_drive.attendance where epf='"+epf+"' and date between '"+fromDate+"' and '"+toDate+"'  order by date desc";


                ResultSet r = st1.executeQuery(sql);
               // List<AddappointmentconResponse> unlogtot = new ArrayList<>();
                // List<PeDdctbleTypeRange> peDdctbleTypeRanges = new ArrayList<>();
                System.out.println(sql);

                while (r.next()) {

                    HashMap<String, Object> hashMap = new HashMap();
                    hashMap.put("epf", r.getString("epf"));
                    hashMap.put("date", r.getString("date"));
                    hashMap.put("time", r.getString("timee"));
                       String type = "";

                    hashMap.put("status", type);
                    al.add(hashMap);
                }
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(al);


                JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
                //  JasperPrint print = JasperFillManager.fillReport(jasperReport, map1, new JREmptyDataSource());
                JasperPrint print = JasperFillManager.fillReport(jasperReport, map1, dataSource);

                String var10000 = System.getProperty("user.home");

                String filepath = "C://Users//HP//Desktop//icbt//drunk drive(final)//final//crud//src//assets//" + "123" + ".pdf";

                JasperExportManager.exportReportToPdfFile(print, filepath);
                pdf = new File(filepath);
                System.out.println(map1);


            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdf;


    }

 /////////////////////////////

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public File printappoinment(String fromDate, String toDate) {

        File pdf = null;
        try {
            File file = new File("C:\\Users\\HP\\Desktop\\jobs.jrxml");
//////////////////////////////


            HashMap map1 = new HashMap();
            ArrayList<HashMap> al = new ArrayList<>();

            Connection co = null;
            try {


                co = jdbc.con();
                Statement st1 = co.createStatement();
                //  String sql = "SELECT a.id,a.consult_id,a.country_id ,a.job_id,a.time_range,a.apply_date,a.approve,cs.name,c.name,j.job_type,se.name FROM the_job.appointment a inner join consultant cs on cs.id=a.consult_id inner join country c on c.id=a.country_id inner join job_type j on j.id=a.job_id inner join seeker se on se.id=a.seeker_id  order by a.apply_date desc";
                String sql = "SELECT * FROM drunken_drive.attendance where  date between '"+fromDate+"' and '"+toDate+"'  order by date,epf desc";


                ResultSet r = st1.executeQuery(sql);
                // List<AddappointmentconResponse> unlogtot = new ArrayList<>();
                // List<PeDdctbleTypeRange> peDdctbleTypeRanges = new ArrayList<>();
                System.out.println(sql);

                while (r.next()) {

                    HashMap<String, Object> hashMap = new HashMap();
                    hashMap.put("epf", r.getString("epf"));
                    hashMap.put("date", r.getString("date"));
                    hashMap.put("time", r.getString("timee"));
                    String type = "";

                  //  hashMap.put("status", type);
                    al.add(hashMap);
                }
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(al);


                JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
                //  JasperPrint print = JasperFillManager.fillReport(jasperReport, map1, new JREmptyDataSource());
                JasperPrint print = JasperFillManager.fillReport(jasperReport, map1, dataSource);

                String var10000 = System.getProperty("user.home");

                String filepath = "C://Users//HP//Desktop//icbt//drunk drive(final)//final//crud//src//assets//" + "1234" + ".pdf";

                JasperExportManager.exportReportToPdfFile(print, filepath);
                pdf = new File(filepath);
                System.out.println(map1);


            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdf;


    }




}