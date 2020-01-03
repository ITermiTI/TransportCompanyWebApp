package com.AleksandraAndPawel.transportcompanywebapp.Models;

public enum PackageStatus {

    DOSTARCZONE("Dostarczone"),
    ODEBRANE("Odebrane"),
    NIEODEBRANE("Nieodebrane");

    private String status;

    PackageStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
