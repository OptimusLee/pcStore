package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.PSU;
import za.ac.cput.cuanlee.factories.PSUFactory;
import za.ac.cput.cuanlee.factories.impl.PSUFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.PSURepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PSURepositoryTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private PSUFactory factory;

    @Autowired
    PSURepository repository;

    @Test
    public void setUp() throws Exception{
        factory = PSUFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        PSU psu = factory.createPSU("11234", "Raidmax Gold Series", 750, 6, 4, 0, 55, 1);
        System.out.println(psu);
        repository.save(psu);
        id = psu.getId();
        Assert.assertNotNull(psu.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        PSU psu = repository.findOne(id);
        Assert.assertEquals("11234", psu.getCode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        PSU psu = repository.findOne(id);
        PSU newPSU = new PSU.Builder()
                .copy(psu)
                .code("Cuan Code")
                .build();

        repository.save(newPSU);

        PSU updatedPSu = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedPSu.getCode());
    }

    //@Test(dependsOnMethods = "testUpdate")
    //public void testDelete() throws Exception {
       // PSU psu = repository.findOne(id);
     //   repository.delete(psu);
      //  PSU newPSU = repository.findOne(id);
     //   Assert.assertNull(newPSU);
    //}
}
