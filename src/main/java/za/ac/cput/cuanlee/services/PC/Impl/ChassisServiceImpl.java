package za.ac.cput.cuanlee.services.PC.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.domain.PC.Chassis;
import za.ac.cput.cuanlee.repository.PC.ChassisRepository;
import za.ac.cput.cuanlee.services.PC.ChassisService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuanL on 21/08/2016.
 */
@Service
public class ChassisServiceImpl implements ChassisService {

    @Autowired
    ChassisRepository repository;

    @Override
    public Chassis add(Chassis entity) {
        return repository.save(entity);
    }

    @Override
    public Chassis update(Chassis entity) {
        return repository.save(entity);
    }

    @Override
    public Chassis getById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Chassis> getAll() {
        List<Chassis> result = new ArrayList<>();

        Iterable<Chassis> chassisIterable = repository.findAll();
        for (Chassis chassis: chassisIterable)
        {
            result.add(chassis);
        }
        return result;
    }

    @Override
    public List<Chassis> getAllActive() {
        List<Chassis> result = new ArrayList<>();

        Iterable<Chassis> chassisIterable = repository.findAll();
        for (Chassis chassis: chassisIterable)
        {
            if(chassis.getActiveStock().intValue() == 1)
                result.add(chassis);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<Chassis> allChassis = repository.findAll();

        for (Chassis record: allChassis)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public void delete(Chassis entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
