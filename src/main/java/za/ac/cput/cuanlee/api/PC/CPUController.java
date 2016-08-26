package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.services.PC.CPUService;

import java.util.List;

/**
 * Created by Cuan on 2016/08/14.
 */
@RestController
public class CPUController {

    @Autowired
    private CPUService cpuService;

    //-------------------Create a CPU--------------------------------------------------------
    @RequestMapping(value = "/cpu/", method = RequestMethod.POST)
    public ResponseEntity<Void> createMobo(@RequestBody CPU cpu, UriComponentsBuilder ucBuilder) {
        cpuService.add(cpu);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cpu/{id}").buildAndExpand(cpu.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single CPU--------------------------------------------------------
    @RequestMapping(value = "/cpu/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CPU> getCPU(@PathVariable("id") long id) {
        CPU cpu = cpuService.getById(id);
        if (cpu == null) {
            return new ResponseEntity<CPU>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CPU>(cpu, HttpStatus.OK);
    }

    //-------------------Retrieve All CPU--------------------------------------------------------
    @RequestMapping(value = "/cpu/", method = RequestMethod.GET)
    public ResponseEntity<List<CPU>> getAllCPU() {
        List<CPU> cpuList = cpuService.getAll();
        if(cpuList.isEmpty()){
            return new ResponseEntity<List<CPU>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CPU>>(cpuList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active CPU--------------------------------------------------------
    @RequestMapping(value = "/cpu/active/", method = RequestMethod.GET)
    public ResponseEntity<List<CPU>> getAllActiveCPU() {
        List<CPU> cpuList = cpuService.getAllActive();
        if(cpuList.isEmpty()){
            return new ResponseEntity<List<CPU>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CPU>>(cpuList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active CPU--------------------------------------------------------
    @RequestMapping(value = "/cpu/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = cpuService.getTotalStock();
        if(totalStock < 1)
        {
            return 0;
        }
        return totalStock;
    }

    //------------------- Update a CPU --------------------------------------------------------
    @RequestMapping(value = "/cpu/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CPU> updateCPU(@PathVariable("id") long id, @RequestBody CPU cpu) {

        CPU currentCpu = cpuService.getById(id);

        if (currentCpu == null) {
            return new ResponseEntity<CPU>(HttpStatus.NOT_FOUND);
        }
        CPU updatedCPU = new CPU.Builder().copy(currentCpu)
                .code(cpu.getCode())
                .description(cpu.getDescription())
                .socket(cpu.getSocket())
                .processorBrand(cpu.getProcessorBrand())
                .speed_Ghz(cpu.getSpeed_Ghz())
                .cache_MB(cpu.getCache_MB())
                .cores(cpu.getCores())
                .stock(cpu.getStock())
                .activeStock(cpu.getActiveStock())
                .build();
        cpuService.update(updatedCPU);
        return new ResponseEntity<CPU>(updatedCPU, HttpStatus.OK);
    }

    //------------------- Delete a CPU --------------------------------------------------------
    @RequestMapping(value = "/cpu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CPU> deleteCPU(@PathVariable("id") long id) {
        CPU cpu = cpuService.getById(id);
        if (cpu == null) {
            return new ResponseEntity<CPU>(HttpStatus.NOT_FOUND);
        }
        cpuService.delete(cpu);
        return new ResponseEntity<CPU>(HttpStatus.NO_CONTENT);
    }
}
