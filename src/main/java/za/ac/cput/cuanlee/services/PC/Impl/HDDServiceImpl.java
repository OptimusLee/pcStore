package za.ac.cput.cuanlee.services.PC.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.HDD;
import za.ac.cput.cuanlee.repository.PC.HDDRepository;
import za.ac.cput.cuanlee.services.PC.HDDService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuan on 2016/08/15.
 */

@Service
public class HDDServiceImpl implements HDDService {
    @Autowired
    HDDRepository repository;

    @Override
    public HDD add(HDD motherboard) {
        return repository.save(motherboard);
    }

    @Override
    public HDD update(HDD motherboard) {
        return repository.save(motherboard);
    }

    @Override
    public HDD getById(Long motherboardId) {
        return repository.findOne(motherboardId);
    }

    @Override
    public List<HDD> getAll() {
        List<HDD> result = new ArrayList<>();

        Iterable<HDD> motherboardIterable = repository.findAll();
        for (HDD motherboard: motherboardIterable)
        {
            result.add(motherboard);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<HDD> allHDD = repository.findAll();

        for (HDD record: allHDD)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public List<HDD> getAllActive() {
        List<HDD> result = new ArrayList<>();

        Iterable<HDD> hddIterable = repository.findAll();
        for (HDD hdd: hddIterable)
        {
            if(hdd.getActiveStock().intValue() == 1)
                result.add(hdd);
        }
        return result;
    }

    @Override
    public void delete(HDD mobo) {
        repository.delete(mobo);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
