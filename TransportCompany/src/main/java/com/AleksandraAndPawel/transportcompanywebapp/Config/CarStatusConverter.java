package com.AleksandraAndPawel.transportcompanywebapp.Config;

import com.AleksandraAndPawel.transportcompanywebapp.Models.CarStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
    public class CarStatusConverter implements AttributeConverter<CarStatus, String> {

        @Override
        public String convertToDatabaseColumn(CarStatus attribute) {
            if (attribute == null)
                return null;

            return attribute.getStatus();
        }

        @Override
        public CarStatus convertToEntityAttribute(String dbData) {
            if (dbData == null)
                return null;

            switch (dbData) {
                case "Oczekuje na przydzielenie":
                    return CarStatus.OCZEKUJE_NA_PRYDZIELENIE;

                case "Przydzielono transport":
                    return CarStatus.PRZYDZIELONO_TRANSPORT;

                default:
                    throw new IllegalArgumentException(dbData + " not supported.");
            }
        }

    }

