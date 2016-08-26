package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.GPU;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface GPUFactory {
    GPU createGPU(String code, String description, Integer bitMemory, Integer memorySize_GB, String memoryType, double memoryClock_MHz, String cardBus, Integer stock, Integer activeStock);
}
