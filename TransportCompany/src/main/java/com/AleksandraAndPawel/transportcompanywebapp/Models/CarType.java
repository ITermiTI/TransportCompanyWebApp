package com.AleksandraAndPawel.transportcompanywebapp.Models;

public enum CarType {
    KRUCHE("Kruche"),
    NORMALNE("Normalne"),
    NIEBEZPIECZNE("Niebezpieczne");

    private String type;

    CarType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
