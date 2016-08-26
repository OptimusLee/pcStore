package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.Employee.GeographicalDetails;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface GeographicalDetailsFactory {
    GeographicalDetails createGeographicalDetails(String country, String province, String city, String suburb, String street, Integer houseNumber);
}
