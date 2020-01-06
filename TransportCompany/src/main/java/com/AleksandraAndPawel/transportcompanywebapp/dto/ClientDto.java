package com.AleksandraAndPawel.transportcompanywebapp.dto;

public class ClientDto {

    private String address;
    private String phoneNumber;

    public ClientDto() {
    }

    public ClientDto(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
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
}
