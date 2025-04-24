package br.ucsal.dto.vehicle;

public record VehicleResponse(Long vehicleId, String model, String brand, String plate, String color, int year, Long clientId) {
}
