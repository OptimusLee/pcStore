package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.HDD;
import za.ac.cput.cuanlee.factories.HDDFactory;
import za.ac.cput.cuanlee.factories.MotherboardFactory;
import za.ac.cput.cuanlee.factories.impl.HDDFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.HDDRepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class HDDRepositoryTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private HDDFactory factory;

    @Autowired
    HDDRepository repository;

    @Test
    public void setUp() throws Exception{
        factory = HDDFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        HDD hdd = factory.createHDD("testCode", "testDesc", 1232, 2331, 0, 32, 1);
        System.out.println(hdd);
        repository.save(hdd);
        id = hdd.getId();
        Assert.assertNotNull(hdd.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        HDD hdd = repository.findOne(id);
        Assert.assertEquals("testCode", hdd.getCode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        HDD hdd = repository.findOne(id);
        HDD newHdd = new HDD.Builder()
                .copy(hdd)
                .code("Cuan Code")
                .build();

        repository.save(newHdd);

        HDD updatedHdd = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedHdd.getCode());
    }

    //@Test(dependsOnMethods = "testUpdate")
    //public void testDelete() throws Exception {
    //   HDD hdd = repository.findOne(id);
   //     repository.delete(hdd);
    //    HDD newHDD = repository.findOne(id);
   //     Assert.assertNull(newHDD);
   // }
}
