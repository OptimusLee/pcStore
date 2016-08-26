package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.Employee.ContactDetails;
import za.ac.cput.cuanlee.domain.Employee.Employee;
import za.ac.cput.cuanlee.domain.Employee.GeographicalDetails;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface EmployeeFactory {
    Employee createEmployee(String username, String password, String firstName, String lastName, String gender, ContactDetails contactDetails, GeographicalDetails geographicalDetails, String idNumber, Integer loggedIn);
}
