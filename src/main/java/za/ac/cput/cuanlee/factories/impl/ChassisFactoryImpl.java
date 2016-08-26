package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.Chassis;
import za.ac.cput.cuanlee.factories.ChassisFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class ChassisFactoryImpl implements ChassisFactory {
    private static ChassisFactoryImpl factory = null;

    private ChassisFactoryImpl(){

    }

    public static ChassisFactoryImpl getInstance(){
        if (factory == null)
            factory = new ChassisFactoryImpl();

        return factory;
    }

    public Chassis createComputer(String code, String description, Integer activeStock, Integer hddBays, Integer caseFans, Integer stock, String formFactor){
        Chassis chassis = new Chassis.Builder()
                .code(code)
                .description(description)
                .hddBays(hddBays)
                .caseFans(caseFans)
                .formFactor(formFactor)
                .stock(stock)
                .activeStock(activeStock)
                .build();
        return chassis;
    }
}
