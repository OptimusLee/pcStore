package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.Motherboard;
import za.ac.cput.cuanlee.factories.MotherboardFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class MotherboardFactoryImpl implements MotherboardFactory {
    private static MotherboardFactoryImpl factory = null;

    private MotherboardFactoryImpl(){

    }

    public static MotherboardFactoryImpl getInstance(){
        if (factory == null)
            factory = new MotherboardFactoryImpl();

        return factory;
    }

    public Motherboard createMotherboard(String code, String description, String chipset, Integer sataPorts, Integer usb2, Integer usb3, String formFactor, Integer stock, Integer activeStock){
        Motherboard motherboard = new Motherboard.Builder()
                .code(code)
                .description(description)
                .chipset(chipset)
                .sataPorts(sataPorts)
                .usb2(usb2)
                .usb3(usb3)
                .formFactor(formFactor)
                .stock(stock)
                .activeStock(activeStock)
                .build();
        return motherboard;
    }
}
