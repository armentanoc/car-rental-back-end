package br.ucsal.dto.rental;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalResponse(Long id, Long vehicleId, Long clientId, LocalDateTime startDate, LocalDateTime endDate,
                             Integer initialMileage, Integer finalMileage, BigDecimal initialFuelLevel,
                             BigDecimal finalFuelLevel, BigDecimal totalAmount, String status) {
}
