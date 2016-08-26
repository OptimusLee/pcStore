package za.ac.cput.cuanlee.factories.impl;


import za.ac.cput.cuanlee.domain.PC.GPU;
import za.ac.cput.cuanlee.factories.GPUFactory;

/**
 * Created by Cuan on 4/3/2016.
 */
public class GPUFactoryImpl implements GPUFactory {
    private static GPUFactoryImpl factory = null;

    private GPUFactoryImpl(){

    }

    public static GPUFactoryImpl getInstance(){
        if (factory == null)
            factory = new GPUFactoryImpl();

        return factory;
    }

    public GPU createGPU(String code, String description, Integer bitMemory, Integer memorySize_GB, String memoryType, double memoryClock_MHz, String cardBus, Integer stock, Integer activeStock){
        GPU gpu = new GPU.Builder()
                .code(code)
                .description(description)
                .bitMemory(bitMemory)
                .memorySize_GB(memorySize_GB)
                .memoryType(memoryType)
                .memoryClock_MHz(memoryClock_MHz)
                .cardBus(cardBus)
                .stock(stock)
                .activeStock(activeStock)
                .build();
        return gpu;
    }
}
