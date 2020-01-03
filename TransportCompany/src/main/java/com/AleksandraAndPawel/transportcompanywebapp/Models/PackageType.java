package com.AleksandraAndPawel.transportcompanywebapp.Models;

public enum PackageType {

    KRUCHE("Kruche"),
    NORMALNE("Normalne"),
    NIEBEZPIECZNE("Niebezpieczne");
    private String type;

    PackageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
