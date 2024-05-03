package lk.coop;

import lk.coop.entity.Root;
import lk.coop.entity.Vehicle;
import lk.coop.repository.VehicleRepository;
import org.springframework.boot.test.context.SpringBootTest;
import lk.coop.enums.Status;

import lk.coop.repository.RootRepository;
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
public class vehicleTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    @Transactional
    public void createVehicle() {

        Vehicle cu = new Vehicle();
        cu.setId(1);
        cu.setOwner("praneeth rangana");
        cu.setRootId("1");
        cu.setSeatCount("10");
        cu.setStatus(Status.ACTIVE);
        cu.setType("van");
        cu.setVehicleNo("NC-4520");
        cu.setYear("2020");
        vehicleRepository.save(cu);
        assertNotNull(vehicleRepository.findById(1).get());
    }

    @Test
    @Transactional
    public void getallVehicle() {
        List<Vehicle> lis = vehicleRepository.findAll();
    }
    @Test
    @Transactional
    public void getoneVehicle() {
        Vehicle cu = new Vehicle();
        cu.setId(1);
        cu.setOwner("P.Praneeth Rangana");
        cu.setRootId("1");
        cu.setSeatCount("10");
        cu.setStatus(Status.ACTIVE);
        cu.setType("van");
        cu.setVehicleNo("NC-4520");
        cu.setYear("2020");
        Vehicle lis = vehicleRepository.getById(1);
        assertEquals(cu.getOwner(), lis.getOwner());
    }
    @Test
    @Transactional
    public void testUpdateVehicle() {
        Vehicle lis = vehicleRepository.getById(1);
        lis.setType("VAN");
        vehicleRepository.save(lis);
        assertNotEquals("VANN", vehicleRepository.getById(1).getType().toString());
    }

    @Test
    @Transactional
    public void testdeleteVehicle() {
        vehicleRepository.deleteById(1);
    }



}
