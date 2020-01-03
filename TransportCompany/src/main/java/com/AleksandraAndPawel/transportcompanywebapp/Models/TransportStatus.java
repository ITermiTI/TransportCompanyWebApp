package com.AleksandraAndPawel.transportcompanywebapp.Models;

public enum TransportStatus {

    WTRASIE("W trasie"),
    ZAKONCZONE("Zakonczone"),
    OCZEKUJE("Oczekuje");
    private String status;

    TransportStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
