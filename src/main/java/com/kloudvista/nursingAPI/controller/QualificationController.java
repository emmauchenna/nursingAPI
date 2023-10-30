package com.kloudvista.nursingAPI.controller;

import com.kloudvista.nursingAPI.domain.Qualification;
import com.kloudvista.nursingAPI.dto.NewNurseResp;
import com.kloudvista.nursingAPI.service.QualificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qualification")
public class QualificationController {
    @Autowired
    private QualificationServiceImpl service;

    @GetMapping("/get-all/{nurseId}")
    public ResponseEntity<List<Qualification>> getAllQualification(@PathVariable int nurseId){
        List<Qualification> allById = service.getAllById(nurseId);
        return new ResponseEntity<>(allById, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Qualification> getQualification(@PathVariable int id){
        Qualification allById = service.getById(id);
        return new ResponseEntity<>(allById, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<NewNurseResp> saveQualification(@RequestBody Qualification nextOfKin){
        NewNurseResp resp = service.saveQualification(nextOfKin);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }
}
