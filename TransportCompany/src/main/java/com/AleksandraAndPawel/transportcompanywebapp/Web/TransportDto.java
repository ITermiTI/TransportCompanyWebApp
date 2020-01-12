package com.AleksandraAndPawel.transportcompanywebapp.Web;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportStatus;

public class TransportDto {


    private Integer transportId;
    private TransportStatus transportStatus;
    private String transportCity;
    private Integer driversId;
    private String transportFrom;
    private int numberOfPackages;

    public TransportDto()
    {

    }

    public TransportDto(Integer transportId, TransportStatus transportStatus, String transportCity, Integer driversId, String transportFrom, int numberOfPackages) {
        this.transportId = transportId;
        this.transportStatus = transportStatus;
        this.transportCity = transportCity;
        this.driversId = driversId;
        this.transportFrom = transportFrom;
        this.numberOfPackages = numberOfPackages;
    }

    public TransportStatus getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(TransportStatus transportStatus) {
        this.transportStatus = transportStatus;
    }

    public String getTransportCity() {
        return transportCity;
    }

    public void setTransportCity(String transportCity) {
        this.transportCity = transportCity;
    }

    public Integer getDriversId() {
        return driversId;
    }

    public void setDriversId(Integer driversId) {
        this.driversId = driversId;
    }

    public String getTransportFrom() {
        return transportFrom;
    }

    public void setTransportFrom(String transportFrom) {
        this.transportFrom = transportFrom;
    }

    public int getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(int numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }
    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }
}
