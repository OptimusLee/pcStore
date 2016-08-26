package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.Employee.ContactDetails;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface ContactDetailsFactory {
    ContactDetails createContactDetails(String telephone, String email);
}
