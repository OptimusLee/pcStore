package za.ac.cput.cuanlee.TestDomain.PC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.factories.CPUFactory;
import za.ac.cput.cuanlee.factories.impl.CPUFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestCPUFactory {
    private CPUFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = CPUFactoryImpl.getInstance();
    }

    @Test
    public void testCPUCreation()
    {
        CPU cpu = factory.createCPU("5351AA","Intel Skylake",1150, "Intel",132323,123,8, 22,1);
        Assert.assertEquals(1, cpu.getActiveStock().intValue());
    }

    @Test
    public void testCPUCreationUpdate()
    {
        CPU cpu = factory.createCPU("5351AA","Intel Skylake",1150, "Intel",132323,123,8, 22,1);
        Assert.assertEquals(1, cpu.getActiveStock().intValue());

        CPU updateCpu = new CPU.Builder()
                .copy(cpu)
                .activeStock(0)
                .build();

        Assert.assertEquals(0, updateCpu.getActiveStock().intValue());
        Assert.assertEquals(8, updateCpu.getCores().intValue());
    }
}
