package com.AleksandraAndPawel.transportcompany.model;

public enum PackageType {

    KRUCHE("Kruche"),NORMALNE("Normalne"),NIEBEZPIECZNE("Niebezpieczne");
    private String type;

    PackageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
