package com.kloudvista.nursingAPI.controller;

import com.kloudvista.nursingAPI.domain.NextOfKin;
import com.kloudvista.nursingAPI.dto.NewNextOfKin;
import com.kloudvista.nursingAPI.service.NextOfKinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nextofkin")
public class NextOfKinController {
    @Autowired
    private NextOfKinService nextOfKinService;

    @GetMapping("/get-all/{nurseId}")
    public ResponseEntity<List<NextOfKin>> getAllNextOfKin(@PathVariable int nurseId){
        List<NextOfKin> allById = nextOfKinService.getAllById(nurseId);

        return new ResponseEntity<>(allById, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NextOfKin> getNextOfKin(@PathVariable int id){
        NextOfKin allById = nextOfKinService.getById(id);
        return new ResponseEntity<>(allById, HttpStatus.OK);
    }

    //@PostMapping("/save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveNextOfKin(@RequestBody NewNextOfKin nextOfKin){
        int i = nextOfKinService.saveNextOfKin(nextOfKin);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }
/**
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateNextOfKin2(@RequestBody NewNextOfKin nextOfKin, @PathVariable int id){
        int i = nextOfKinService.updateNextOfKin(nextOfKin, id);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }
**/
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateNextOfKin(@RequestBody NewNextOfKin nextOfKin, @PathVariable int id){
        int i = nextOfKinService.updateNextOfKin(nextOfKin, id);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

}
