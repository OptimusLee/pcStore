package za.ac.cput.cuanlee.TestDomain.Employee;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.cuanlee.domain.Employee.ContactDetails;
import za.ac.cput.cuanlee.factories.ContactDetailsFactory;
import za.ac.cput.cuanlee.factories.impl.ContactDetailsFactoryImpl;


/**
 * Created by Cuan on 4/3/2016.
 */
public class TestContactDetailsFactory {
    private ContactDetailsFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = ContactDetailsFactoryImpl.getInstance();
    }

    @Test
    public void testContactCreation()
    {
        ContactDetails contactDetails = factory.createContactDetails("021312123","cuan@g.com");
        Assert.assertEquals("cuan@g.com", contactDetails.getEmail());
    }

    @Test
    public void testContactCreationUpdate()
    {
        ContactDetails contactDetails = factory.createContactDetails("021312123", "cuan@g.com");
        Assert.assertEquals("cuan@g.com", contactDetails.getEmail());

        ContactDetails updateContact = new ContactDetails.Builder()
                .copy(contactDetails)
                .email("bbbb")
                .build();

        Assert.assertEquals("bbbb", updateContact.getEmail());
        Assert.assertEquals("021312123", updateContact.getTelephone());
    }
}
