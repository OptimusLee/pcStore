package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.PSU;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface PSUFactory {
    PSU createPSU(String code, String description, Integer watts, Integer four_pin_molex, Integer sata_connectors, Integer floppy_connectors, Integer stock, Integer activeStock);
}
