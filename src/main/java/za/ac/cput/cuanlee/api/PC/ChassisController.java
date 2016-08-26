package za.ac.cput.cuanlee.api.PC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.cuanlee.domain.PC.CPU;
import za.ac.cput.cuanlee.domain.PC.Chassis;
import za.ac.cput.cuanlee.services.PC.CPUService;
import za.ac.cput.cuanlee.services.PC.ChassisService;

import java.util.List;

/**
 * Created by Cuan on 2016/08/14.
 */
@RestController
public class ChassisController {

    @Autowired
    private ChassisService chassisService;

    //-------------------Create a Chassis--------------------------------------------------------
    @RequestMapping(value = "/chassis/", method = RequestMethod.POST)
    public ResponseEntity<Void> createChassis(@RequestBody Chassis chassis, UriComponentsBuilder ucBuilder) {
        chassisService.add(chassis);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/chassis/{id}").buildAndExpand(chassis.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Chassis--------------------------------------------------------
    @RequestMapping(value = "/chassis/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chassis> getChassis(@PathVariable("id") long id) {
        Chassis chassis = chassisService.getById(id);
        if (chassis == null) {
            return new ResponseEntity<Chassis>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Chassis>(chassis, HttpStatus.OK);
    }

    //-------------------Retrieve All Chassis--------------------------------------------------------
    @RequestMapping(value = "/chassis/", method = RequestMethod.GET)
    public ResponseEntity<List<Chassis>> getAllChassis() {
        List<Chassis> chassisList = chassisService.getAll();
        if(chassisList.isEmpty()){
            return new ResponseEntity<List<Chassis>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Chassis>>(chassisList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active Chassis--------------------------------------------------------
    @RequestMapping(value = "/chassis/active/", method = RequestMethod.GET)
    public ResponseEntity<List<Chassis>> getAllActiveChassis() {
        List<Chassis> chassisList = chassisService.getAllActive();
        if(chassisList.isEmpty()){
            return new ResponseEntity<List<Chassis>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Chassis>>(chassisList, HttpStatus.OK);
    }

    //-------------------Retrieve All Active Chassis--------------------------------------------------------
    @RequestMapping(value = "/chassis/totalStock/", method = RequestMethod.GET)
    public int getTotalStock() {
        int totalStock = chassisService.getTotalStock();
        if(totalStock < 1)
        {
            return 0;
        }
        return totalStock;
    }

    //------------------- Update a Chassis --------------------------------------------------------
    @RequestMapping(value = "/chassis/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Chassis> updateChassis(@PathVariable("id") long id, @RequestBody Chassis chassis) {

        Chassis currentChassis = chassisService.getById(id);

        if (currentChassis == null) {
            return new ResponseEntity<Chassis>(HttpStatus.NOT_FOUND);
        }
        Chassis updatedChassis = new Chassis.Builder().copy(currentChassis)
                .code(chassis.getCode())
                .description(chassis.getDescription())
                .hddBays(chassis.getHddBays())
                .caseFans(chassis.getCaseFans())
                .formFactor(chassis.getFormFactor())
                .stock(chassis.getStock())
                .activeStock(chassis.getActiveStock())
                .build();
        chassisService.update(updatedChassis);
        return new ResponseEntity<Chassis>(updatedChassis, HttpStatus.OK);
    }

    //------------------- Delete a Chassis --------------------------------------------------------
    @RequestMapping(value = "/chassis/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Chassis> deleteChassis(@PathVariable("id") long id) {
        Chassis chassis = chassisService.getById(id);
        if (chassis == null) {
            return new ResponseEntity<Chassis>(HttpStatus.NOT_FOUND);
        }
        chassisService.delete(chassis);
        return new ResponseEntity<Chassis>(HttpStatus.NO_CONTENT);
    }
}
