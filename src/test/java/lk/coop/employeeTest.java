package lk.coop;


import lk.coop.entity.Employee;
import lk.coop.enums.Status;
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


//import static org.junit.Assert.*;


@SpringBootTest
public class employeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    public void createEmployee() {
        Employee cu = new Employee();
        cu.setId(4);
        cu.setAdress("Matara");
        cu.setAge("32");
        cu.setCurrentOcation("Matara");
        cu.setDob("2024-04-01");
        cu.setEmpType("permenent");
        cu.setGender("male");
        cu.setName("praneeth Rangana");
        cu.setNic("921880286v");
        cu.setStatus(Status.ACTIVE);
        cu.setVehicleId("1");
        employeeRepository.save(cu);
        assertNotNull(employeeRepository.findById(4).get());
    }

    @Test
    @Transactional
    public void getallEmployee() {
        List<Employee> lis = employeeRepository.findAll();
    }
    @Test
    @Transactional
    public void getoneEmployee() {
        Employee cu = new Employee();
        cu.setId(4);
        cu.setAdress("Matara");
        cu.setAge("32");
        cu.setCurrentOcation("Matara");
        cu.setDob("2024-04-01");
        cu.setEmpType("permenent");
        cu.setGender("male");
        cu.setName("praneeth Rangana");
        cu.setNic("921880286v");
        cu.setStatus(Status.ACTIVE);
        cu.setVehicleId("1");
        Employee lis = employeeRepository.getById(4);
        assertEquals(cu.getNic(), lis.getNic());
    }

    @Test
    @Transactional
    public void testUpdateEmployee() {
        Employee lis = employeeRepository.getById(4);
        lis.setName("praneeth madusanka");
        employeeRepository.save(lis);
        assertNotEquals("praneeth madu", employeeRepository.getById(4).getName().toString());
    }

    @Test
    @Transactional
    public void testdeleteEmployee() {
        employeeRepository.deleteById(4);
    }


}
