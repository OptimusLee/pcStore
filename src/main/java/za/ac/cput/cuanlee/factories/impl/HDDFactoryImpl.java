package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.HDD;
import za.ac.cput.cuanlee.factories.HDDFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class HDDFactoryImpl implements HDDFactory {
    private static HDDFactoryImpl factory = null;

    private HDDFactoryImpl(){

    }

    public static HDDFactoryImpl getInstance(){
        if (factory == null)
            factory = new HDDFactoryImpl();

        return factory;
    }

    public HDD createHDD(String code, String description, double size_MB, double rpm, Integer sata, Integer stock, Integer activeStock){
        HDD hdd = new HDD.Builder()
                .code(code)
                .description(description)
                .size_MB(size_MB)
                .rpm(rpm)
                .sata(sata)
                .activeStock(activeStock)
                .stock(stock)
                .build();
        return hdd;
    }
}
