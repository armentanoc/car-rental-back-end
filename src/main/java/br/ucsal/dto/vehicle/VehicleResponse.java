package br.ucsal.dto.vehicle;

import br.ucsal.domain.enums.Status;
import br.ucsal.domain.vehicle.Category;
import br.ucsal.domain.vehicle.FuelType;

public record VehicleResponse(Long vehicleId, String model, String brand, String color, int year, String licensePlate,
String chassiNumber, FuelType fuelType, Integer mileage, String additionalFeatures, Status status, Category category) {
}
