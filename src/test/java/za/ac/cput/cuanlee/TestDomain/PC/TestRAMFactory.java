package za.ac.cput.cuanlee.TestDomain.PC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.factories.RAMFactory;
import za.ac.cput.cuanlee.factories.impl.RAMFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestRAMFactory {
    private RAMFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = RAMFactoryImpl.getInstance();
    }

    @Test
    public void testRAMCreation()
    {
        RAM ram = factory.createRAM("vengance","corsair vengance ram","4GB",400,"Dula Module",22,0);
        Assert.assertEquals(0, ram.getActiveStock().intValue());
    }

    @Test
    public void testRAMCreationUpdate()
    {
        RAM ram = factory.createRAM("vengance","corsair vengance ram","4GB",400,"Dula Module",22,0);
        Assert.assertEquals(0, ram.getActiveStock().intValue());

        RAM updateRAM = new RAM.Builder()
                .copy(ram)
                .activeStock(0)
                .build();

        Assert.assertEquals(0, updateRAM.getActiveStock().intValue());
        Assert.assertEquals("vengance", updateRAM.getCode());
    }
}
