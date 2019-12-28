package com.aleksandraandpawel.transportcompanywebapp.Models;

public enum CarStatus {
    OCZEKUJE_NA_PRYDZIELENIE("Oczekuje na przydzielenie"),
    PRZYDZIELONO_TRANSPORT("Przydzielono transport");

    private String status;

    CarStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
