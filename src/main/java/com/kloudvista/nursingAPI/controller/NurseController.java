package com.kloudvista.nursingAPI.controller;

import com.kloudvista.nursingAPI.dto.NewNurseResp;
import com.kloudvista.nursingAPI.dto.NurseReq;
import com.kloudvista.nursingAPI.dto.NurseResp;
import com.kloudvista.nursingAPI.service.NurseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/nurse")
public class NurseController {
    @Autowired
    private NurseServiceImpl nurseService;

    @PostMapping(value = "/saveNurse")
    public ResponseEntity<NewNurseResp> createProduct(@RequestBody NurseReq dto) {
        NewNurseResp nurse = nurseService.createNurse(dto);
        return new ResponseEntity<>(nurse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get-nurses", method = RequestMethod.GET)
    //@GetMapping(value = "/get-nurses")
    public ResponseEntity<List<NurseResp>> getNurses(){
        List<NurseResp> nurses = nurseService.getNurses();
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    @GetMapping(value = "/get-nurse/{id}")
    public ResponseEntity<NurseResp> getNurse(@PathVariable int id){
        NurseResp nurses = nurseService.getNurseById(id);
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    @GetMapping(value = "/get-nurse/{id}/{firstname}")
    public ResponseEntity<NurseResp> getNurseByIdAndFirstname(@PathVariable int id, @PathVariable String firstname){
        NurseResp nurses = nurseService.getNurseByIdAndFirstname(id,firstname);
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-nurses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateNurseById(@PathVariable int id, @RequestBody NurseReq nurseReq){
        int d = nurseService.updateNurse(nurseReq, id);
        return new ResponseEntity<>(Integer.valueOf(d), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-nurses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteNurseById(@PathVariable int id){
        int d = nurseService.deleteNurse(id);
        return new ResponseEntity<>(Integer.valueOf(d), HttpStatus.OK);
    }

}
