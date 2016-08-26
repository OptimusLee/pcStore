package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.RAM;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface RAMFactory {
    RAM createRAM(String code, String description, String memorySize, double voltage, String memoryConfiguration, Integer stock, Integer activeStock);
}
