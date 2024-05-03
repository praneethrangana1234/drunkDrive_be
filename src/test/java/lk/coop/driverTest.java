package lk.coop;
import lk.coop.entity.Driver;
import lk.coop.entity.Employee;
import lk.coop.enums.Status;
import lk.coop.repository.DriverRepository;
import lk.coop.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class driverTest {
    @Autowired
    private DriverRepository driverRepository;
    @Test
    @Transactional
    public void createDriver() {
        Driver cu = new Driver();
        cu.setId(1);
        cu.setDriverAdd("Matara");
        cu.setAge("32");
        cu.setTelNo("0766615633");
        cu.setType("permenent");
        cu.setDob("2024-04-01");
        cu.setGender("male");
        cu.setDriverName("praneeth Rangana");
        cu.setNic("921880286v");
        cu.setStatus(Status.ACTIVE);
        cu.setVehicleId("1");
        cu.setRootId("1");
        cu.setMarrages("single");
        cu.setLizenno("14151213");
        driverRepository.save(cu);
        assertNotNull(driverRepository.findById(1).get());
    }
    @Test
    @Transactional
    public void getallDriver() {
        List<Driver> lis = driverRepository.findAll();
    }
    @Test
    @Transactional
    public void getoneDriver() {
        Driver cu = new Driver();
        cu.setId(1);
        cu.setDriverAdd("Matara");
        cu.setAge("32");
        cu.setTelNo("0766615633");
        cu.setType("permenent");
        cu.setDob("2024-04-01");
        cu.setGender("male");
        cu.setDriverName("praneeth Rangana");
        cu.setNic("921880245v");
        cu.setStatus(Status.ACTIVE);
        cu.setVehicleId("1");
        cu.setRootId("1");
        cu.setMarrages("single");
        cu.setLizenno("14151213");
        Driver lis = driverRepository.getById(1);
        assertEquals(cu.getNic(), lis.getNic());
    }
    @Test
    @Transactional
    public void testUpdateDriver() {
        Driver lis = driverRepository.getById(1);
        lis.setDriverName("praneeth madusanka");
        driverRepository.save(lis);
        assertNotEquals("praneeth madu", driverRepository.getById(1).getDriverName().toString());
    }
    @Test
    @Transactional
    public void testdeleteDriver() {
        driverRepository.deleteById(1);
    }





}
