package za.ac.cput.cuanlee.TestDomain.PC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.PC.GPU;
import za.ac.cput.cuanlee.factories.GPUFactory;
import za.ac.cput.cuanlee.factories.impl.GPUFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestGPUFactory {
    private GPUFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = GPUFactoryImpl.getInstance();
    }

    @Test
    public void testGPUCreation()
    {
        GPU gpu = factory.createGPU( "gpuCode", "gpuDescription", 132, 121, "GDDR5", 132123, "PCIE3",16, 1);
        Assert.assertEquals("GDDR5", gpu.getMemoryType());
    }

    @Test
    public void testGPUCreationUpdate()
    {
        GPU gpu = factory.createGPU("gpuCode", "gpuDescription", 132, 121, "GDDR5", 132123, "PCIE3",16, 1);
        Assert.assertEquals("GDDR5", gpu.getMemoryType());

        GPU upodateGPU = new GPU.Builder()
                .copy(gpu)
                .description("Nvidia")
                .build();

        Assert.assertEquals("Nvidia", upodateGPU.getDescription());
        Assert.assertEquals("gpuCode", upodateGPU.getCode());
    }
}
