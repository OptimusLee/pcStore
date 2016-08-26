package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.HDD;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface HDDFactory {
    HDD createHDD(String code, String description, double size_MB, double rpm, Integer sata, Integer stock, Integer activeStock);
}
