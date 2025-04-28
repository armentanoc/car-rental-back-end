package br.ucsal.service;

import br.ucsal.domain.rental.Rental;
import br.ucsal.domain.rental.Status;
import br.ucsal.domain.vehicle.Vehicle;
import br.ucsal.dto.rental.*;
import br.ucsal.dto.users.DeleteResponse;
import br.ucsal.infrastructure.IRentalRepository;
import br.ucsal.infrastructure.IVehicleRepository;
import br.ucsal.infrastructure.IClientRepository;
import br.ucsal.service.interfaces.IRentalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService implements IRentalService {

    @Autowired
    private IRentalRepository rentalRepository;

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public AddRentalResponse add(RentalRequest request) {
        var vehicle = vehicleRepository.findById(request.vehicleId()).orElse(null);
        var client = clientRepository.findById(request.clientId()).orElse(null);

        if (vehicle == null) {
            return new AddRentalResponse(false, "Veículo não encontrado.", null);
        }

        if (client == null) {
            return new AddRentalResponse(false, "Cliente não encontrado.", null);
        }

        var conflictingRentals = rentalRepository.findByVehicle(vehicle).stream()
                .filter(r -> (r.getStatus() == Status.RESERVED || r.getStatus() == Status.CONFIRMED)
                        && datesOverlap(r.getStartDate(), r.getEndDate(), request.startDate(), request.endDate()))
                .toList();

        if (!conflictingRentals.isEmpty()) {
            return new AddRentalResponse(false,
                    "Já existe um aluguel reservado ou confirmado para esse veículo nesse período.", null);
        }

        var rental = new Rental();
        rental.setVehicle(vehicle);
        rental.setClient(client);
        rental.setStartDate(request.startDate());
        rental.setEndDate(request.endDate());
        rental.setInitialMileage(request.initialMileage());
        rental.setFinalMileage(request.finalMileage());
        rental.setInitialFuelLevel(request.initialFuelLevel());
        rental.setFinalFuelLevel(request.finalFuelLevel());
        rental.setTotalAmount(request.totalAmount());
        rental.setStatus(Status.RESERVED);

        rentalRepository.save(rental);

        return new AddRentalResponse(true, "Aluguel reservado com sucesso.", rental.getId());
    }

    @Override
    public Optional<RentalResponse> get(Long id) {
        return rentalRepository.findById(id).map(this::mapToResponse);
    }

    @Override
    public List<RentalResponse> getAll() {
        return rentalRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DeleteResponse delete(Long id, br.ucsal.dto.rental.DeleteRequest request) {
        var optionalRental = rentalRepository.findById(id);

        if (optionalRental.isEmpty()) {
            return new DeleteResponse(false, "Aluguel não encontrado.");
        }

        rentalRepository.delete(optionalRental.get());
        return new DeleteResponse(true, "Aluguel removido com sucesso.");
    }

    @Override
    public List<Vehicle> getAvailableVehicles(AvailabilityRequest request) {
        LocalDateTime now = LocalDateTime.now();

        if (request.startDate().isBefore(now) || request.endDate().isBefore(now)) {
            throw new IllegalArgumentException("Start date and end date must be in the future.");
        }

        var vehicles = rentalRepository.findAvailableVehiclesBetween(request.startDate(), request.endDate());

        return vehicles.stream()
                .filter(vehicle -> request.category().map(category -> vehicle.getCategory().equals(category))
                        .orElse(true))
                .filter(vehicle -> request.fuelType().map(fuelType -> vehicle.getFuelType().equals(fuelType))
                        .orElse(true))
                .filter(vehicle -> request.startYear().map(startYear -> vehicle.getYear() >= startYear)
                        .orElse(true))
                .filter(vehicle -> request.endYear().map(endYear -> vehicle.getYear() <= endYear)
                        .orElse(true))
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalResponse> getRentalsByClientOrdered(Long clientId) {
        var rentals = rentalRepository.findByClientIdOrderByStatusPriority(clientId);
        return rentals.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private RentalResponse mapToResponse(Rental r) {
        return new RentalResponse(
                r.getId(),
                r.getVehicle().getId(),
                r.getClient().getId(),
                r.getStartDate(),
                r.getEndDate(),
                r.getInitialMileage(),
                r.getFinalMileage(),
                r.getInitialFuelLevel(),
                r.getFinalFuelLevel(),
                r.getTotalAmount(),
                r.getStatus());
    }

    private boolean datesOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }

}
