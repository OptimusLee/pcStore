package za.ac.cput.cuanlee.TestDomain.PC;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.PC.Chassis;
import za.ac.cput.cuanlee.factories.ChassisFactory;
import za.ac.cput.cuanlee.factories.MotherboardFactory;
import za.ac.cput.cuanlee.factories.impl.ChassisFactoryImpl;
import za.ac.cput.cuanlee.factories.impl.MotherboardFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestChassisFactory {
    private ChassisFactory factory;
    private MotherboardFactory mobofactory;

    @Before
    public void setUp() throws Exception{
        factory = ChassisFactoryImpl.getInstance();
        mobofactory = MotherboardFactoryImpl.getInstance();
    }

    @Test
    public void testComputerCreation()
    {
        Chassis chassis = factory.createComputer("7501212","Monster Build",1,6,4,11,"ATX");
        Assert.assertEquals(1, chassis.getActiveStock().intValue());
        Assert.assertEquals(4, chassis.getCaseFans().intValue());
    }

    @Test
    public void testComputerCreationUpdate()
    {
        Chassis chassis = factory.createComputer("7501212","Monster Build",1,6,4,11,"ATX");
        Assert.assertEquals(1, chassis.getActiveStock().intValue());
        Assert.assertEquals(4, chassis.getCaseFans().intValue());

        Chassis updateChassis = new Chassis.Builder()
                .copy(chassis)
                .activeStock(0)
                .hddBays(1)
                .build();

        Assert.assertEquals(0, updateChassis.getActiveStock().intValue());
        Assert.assertEquals(1, updateChassis.getHddBays().intValue());
    }
}
