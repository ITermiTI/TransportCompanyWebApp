package com.AleksandraAndPawel.transportcompanywebapp.Config;

import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
public class TransportStatusConverter implements AttributeConverter<TransportStatus, String>{

        @Override
        public String convertToDatabaseColumn(TransportStatus attribute) {
            if (attribute == null)
                return null;

            return attribute.getStatus();
        }

        @Override
        public TransportStatus convertToEntityAttribute(String dbData) {
            if (dbData == null)
                return null;

            switch (dbData) {
                case "W trasie":
                    return TransportStatus.WTRASIE;

                case "Zakonczone":
                    return TransportStatus.ZAKONCZONE;

                case "Oczekuje":
                    return TransportStatus.OCZEKUJE;

                default:
                    throw new IllegalArgumentException(dbData + " not supported.");
            }
        }
}
