package br.ucsal.dto.image;

public record VehicleImageResponse(Long imageId, Long vehicleId, String url, String description, String message, boolean success) {
}
