package com.kloudvista.nursingAPI.service;

import com.kloudvista.nursingAPI.domain.Nurse;
import com.kloudvista.nursingAPI.dto.NewNurseResp;
import com.kloudvista.nursingAPI.dto.NurseReq;
import com.kloudvista.nursingAPI.dto.NurseResp;
import com.kloudvista.nursingAPI.repository.NurseRepo2Impl;
import com.kloudvista.nursingAPI.repository.NurseRepoImpl;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NurseServiceImpl implements NurseService{

    @Autowired
    private NurseRepoImpl nurseRepo;

    @Override
    public NewNurseResp createNurse(NurseReq nurseDto) {
        //validation
        if(nurseDto.getPhoneNumber().length() < 11 ||  nurseDto.getPhoneNumber().length() > 11)
            return new NewNurseResp("01","Please enter your 11 digit phone number");

        if(nurseDto.getFirstName().length() < 2 ||  nurseDto.getLastName().length() < 2)
            return new NewNurseResp("01","Length of name must be greater two");
        if(!validateEmail(nurseDto.getEmail())) {
            return new NewNurseResp("02", "Email not correct, please enter a correct email");
        }
        if(nurseRepo.findByEmail(nurseDto.getEmail()) > 0)
        return new NewNurseResp("01", "Email already exist");

        Nurse nurse = new Nurse();
        try {
            nurse.setFirstName(nurseDto.getFirstName());
            nurse.setLastName(nurseDto.getLastName());
            nurse.setAddress(nurseDto.getAddress());
            nurse.setPhoneNumber(nurseDto.getPhoneNumber());
            nurse.setEmail(nurseDto.getEmail());
            nurse.setStatus(false);
            nurse.setDateCreated(LocalDateTime.now());

        }catch (Exception exception){
            System.out.println("Error occurred: "+ exception.getMessage());
            return new NewNurseResp("er", "An Error occurred");
        }
       int no = nurseRepo.saveNurse(nurse);
      return new NewNurseResp("00", "Number of item inserted: "+no);
    }

    @Override
    public List<NurseResp> getNurses() {
        List<Nurse> nurses = nurseRepo.getNurses();
      return   getNurseReponse(nurses);
    }

    @Override
    public NurseResp getNurseById(int id) {
        Nurse nurseById = nurseRepo.getNurseById(id);
       return getNurseReponse(nurseById);
    }

    @Override
    public NurseResp getNurseByIdAndFirstname(int id, String firstname) {
        Nurse nurse = nurseRepo.getNurseByIdAndFirstname(id, firstname);
        return getNurseReponse(nurse);
    }

    @Override
    public int updateNurse(NurseReq nurseReq, int id) {
        Nurse nurse1 = new Nurse();
        nurse1.setLastName(nurseReq.getLastName());
        nurse1.setFirstName(nurseReq.getFirstName());
        nurse1.setId(id);
        return nurseRepo.updateNurse(nurse1);
    }

    @Override
    public int deleteNurse(int id) {
        return nurseRepo.deleteNurse(id);
    }


    @Override
    public boolean validateEmail(String email) {
        boolean isMail = false;
        String EMAIL_REGEX =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private NurseResp getNurseReponse(Nurse nurses){
        NurseResp x = new NurseResp();
        x.setAddress(nurses.getAddress());
        x.setFirstName(nurses.getFirstName());
        x.setLastName(nurses.getLastName());
        x.setEmail(nurses.getEmail());
        x.setPhoneNumber(nurses.getPhoneNumber());
        x.setId(nurses.getId());
     return x;
    }

    private List<NurseResp> getNurseReponse(List<Nurse> nurses){
        List<NurseResp>  resps = new ArrayList<>();
        for (Nurse eachEach: nurses) {
            NurseResp x = new NurseResp();
            x.setAddress(eachEach.getAddress());
            x.setFirstName(eachEach.getFirstName());
            x.setLastName(eachEach.getLastName());
            x.setEmail(eachEach.getEmail());
            x.setPhoneNumber(eachEach.getPhoneNumber());
            x.setId(eachEach.getId());
            resps.add(x);
        }
        return resps;
    }
}

