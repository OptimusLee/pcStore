package za.ac.cput.cuanlee.services.PC.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.repository.PC.RAMRepository;
import za.ac.cput.cuanlee.services.PC.RAMService;

import java.util.*;

/**
 * Created by CuanL on 10/08/2016.
 */
@Service
public class RAMServiceImpl implements RAMService{
    @Autowired
    RAMRepository repository;

    @Override
    public RAM add(RAM ram)
    {
        return repository.save(ram);
    }

    @Override
    public RAM update(RAM ram) {
        return repository.save(ram);
    }

    @Override
    public RAM getById(Long ramId) {
        return repository.findOne(ramId);
    }

    @Override
    public List<RAM> getAll() {
        List<RAM> result = new ArrayList<>();

        Iterable<RAM> ramIterator = repository.findAll();
        for (RAM ram: ramIterator)
        {
            result.add(ram);
        }
        return result;
    }

    @Override
    public List<RAM> getAllActive() {
        List<RAM> result = new ArrayList<>();

        Iterable<RAM> ramIterator = repository.findAll();
        for (RAM ram: ramIterator)
        {
            if(ram.getActiveStock().intValue() == 1)
                result.add(ram);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<RAM> allRAM = repository.findAll();

        for (RAM record: allRAM)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public void delete(RAM ram) {
        repository.delete(ram);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
