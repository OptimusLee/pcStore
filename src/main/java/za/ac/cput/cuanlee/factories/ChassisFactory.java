package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.Chassis;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface ChassisFactory {
    Chassis createComputer(String code, String description, Integer activeStock, Integer hddBays, Integer caseFans, Integer stock, String formFactor);
}
