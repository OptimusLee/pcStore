package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.factories.CPUFactory;
import za.ac.cput.cuanlee.factories.impl.CPUFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.CPURepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CPURepositoryTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private CPUFactory factory;

    @Autowired
    CPURepository repository;

    @Test
    public void setUp() throws Exception{
        factory = CPUFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        CPU cpu = factory.createCPU("5351AA", "Intel Skylake", 1150, "Intel", 132323, 123, 8, 22, 1);
        System.out.println(cpu);
        repository.save(cpu);
        id = cpu.getId();
        Assert.assertNotNull(cpu.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        CPU cpu = repository.findOne(id);
        Assert.assertEquals("5351AA", cpu.getCode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        CPU cpu = repository.findOne(id);
        CPU newCPU = new CPU.Builder()
                .copy(cpu)
                .code("Cuan Code")
                .build();

        repository.save(newCPU);

        CPU updatedCPU = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedCPU.getCode());
    }

    //@Test(dependsOnMethods = "testUpdate")
    //public void testDelete() throws Exception {
     //   CPU cpu = repository.findOne(id);
     //   repository.delete(cpu);
     //   CPU newCpu = repository.findOne(id);
     //   Assert.assertNull(newCpu);
    //}
}
