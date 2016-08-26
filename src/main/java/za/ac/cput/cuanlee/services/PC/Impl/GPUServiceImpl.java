package za.ac.cput.cuanlee.services.PC.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.cuanlee.domain.PC.GPU;
import za.ac.cput.cuanlee.repository.PC.GPURepository;
import za.ac.cput.cuanlee.services.PC.GPUService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuan on 2016/08/15.
 */
@Service
public class GPUServiceImpl implements GPUService {

    @Autowired
    GPURepository repository;

    @Override
    public GPU add(GPU gpu) {
        return repository.save(gpu);
    }

    @Override
    public GPU update(GPU gpu) {
        return repository.save(gpu);
    }

    @Override
    public GPU getById(Long gpuId) {
        return repository.findOne(gpuId);
    }

    @Override
    public List<GPU> getAll() {
        List<GPU> result = new ArrayList<>();

        Iterable<GPU> gpuIterable = repository.findAll();
        for (GPU gpu: gpuIterable)
        {
            result.add(gpu);
        }
        return result;
    }

    @Override
    public int getTotalStock() {
        int totalStock = 0;
        Iterable<GPU> allGpu = repository.findAll();

        for (GPU record: allGpu)
        {
            totalStock = totalStock + record.getStock();
        }

        return totalStock;
    }

    @Override
    public List<GPU> getAllActive() {
        List<GPU> result = new ArrayList<>();

        Iterable<GPU> gpuIterable = repository.findAll();
        for (GPU gpu: gpuIterable)
        {
            if(gpu.getActiveStock().intValue() == 1)
                result.add(gpu);
        }
        return result;
    }

    @Override
    public void delete(GPU gpu) {
        repository.delete(gpu);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
