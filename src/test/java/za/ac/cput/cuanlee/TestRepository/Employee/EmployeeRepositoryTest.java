package za.ac.cput.cuanlee.TestRepository.Employee;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.cuanlee.App;
import za.ac.cput.cuanlee.domain.Employee.ContactDetails;
import za.ac.cput.cuanlee.domain.Employee.Employee;
import za.ac.cput.cuanlee.domain.Employee.GeographicalDetails;
import za.ac.cput.cuanlee.factories.ContactDetailsFactory;
import za.ac.cput.cuanlee.factories.EmployeeFactory;
import za.ac.cput.cuanlee.factories.GeographicalDetailsFactory;
import za.ac.cput.cuanlee.factories.impl.ContactDetailsFactoryImpl;
import za.ac.cput.cuanlee.factories.impl.EmployeeFactoryImpl;
import za.ac.cput.cuanlee.factories.impl.GeographicalDetailsFactoryImpl;
import za.ac.cput.cuanlee.repository.Employee.EmployeeRepository;

/**
 * Created by User on 2016/07/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeRepositoryTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private EmployeeFactory factory;
    private ContactDetailsFactory contactDetailsFactory;
    private GeographicalDetailsFactory geographicalDetailsFactory;

    @Autowired
    EmployeeRepository repository;

    @Test
    public void setUp() throws Exception{
        factory = EmployeeFactoryImpl.getInstance();
        contactDetailsFactory = ContactDetailsFactoryImpl.getInstance();
        geographicalDetailsFactory = GeographicalDetailsFactoryImpl.getInstance();
    }

    @Test(dependsOnMethods = "setUp")
    public void testCreate() throws Exception{
        ContactDetails contactDetails = contactDetailsFactory.createContactDetails("021312123", "cuan@g.com");
        GeographicalDetails geographicalDetails = geographicalDetailsFactory.createGeographicalDetails("SA", "WC", "Cape Town", "Brackenfell", "Long", 55);
        Employee employee = factory.createEmployee("cuanl26", "1234567", "Cuan", "Lee", "Male", contactDetails, geographicalDetails, "6546654564654", 1);
        System.out.println(employee);
        repository.save(employee);
        id = employee.getID();
        Assert.assertNotNull(employee.getID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Employee employee = repository.findOne(id);
        Assert.assertEquals("cuanl26", employee.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Employee employee = repository.findOne(id);
        Employee newEmployee = new Employee.Builder()
                .copy(employee)
                .password("Cuan Code")
                .build();

        repository.save(newEmployee);

        Employee updatedEmployee = repository.findOne(id);

        Assert.assertEquals("Cuan Code", updatedEmployee.getPassword());
    }

   // @Test(dependsOnMethods = "testUpdate")
  //  public void testDelete() throws Exception {
  //      Employee employee = repository.findOne(id);
   //     repository.delete(employee);
   //     Employee newEmployee = repository.findOne(id);
   //     Assert.assertNull(newEmployee);
    //}
}
