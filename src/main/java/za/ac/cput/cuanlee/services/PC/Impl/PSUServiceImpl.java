package za.ac.cput.cuanlee.services.PC.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.PSU;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.repository.PC.PSURepository;
import za.ac.cput.cuanlee.repository.PC.RAMRepository;
import za.ac.cput.cuanlee.services.PC.PSUService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuanL on 11/08/2016.
 */
@Service
public class PSUServiceImpl implements PSUService{

    @Autowired
    PSURepository repository;

    @Override
    public PSU add(PSU psu) {
        return repository.save(psu);
    }

    @Override
    public PSU update(PSU psu) {
        return repository.save(psu);
    }

    @Override
    public PSU getById(Long psuId) {
        return repository.findOne(psuId);
    }

    @Override
    public List<PSU> getAll() {
        List<PSU> result = new ArrayList<>();

        Iterable<PSU> psuIterator = repository.findAll();
        for (PSU psu: psuIterator )
        {
            result.add(psu);
        }
        return result;
    }

    @Override
    public void delete(PSU psu) {
        repository.delete(psu);
    }

    @Override
    public List<PSU> getAllActive() {
        List<PSU> result = new ArrayList<>();

        Iterable<PSU> psuIterator = repository.findAll();
        for (PSU psu: psuIterator )
        {
            if(psu.getActiveStock().intValue() == 1)
                result.add(psu);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<PSU> allPSU = repository.findAll();

        for (PSU record: allPSU)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
