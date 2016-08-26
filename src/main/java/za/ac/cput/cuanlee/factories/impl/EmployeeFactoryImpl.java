package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.Employee.ContactDetails;
import za.ac.cput.cuanlee.domain.Employee.Employee;
import za.ac.cput.cuanlee.domain.Employee.GeographicalDetails;
import za.ac.cput.cuanlee.factories.EmployeeFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class EmployeeFactoryImpl implements EmployeeFactory {
    private static EmployeeFactoryImpl factory = null;

    private EmployeeFactoryImpl(){

    }

    public static EmployeeFactoryImpl getInstance(){
        if (factory == null)
            factory = new EmployeeFactoryImpl();

        return factory;
    }

    public Employee createEmployee(String username, String password, String firstName, String lastName, String gender, ContactDetails contactDetails, GeographicalDetails geographicalDetails, String idNumber, Integer loggedIn){
        Employee employee = new Employee.Builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .contactDetails(contactDetails)
                .geographicalDetails(geographicalDetails)
                .idNumber(idNumber)
                .loggedIn(loggedIn)
                .build();
        return employee;
    }

}
