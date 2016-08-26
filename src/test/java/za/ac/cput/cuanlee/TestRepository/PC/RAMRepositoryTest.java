package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.factories.RAMFactory;
import za.ac.cput.cuanlee.factories.impl.RAMFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.RAMRepository;
import org.testng.annotations.Test;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RAMRepositoryTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private RAMFactory factory;

    @Autowired
    RAMRepository repository;

    @Test
    public void setUp() throws Exception{
        factory = RAMFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        RAM ram = factory.createRAM("vengance","corsair vengance ram","4GB",400.00,"Dula Module",22,0);
        System.out.println(ram);
        repository.save(ram);
        id = ram.getId();
        Assert.assertNotNull(ram.getId());
        Assert.assertNotNull(ram.getActiveStock());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        RAM ram = repository.findOne(id);
        Assert.assertEquals("vengance", ram.getCode());
        Assert.assertEquals(0, ram.getActiveStock().intValue());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        RAM ram = repository.findOne(id);
        RAM newRam = new RAM.Builder()
                .copy(ram)
                .code("Cuan Code")
                .build();

        repository.save(newRam);

        RAM updatedRAM = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedRAM.getCode());
    }

    //@Test(dependsOnMethods = "testUpdate")
    //public void testDelete() throws Exception {
      //  RAM ram = repository.findOne(id);
        //repository.delete(ram);
        //RAM newRam = repository.findOne(id);
        //Assert.assertNull(newRam);
    //}
}
