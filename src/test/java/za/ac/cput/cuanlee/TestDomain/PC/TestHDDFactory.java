package za.ac.cput.cuanlee.TestDomain.PC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.PC.HDD;
import za.ac.cput.cuanlee.factories.HDDFactory;
import za.ac.cput.cuanlee.factories.impl.HDDFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestHDDFactory {
    private HDDFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = HDDFactoryImpl.getInstance();
    }

    @Test
    public void testPSUCreation()
    {
        HDD hdd = factory.createHDD("testCode","testDesc",1232,2331,0,32,1);
        Assert.assertEquals("testCode", hdd.getCode());
    }

    @Test
    public void testPSUCreationUpdate()
    {
        HDD hdd = factory.createHDD("testCode", "testDesc", 1232, 2331, 0,32, 1);
        Assert.assertEquals("testCode", hdd.getCode());

        HDD updateHDD = new HDD.Builder()
                .copy(hdd)
                .activeStock(1)
                .code("UpdateTestCode")
                .build();

        Assert.assertEquals(1, updateHDD.getActiveStock().intValue());
        Assert.assertEquals("UpdateTestCode", updateHDD.getCode());
    }
}
