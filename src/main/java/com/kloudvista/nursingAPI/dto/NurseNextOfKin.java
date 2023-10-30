package com.kloudvista.nursingAPI.dto;

import com.kloudvista.nursingAPI.domain.NextOfKin;

import java.util.List;

public class NurseNextOfKin {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    List<NextOfKin> nextOfKinList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<NextOfKin> getNextOfKinList() {
        return nextOfKinList;
    }

    public void setNextOfKinList(List<NextOfKin> nextOfKinList) {
        this.nextOfKinList = nextOfKinList;
    }
}
