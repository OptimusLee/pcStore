package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.factories.CPUFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class CPUFactoryImpl implements CPUFactory {
    private static CPUFactoryImpl factory = null;

    private CPUFactoryImpl(){

    }

    public static CPUFactoryImpl getInstance(){
        if (factory == null)
            factory = new CPUFactoryImpl();

        return factory;
    }

    public CPU createCPU(String code, String description, Integer socket, String processorBrand, double speed_Ghz, double cache_MB, Integer cores, Integer stock, Integer activeStock){
        CPU cpu = new CPU.Builder()
                .code(code)
                .description(description)
                .socket(socket)
                .processorBrand(processorBrand)
                .speed_Ghz(speed_Ghz)
                .cache_MB(cache_MB)
                .cores(cores)
                .stock(stock)
                .activeStock(activeStock)
                .build();
        return cpu;
    }
}
