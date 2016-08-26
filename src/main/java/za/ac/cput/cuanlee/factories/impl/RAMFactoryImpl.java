package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.factories.RAMFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class RAMFactoryImpl implements RAMFactory {
    private static RAMFactoryImpl factory = null;

    private RAMFactoryImpl(){

    }

    public static RAMFactoryImpl getInstance(){
        if (factory == null)
            factory = new RAMFactoryImpl();

        return factory;
    }

    public RAM createRAM(String code, String description, String memorySize, double voltage, String memoryConfiguration, Integer stock, Integer activeStock){
        RAM ram = new RAM.Builder()
                .code(code)
                .description(description)
                .memorySize(memorySize)
                .voltage(voltage)
                .memoryConfiguration(memoryConfiguration)
                .stock(stock)
                .activeStock(activeStock)
                .build();
        return ram;
    }
}
