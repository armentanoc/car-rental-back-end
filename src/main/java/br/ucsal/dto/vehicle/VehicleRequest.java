package br.ucsal.dto.vehicle;

import java.math.BigDecimal;

import br.ucsal.domain.enums.Status;
import br.ucsal.domain.vehicle.Category;
import br.ucsal.domain.vehicle.FuelType;

public record VehicleRequest(
    String model, 
    String brand, 
    String color, 
    int year, 
    String licensePlate,
    String chassiNumber, 
    FuelType fuelType, 
    Integer mileage, 
    String additionalFeatures, 
    Status status, 
    Category category, 
    BigDecimal dailyRate) {
}
