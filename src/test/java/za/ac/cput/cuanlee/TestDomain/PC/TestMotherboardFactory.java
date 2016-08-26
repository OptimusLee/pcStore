package za.ac.cput.cuanlee.TestDomain.PC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.PC.Motherboard;
import za.ac.cput.cuanlee.factories.MotherboardFactory;
import za.ac.cput.cuanlee.factories.impl.MotherboardFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestMotherboardFactory {
    private MotherboardFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = MotherboardFactoryImpl.getInstance();
    }

    @Test
    public void testMOBOreation()
    {
        Motherboard motherboard = factory.createMotherboard("Asus B85m", "Asus Golden Series","1150",2133,4,2, "ATX",12,1);
        Assert.assertEquals(1, motherboard.getActiveStock().intValue());
        Assert.assertEquals("Asus B85m", motherboard.getCode());
    }

    @Test
    public void testMOBOCreationUpdate()
    {
        Motherboard motherboard = factory.createMotherboard("Asus B85m", "Asus Golden Series","1150",2133,4,2, "ATX",12,1);
        Assert.assertEquals(1, motherboard.getActiveStock().intValue());
        Assert.assertEquals("Asus B85m", motherboard.getCode());

        Motherboard updateMobo = new Motherboard.Builder()
                .copy(motherboard)
                .activeStock(0)
                .code("Asus b777")
                .build();

        Assert.assertEquals(0, updateMobo.getActiveStock().intValue());
        Assert.assertEquals("Asus b777", updateMobo.getCode());
        Assert.assertEquals("Asus Golden Series", updateMobo.getDescription());
    }

}
