package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.Motherboard;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface MotherboardFactory {
    Motherboard createMotherboard(String code, String description, String chipset, Integer sataPorts, Integer usb2, Integer usb3, String formFactor, Integer stock, Integer activeStock);
}
