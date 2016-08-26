package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.HDD;
import za.ac.cput.cuanlee.services.PC.HDDService;

import java.util.List;

/**
 * Created by Cuan on 2016/08/14.
 */
@RestController
public class HDDController {

    @Autowired
    private HDDService hddService;

    //-------------------Create a HDD--------------------------------------------------------
    @RequestMapping(value = "/hdd/", method = RequestMethod.POST)
    public ResponseEntity<Void> createMobo(@RequestBody HDD hdd, UriComponentsBuilder ucBuilder) {
        hddService.add(hdd);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hdd/{id}").buildAndExpand(hdd.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single HDD--------------------------------------------------------
    @RequestMapping(value = "/hdd/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HDD> getMobo(@PathVariable("id") long id) {
        HDD hdd = hddService.getById(id);
        if (hdd == null) {
            return new ResponseEntity<HDD>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<HDD>(hdd, HttpStatus.OK);
    }

    //-------------------Retrieve All HDD--------------------------------------------------------
    @RequestMapping(value = "/hdd/", method = RequestMethod.GET)
    public ResponseEntity<List<HDD>> getAllMobo() {
        List<HDD> hddList = hddService.getAll();
        if(hddList.isEmpty()){
            return new ResponseEntity<List<HDD>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<HDD>>(hddList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active HDD--------------------------------------------------------
    @RequestMapping(value = "/hdd/active/", method = RequestMethod.GET)
    public ResponseEntity<List<HDD>> getAllActiveMobo() {
        List<HDD> hddList = hddService.getAllActive();
        if(hddList.isEmpty()){
            return new ResponseEntity<List<HDD>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<HDD>>(hddList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active HDD--------------------------------------------------------
    @RequestMapping(value = "/hdd/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = hddService.getTotalStock();
        if(totalStock < 1)
        {
            return 0;
        }
        return totalStock;
    }

    //------------------- Update a HDD --------------------------------------------------------
    @RequestMapping(value = "/hdd/{id}", method = RequestMethod.PUT)
    public ResponseEntity<HDD> updateMobo(@PathVariable("id") long id, @RequestBody HDD hdd) {

        HDD currentHdd = hddService.getById(id);

        if (currentHdd == null) {
            return new ResponseEntity<HDD>(HttpStatus.NOT_FOUND);
        }
        HDD updatedHDD = new HDD.Builder().copy(currentHdd)
                .code(hdd.getCode())
                .description(hdd.getDescription())
                .size_MB(hdd.getSize_MB())
                .rpm(hdd.getRpm())
                .sata(hdd.getSata())
                .stock(hdd.getStock())
                .activeStock(hdd.getActiveStock())
                .build();
        hddService.update(updatedHDD);
        return new ResponseEntity<HDD>(updatedHDD, HttpStatus.OK);
    }

    //------------------- Delete a HDD --------------------------------------------------------
    @RequestMapping(value = "/hdd/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HDD> deleteMobo(@PathVariable("id") long id) {
        HDD hdd = hddService.getById(id);
        if (hdd == null) {
            return new ResponseEntity<HDD>(HttpStatus.NOT_FOUND);
        }
        hddService.delete(hdd);
        return new ResponseEntity<HDD>(HttpStatus.NO_CONTENT);
    }
}
