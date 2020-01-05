package com.AleksandraAndPawel.transportcompanywebapp.Config;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackageStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public class PackageStatusConverter implements AttributeConverter<PackageStatus, String> {

    @Override
    public String convertToDatabaseColumn(PackageStatus attribute) {
        if (attribute == null)
            return null;

        return attribute.getStatus();
    }

    @Override
    public PackageStatus convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "Dostarczone":
                return PackageStatus.DOSTARCZONE;

            case "Odebrane":
                return PackageStatus.ODEBRANE;

            case "Nieodebrane":
                return PackageStatus.NIEODEBRANE;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}
