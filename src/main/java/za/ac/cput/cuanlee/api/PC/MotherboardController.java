package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.Motherboard;
import za.ac.cput.cuanlee.services.PC.MotherboardService;

import java.util.List;

/**
 * Created by CuanL on 11/08/2016.
 */
@RestController
public class MotherboardController {

    @Autowired
    private MotherboardService motherboardService;

    //-------------------Create a Motherboard--------------------------------------------------------
    @RequestMapping(value = "/mobo/", method = RequestMethod.POST)
    public ResponseEntity<Void> createMobo(@RequestBody Motherboard mobo, UriComponentsBuilder ucBuilder) {
        motherboardService.add(mobo);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/mobo/{id}").buildAndExpand(mobo.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Motherboard--------------------------------------------------------
    @RequestMapping(value = "/mobo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Motherboard> getMobo(@PathVariable("id") long id) {
        Motherboard mobo = motherboardService.getById(id);
        if (mobo == null) {
            return new ResponseEntity<Motherboard>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Motherboard>(mobo, HttpStatus.OK);
    }

    //-------------------Retrieve All RAM--------------------------------------------------------
    @RequestMapping(value = "/mobo/", method = RequestMethod.GET)
    public ResponseEntity<List<Motherboard>> getAllMobo() {
        List<Motherboard> moboList = motherboardService.getAll();
        if(moboList.isEmpty()){
            return new ResponseEntity<List<Motherboard>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Motherboard>>(moboList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active RAM--------------------------------------------------------
    @RequestMapping(value = "/mobo/active/", method = RequestMethod.GET)
    public ResponseEntity<List<Motherboard>> getAllActiveMobo() {
        List<Motherboard> moboList = motherboardService.getAllActive();
        if(moboList.isEmpty()){
            return new ResponseEntity<List<Motherboard>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Motherboard>>(moboList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active RAM--------------------------------------------------------
    @RequestMapping(value = "/mobo/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = motherboardService.getTotalStock();
            if(totalStock < 1)
            {
                return 0;
            }
        return totalStock;
    }

    //------------------- Update a RAM --------------------------------------------------------
    @RequestMapping(value = "/mobo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Motherboard> updateMobo(@PathVariable("id") long id, @RequestBody Motherboard mobo) {

        Motherboard currentMobo = motherboardService.getById(id);

        if (currentMobo == null) {
            return new ResponseEntity<Motherboard>(HttpStatus.NOT_FOUND);
        }
        Motherboard updatedMobo = new Motherboard.Builder().copy(currentMobo)
                .code(mobo.getCode())
                .description(mobo.getDescription())
                .chipset(mobo.getChipset())
                .sataPorts(mobo.getSataPorts())
                .usb2(mobo.getUsb2())
                .usb3(mobo.getUsb3())
                .formFactor(mobo.getFormFactor())
                .stock(mobo.getStock())
                .activeStock(mobo.getActiveStock())
                .build();
        motherboardService.update(updatedMobo);
        return new ResponseEntity<Motherboard>(updatedMobo, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/mobo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Motherboard> deleteMobo(@PathVariable("id") long id) {
        Motherboard mobo = motherboardService.getById(id);
        if (mobo == null) {
            return new ResponseEntity<Motherboard>(HttpStatus.NOT_FOUND);
        }
        motherboardService.delete(mobo);
        return new ResponseEntity<Motherboard>(HttpStatus.NO_CONTENT);
    }
}
