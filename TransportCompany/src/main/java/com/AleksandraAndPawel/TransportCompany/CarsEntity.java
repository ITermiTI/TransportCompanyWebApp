package com.AleksandraAndPawel.TransportCompany;

import java.math.BigDecimal;

public class CarsEntity {
    private int carId;
    private String carRegNumber;
    private BigDecimal carryingCapacity;
    private Object carType;
    private Object carStatus;
    private Integer driverId;
    private DriversEntity driversByDriverId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    public BigDecimal getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(BigDecimal carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public Object getCarType() {
        return carType;
    }

    public void setCarType(Object carType) {
        this.carType = carType;
    }

    public Object getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Object carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarsEntity that = (CarsEntity) o;

        if (carId != that.carId) return false;
        if (carRegNumber != null ? !carRegNumber.equals(that.carRegNumber) : that.carRegNumber != null) return false;
        if (carryingCapacity != null ? !carryingCapacity.equals(that.carryingCapacity) : that.carryingCapacity != null)
            return false;
        if (carType != null ? !carType.equals(that.carType) : that.carType != null) return false;
        if (carStatus != null ? !carStatus.equals(that.carStatus) : that.carStatus != null) return false;
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (carRegNumber != null ? carRegNumber.hashCode() : 0);
        result = 31 * result + (carryingCapacity != null ? carryingCapacity.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (carStatus != null ? carStatus.hashCode() : 0);
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        return result;
    }

    public DriversEntity getDriversByDriverId() {
        return driversByDriverId;
    }

    public void setDriversByDriverId(DriversEntity driversByDriverId) {
        this.driversByDriverId = driversByDriverId;
    }
}
