package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.PSU;
import za.ac.cput.cuanlee.services.PC.PSUService;

import java.util.List;

/**
 * Created by CuanL on 11/08/2016.
 */
@RestController
public class PSUController {

    @Autowired
    private PSUService psuService;

    //-------------------Create a PSU--------------------------------------------------------
    @RequestMapping(value = "/psu/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPsu(@RequestBody PSU psu, UriComponentsBuilder ucBuilder) {
        psuService.add(psu);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/psu/{id}").buildAndExpand(psu.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single PSU--------------------------------------------------------
    @RequestMapping(value = "/psu/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PSU> getPSU(@PathVariable("id") long id) {
        PSU psu = psuService.getById(id);
        if (psu == null) {
            return new ResponseEntity<PSU>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PSU>(psu, HttpStatus.OK);
    }

    //-------------------Retrieve All PSU--------------------------------------------------------
    @RequestMapping(value = "/psu/", method = RequestMethod.GET)
    public ResponseEntity<List<PSU>> getAllPSU() {
        List<PSU> psuList = psuService.getAll();
        if(psuList.isEmpty()){
            return new ResponseEntity<List<PSU>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PSU>>(psuList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active PSU--------------------------------------------------------
    @RequestMapping(value = "/psu/active/", method = RequestMethod.GET)
    public ResponseEntity<List<PSU>> getAllActivePSU() {
        List<PSU> psuList = psuService.getAllActive();
        if(psuList.isEmpty()){
            return new ResponseEntity<List<PSU>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PSU>>(psuList, HttpStatus.OK);
    }

    //-------------------Retrieve TotalStock--------------------------------------------------------
    @RequestMapping(value = "/psu/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = psuService.getTotalStock();
        if(totalStock < 1)
        {
            return 0;
        }
        return totalStock;
    }

    //------------------- Update a PSU --------------------------------------------------------
    @RequestMapping(value = "/psu/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PSU> updatePSU(@PathVariable("id") long id, @RequestBody PSU psu) {

        PSU currentPSU = psuService.getById(id);

        if (currentPSU==null) {
            return new ResponseEntity<PSU>(HttpStatus.NOT_FOUND);
        }
        PSU updatedPSU = new PSU.Builder().copy(currentPSU)
                .code(psu.getCode())
                .description(psu.getDescription())
                .watts(psu.getWatts())
                .four_pin_molex(psu.getFour_pin_molex())
                .sata_connectors(psu.getSata_connectors())
                .floppy_connectors(psu.getFloppy_connectors())
                .stock(psu.getStock())
                .activeStock(psu.getActiveStock())
                .build();
        psuService.update(updatedPSU);
        return new ResponseEntity<PSU>(updatedPSU, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/psu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PSU> deletePSU(@PathVariable("id") long id) {
        PSU psu = psuService.getById(id);
        if (psu == null) {
            return new ResponseEntity<PSU>(HttpStatus.NOT_FOUND);
        }
        psuService.delete(psu);
        return new ResponseEntity<PSU>(HttpStatus.NO_CONTENT);
    }
}
