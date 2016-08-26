package za.ac.cput.cuanlee.TestDomain.Employee;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.Employee.GeographicalDetails;
import za.ac.cput.cuanlee.factories.GeographicalDetailsFactory;
import za.ac.cput.cuanlee.factories.impl.GeographicalDetailsFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestGeographicalDetailsFactory {
    private GeographicalDetailsFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = GeographicalDetailsFactoryImpl.getInstance();
    }

    @Test
    public void testGeoCreation()
    {
        GeographicalDetails geographicalDetails = factory.createGeographicalDetails("SA", "WC", "Cape Town", "Brackenfell", "Long", 55);
        Assert.assertEquals("Long", geographicalDetails.getStreet());
    }

    @Test
    public void testGeoCreationUpdate()
    {
        GeographicalDetails geographicalDetails = factory.createGeographicalDetails("SA", "WC", "Cape Town", "Brackenfell", "Long", 55);
        Assert.assertEquals("Long", geographicalDetails.getStreet());

        GeographicalDetails updateGeo = new GeographicalDetails.Builder()
                .copy(geographicalDetails)
                .houseNumber(123)
                .build();

        Assert.assertEquals(123, updateGeo.getHouseNumber().intValue());
        Assert.assertEquals("Brackenfell", updateGeo.getSuburb());
    }
}
