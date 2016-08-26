package za.ac.cput.cuanlee.services.PC.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.domain.PC.GPU;
import za.ac.cput.cuanlee.repository.PC.CPURepository;
import za.ac.cput.cuanlee.services.PC.CPUService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuan on 2016/08/15.
 */

@Service
public class CPUServiceImpl implements CPUService{

    @Autowired
    CPURepository repository;

    @Override
    public CPU add(CPU entity) {
        return repository.save(entity);
    }

    @Override
    public CPU update(CPU entity) {
        return repository.save(entity);
    }

    @Override
    public CPU getById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<CPU> getAll() {
        List<CPU> result = new ArrayList<>();

        Iterable<CPU> cpuIterable = repository.findAll();
        for (CPU cpu: cpuIterable)
        {
            result.add(cpu);
        }
        return result;
    }

    @Override
    public List<CPU> getAllActive() {
        List<CPU> result = new ArrayList<>();

        Iterable<CPU> cpuIterable = repository.findAll();
        for (CPU cpu: cpuIterable)
        {
            if(cpu.getActiveStock().intValue() == 1)
                result.add(cpu);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<CPU> allCpu = repository.findAll();

        for (CPU record: allCpu)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public void delete(CPU entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
