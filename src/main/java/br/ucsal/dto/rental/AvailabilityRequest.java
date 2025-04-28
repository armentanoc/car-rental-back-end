package br.ucsal.dto.rental;

import java.time.LocalDateTime;
import java.util.Optional;

import br.ucsal.domain.vehicle.Category;
import br.ucsal.domain.vehicle.FuelType;

public record AvailabilityRequest(
    LocalDateTime startDate,
    LocalDateTime endDate,
    Optional<FuelType> fuelType,
    Optional<Integer> startYear,
    Optional<Integer> endYear,
    Optional<Category> category
) {}
