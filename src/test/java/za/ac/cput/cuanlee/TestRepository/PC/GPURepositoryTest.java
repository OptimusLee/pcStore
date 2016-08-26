package za.ac.cput.cuanlee.TestRepository.PC;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.PC.GPU;
import za.ac.cput.cuanlee.factories.GPUFactory;
import za.ac.cput.cuanlee.factories.impl.GPUFactoryImpl;
import za.ac.cput.cuanlee.repository.PC.GPURepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class GPURepositoryTest extends AbstractTestNGSpringContextTests {
    /*private Long id;
    private GPUFactory factory;

    @Autowired
    GPURepository repository;

    @Test
    public void setUp() throws Exception{
        factory = GPUFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        GPU gpu = factory.createGPU("gpuCode", "gpuDescription", 132, 121, "GDDR5", 132123, "PCIE3", 16, 1);
        System.out.println(gpu);
        repository.save(gpu);
        id = gpu.getId();
        Assert.assertNotNull(gpu.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        GPU gpu = repository.findOne(id);
        Assert.assertEquals("gpuCode", gpu.getCode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        GPU gpu = repository.findOne(id);
        GPU newGPU = new GPU.Builder()
                .copy(gpu)
                .code("Cuan Code")
                .build();

        repository.save(newGPU);

        GPU updatedGPU = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedGPU.getCode());
    }*/

    //@Test(dependsOnMethods = "testUpdate")
    ///public void testDelete() throws Exception {
    //    GPU gpu = repository.findOne(id);
    //    repository.delete(gpu);
    //    GPU newGPU = repository.findOne(id);
    //    Assert.assertNull(newGPU);
   // }
}
