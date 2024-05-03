package lk.coop;


import lk.coop.entity.Employee;
import lk.coop.entity.Root;
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
public class rootTest {
    @Autowired
    private RootRepository rootRepository;

    @Test
    @Transactional
    public void createroot() {
        Root cu = new Root();
        cu.setId(1);
        cu.setRootName("Matara");
        cu.setRootDiscription("Matara-Galle-Tangalle");
        cu.setStatus(Status.ACTIVE);
        rootRepository.save(cu);
        assertNotNull(rootRepository.findById(1).get());
    }

    @Test
    @Transactional
    public void getallroot() {
        List<Root> lis = rootRepository.findAll();
    }

    @Test
    @Transactional
    public void getoneroot() {
        Root cu = new Root();
        cu.setId(1);
        cu.setRootName("KOGGALA TO MATARA");
        cu.setRootDiscription("Matara-Galle-Tangalle");
        cu.setStatus(Status.ACTIVE);
        Root lis = rootRepository.getById(1);
        assertEquals(cu.getRootName(), lis.getRootName());
    }

    @Test
    @Transactional
    public void testUpdateroot() {
        Root lis = rootRepository.getById(1);
        lis.setRootName("GALLE");
        rootRepository.save(lis);
        assertNotEquals("MATARA", rootRepository.getById(1).getRootName().toString());
    }

    @Test
    @Transactional
    public void testdeleteroot() {
        rootRepository.deleteById(1);
    }



}
