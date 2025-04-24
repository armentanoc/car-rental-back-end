package br.ucsal.dto.vehicle;

public record VehicleRequest(String model, String brand, String plate, String color, int year, Long clientId) {
}
