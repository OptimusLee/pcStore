package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.GPU;
import za.ac.cput.cuanlee.domain.PC.HDD;
import za.ac.cput.cuanlee.services.PC.GPUService;
import za.ac.cput.cuanlee.services.PC.HDDService;

import java.util.List;

/**
 * Created by Cuan on 2016/08/14.
 */
@RestController
public class GPUController {
    @Autowired
    private GPUService gpuService;

    //-------------------Create a GPU--------------------------------------------------------
    @RequestMapping(value = "/gpu/", method = RequestMethod.POST)
    public ResponseEntity<Void> createMobo(@RequestBody GPU gpu, UriComponentsBuilder ucBuilder) {
        gpuService.add(gpu);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/gpu/{id}").buildAndExpand(gpu.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single GPU--------------------------------------------------------
    @RequestMapping(value = "/gpu/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GPU> getMobo(@PathVariable("id") long id) {
        GPU gpu = gpuService.getById(id);
        if (gpu == null) {
            return new ResponseEntity<GPU>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<GPU>(gpu, HttpStatus.OK);
    }

    //-------------------Retrieve All GPU--------------------------------------------------------
    @RequestMapping(value = "/gpu/", method = RequestMethod.GET)
    public ResponseEntity<List<GPU>> getAllGPU() {
        List<GPU> gpuList = gpuService.getAll();
        if(gpuList.isEmpty()){
            return new ResponseEntity<List<GPU>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<GPU>>(gpuList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active GPU--------------------------------------------------------
    @RequestMapping(value = "/gpu/active/", method = RequestMethod.GET)
    public ResponseEntity<List<GPU>> getAllActiveGPU() {
        List<GPU> gpuList = gpuService.getAllActive();
        if(gpuList.isEmpty()){
            return new ResponseEntity<List<GPU>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<GPU>>(gpuList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active GPU--------------------------------------------------------
    @RequestMapping(value = "/gpu/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = gpuService.getTotalStock();
        if(totalStock < 1)
        {
            return 0;
        }
        return totalStock;
    }

    //------------------- Update a GPU --------------------------------------------------------
    @RequestMapping(value = "/gpu/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GPU> updateMobo(@PathVariable("id") long id, @RequestBody GPU gpu) {

        GPU currentGpu = gpuService.getById(id);

        if (currentGpu == null) {
            return new ResponseEntity<GPU>(HttpStatus.NOT_FOUND);
        }
        GPU updatedHDD = new GPU.Builder().copy(currentGpu)
                .code(gpu.getCode())
                .description(gpu.getDescription())
                .bitMemory(gpu.getBitMemory())
                .memorySize_GB(gpu.getMemorySize_GB())
                .memoryClock_MHz(gpu.getMemoryClock_MHz())
                .memoryType(gpu.getMemoryType())
                .cardBus(gpu.getCardBus())
                .stock(gpu.getStock())
                .activeStock(gpu.getActiveStock())
                .build();
        gpuService.update(updatedHDD);
        return new ResponseEntity<GPU>(updatedHDD, HttpStatus.OK);
    }

    //------------------- Delete a GPU --------------------------------------------------------
    @RequestMapping(value = "/gpu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GPU> deleteMobo(@PathVariable("id") long id) {
        GPU gpu = gpuService.getById(id);
        if (gpu == null) {
            return new ResponseEntity<GPU>(HttpStatus.NOT_FOUND);
        }
        gpuService.delete(gpu);
        return new ResponseEntity<GPU>(HttpStatus.NO_CONTENT);
    }
}
