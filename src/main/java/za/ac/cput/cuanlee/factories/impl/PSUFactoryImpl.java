package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.PSU;
import za.ac.cput.cuanlee.factories.PSUFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class PSUFactoryImpl implements PSUFactory {
    private static PSUFactoryImpl factory = null;

    private PSUFactoryImpl(){

    }

    public static PSUFactoryImpl getInstance(){
        if (factory == null)
            factory = new PSUFactoryImpl();

        return factory;
    }

    public PSU createPSU(String code, String description, Integer watts, Integer four_pin_molex, Integer sata_connectors, Integer floppy_connectors, Integer stock, Integer activeStock){
        PSU ram = new PSU.Builder()
                .code(code)
                .description(description)
                .watts(watts)
                .four_pin_molex(four_pin_molex)
                .sata_connectors(sata_connectors)
                .floppy_connectors(floppy_connectors)
                .stock(stock)
                .activeStock(activeStock)
                .build();
        return ram;
    }
}
