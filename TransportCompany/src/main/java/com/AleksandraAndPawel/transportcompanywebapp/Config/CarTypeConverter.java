package com.AleksandraAndPawel.transportcompanywebapp.Config;

import com.AleksandraAndPawel.transportcompanywebapp.Models.CarStatus;
import com.AleksandraAndPawel.transportcompanywebapp.Models.CarType;

import javax.persistence.AttributeConverter;

public class CarTypeConverter implements AttributeConverter<CarType, String> {

    @Override
    public String convertToDatabaseColumn(CarType attribute) {
        if (attribute == null)
            return null;

        return attribute.getType();
    }

    @Override
    public CarType convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "Kruche":
                return CarType.KRUCHE;

            case "Niebezpieczne":
                return CarType.NIEBEZPIECZNE;
            case "Normalne":
                return CarType.NORMALNE;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }

}
