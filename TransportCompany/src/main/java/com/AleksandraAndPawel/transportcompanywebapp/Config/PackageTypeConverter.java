package com.AleksandraAndPawel.transportcompanywebapp.Config;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackageType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
public class PackageTypeConverter implements AttributeConverter<PackageType, String>{


        @Override
        public String convertToDatabaseColumn(PackageType attribute) {
            if (attribute == null)
                return null;

            return attribute.getType();
        }


        @Override
        public PackageType convertToEntityAttribute(String dbData) {
            if (dbData == null)
                return null;

            switch (dbData) {
                case "Kruche":
                    return PackageType.KRUCHE;

                case "Normalne":
                    return PackageType.NORMALNE;

                case "Nieodebrane":
                    return PackageType.NIEBEZPIECZNE;

                default:
                    throw new IllegalArgumentException(dbData + " not supported.");
            }
        }
}
