package za.ac.cput.cuanlee.factories;


import za.ac.cput.cuanlee.domain.PC.CPU;

/**
 * Created by Cuan on 4/3/2016.
 */
public interface CPUFactory {
    CPU createCPU(String code, String description, Integer socket, String processorBrand, double speed_Ghz, double cache_MB, Integer cores, Integer stock, Integer activeStock);
}
