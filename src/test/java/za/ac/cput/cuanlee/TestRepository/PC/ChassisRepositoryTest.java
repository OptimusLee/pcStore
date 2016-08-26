package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.Chassis;
import za.ac.cput.cuanlee.factories.ChassisFactory;
import za.ac.cput.cuanlee.factories.impl.ChassisFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.ChassisRepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ChassisRepositoryTest extends AbstractTestNGSpringContextTests {
    /*private Long id;
    private ChassisFactory factory;

    @Autowired
    ChassisRepository repository;

    @Test
    public void setUp() throws Exception{
        factory = ChassisFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        Chassis chassis = factory.createComputer("7501212", "Monster Build", 1, 6, 4, 11, "ATX");
        System.out.println(chassis);
        repository.save(chassis);
        id = chassis.getId();
        Assert.assertNotNull(chassis.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Chassis chassis = repository.findOne(id);
        Assert.assertEquals("7501212", chassis.getCode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Chassis chassis = repository.findOne(id);
        Chassis newChassis = new Chassis.Builder()
                .copy(chassis)
                .code("Cuan Code")
                .build();

        repository.save(newChassis);

        Chassis updatedChassis = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedChassis.getCode());
    }*/

   // @Test(dependsOnMethods = "testUpdate")
   // public void testDelete() throws Exception {
      //  Chassis chassis = repository.findOne(id);
       // repository.delete(chassis);
       // Chassis newChassis = repository.findOne(id);
      //  Assert.assertNull(newChassis);
    //}
}
