package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.Motherboard;
import za.ac.cput.cuanlee.factories.MotherboardFactory;
import za.ac.cput.cuanlee.factories.impl.MotherboardFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.MotherboardRepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class MotherboardRepositoryTest extends AbstractTestNGSpringContextTests {
    /*private Long id;
    private MotherboardFactory factory;

    @Autowired
    MotherboardRepository repository;

    @Test
    public void setUp() throws Exception{
        factory = MotherboardFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        Motherboard motherboard = factory.createMotherboard("Asus B85m", "Asus Golden Series", "1150", 2133, 4, 2, "ATX", 12, 1);
        System.out.println(motherboard);
        repository.save(motherboard);
        id = motherboard.getId();
        Assert.assertNotNull(motherboard.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Motherboard motherboard = repository.findOne(id);
        Assert.assertEquals("Asus B85m", motherboard.getCode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Motherboard motherboard = repository.findOne(id);
        Motherboard newMobo = new Motherboard.Builder()
                .copy(motherboard)
                .code("Cuan Code")
                .build();

        repository.save(newMobo);

        Motherboard updatedMobo = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedMobo.getCode());
    }*/

 //   @Test(dependsOnMethods = "testUpdate")
  //  public void testDelete() throws Exception {
    //    Motherboard motherboard = repository.findOne(id);
     //  repository.delete(motherboard);
       // Motherboard newMobo = repository.findOne(id);
        //Assert.assertNull(newMobo);
    //}
}
