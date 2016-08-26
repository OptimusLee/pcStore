package za.ac.cput.cuanlee.services.PC.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.Motherboard;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.repository.PC.MotherboardRepository;
import za.ac.cput.cuanlee.services.PC.MotherboardService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuanL on 11/08/2016.
 */
@Service
public class MotherboardServiceImpl implements MotherboardService {
    @Autowired
    MotherboardRepository repository;

    @Override
    public Motherboard add(Motherboard motherboard) {
        return repository.save(motherboard);
    }

    @Override
    public Motherboard update(Motherboard motherboard) {
        return repository.save(motherboard);
    }

    @Override
    public Motherboard getById(Long motherboardId) {
        return repository.findOne(motherboardId);
    }

    @Override
    public List<Motherboard> getAll() {
        List<Motherboard> result = new ArrayList<>();

        Iterable<Motherboard> motherboardIterable = repository.findAll();
        for (Motherboard motherboard: motherboardIterable)
        {
            result.add(motherboard);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<Motherboard> allMobo = repository.findAll();

        for (Motherboard record: allMobo)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public List<Motherboard> getAllActive() {
        List<Motherboard> result = new ArrayList<>();

        Iterable<Motherboard> motherboardIterable = repository.findAll();
        for (Motherboard motherboard: motherboardIterable)
        {
            if(motherboard.getActiveStock().intValue() == 1)
                result.add(motherboard);
        }
        return result;
    }

    @Override
    public void delete(Motherboard mobo) {
        repository.delete(mobo);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
