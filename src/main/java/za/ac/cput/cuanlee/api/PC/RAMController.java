package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.RAM;
import za.ac.cput.cuanlee.services.PC.RAMService;
import za.ac.cput.cuanlee.services.Service;

import java.util.List;

/**
 * Created by CuanL on 10/08/2016.
 */
@RestController
public class RAMController {
    @Autowired
    private RAMService service;

    //-------------------Create a RAM--------------------------------------------------------
    @RequestMapping(value = "/ram/", method = RequestMethod.POST)
    public ResponseEntity<Void> createRam(@RequestBody RAM ram, UriComponentsBuilder ucBuilder) {
        service.add(ram);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ram/{id}").buildAndExpand(ram.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single RAM--------------------------------------------------------
    @RequestMapping(value = "/ram/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RAM> getRAM(@PathVariable("id") long id) {
        RAM ram = service.getById(id);
        if (ram == null) {
            return new ResponseEntity<RAM>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RAM>(ram, HttpStatus.OK);
    }

    //-------------------Retrieve All RAM--------------------------------------------------------
    @RequestMapping(value = "/ram/", method = RequestMethod.GET)
    public ResponseEntity<List<RAM>> getAllRAM() {
        List<RAM> ramSet = service.getAll();
        if(ramSet.isEmpty()){
            return new ResponseEntity<List<RAM>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RAM>>(ramSet, HttpStatus.OK);
    }

    //-------------------Retrieve All Active RAM--------------------------------------------------------
    @RequestMapping(value = "/ram/active/", method = RequestMethod.GET)
    public ResponseEntity<List<RAM>> getAllActiveRAM() {
        List<RAM> ramSet = service.getAllActive();
        if(ramSet.isEmpty()){
            return new ResponseEntity<List<RAM>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RAM>>(ramSet, HttpStatus.OK);
    }

    //-------------------Retrieve TotalStock--------------------------------------------------------
    @RequestMapping(value = "/ram/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = service.getTotalStock();
        if(totalStock < 1)
        {
            return 0;
        }
        return totalStock;
    }

    //------------------- Update a RAM --------------------------------------------------------
    @RequestMapping(value = "/ram/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RAM> updateRAM(@PathVariable("id") long id, @RequestBody RAM ram) {

        RAM currentRAM = service.getById(id);

        if (currentRAM==null) {
            return new ResponseEntity<RAM>(HttpStatus.NOT_FOUND);
        }
        RAM updatedRAM = new RAM.Builder().copy(currentRAM)
                .code(ram.getCode())
                .description(ram.getDescription())
                .memorySize(ram.getMemorySize())
                .voltage(ram.getVoltage())
                .memoryConfiguration(ram.getMemoryConfiguration())
                .stock(ram.getStock())
                .activeStock(ram.getActiveStock())
                .build();
        service.update(updatedRAM);
        return new ResponseEntity<RAM>(updatedRAM, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/ram/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RAM> deleteRAM(@PathVariable("id") long id, @RequestBody RAM ramPar) {
        RAM ram = service.getById(id);
        if (ram == null) {
            return new ResponseEntity<RAM>(HttpStatus.NOT_FOUND);
        }
        service.delete(ram);
        return new ResponseEntity<RAM>(HttpStatus.OK);
    }
}
