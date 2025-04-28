package br.ucsal.controller;

import br.ucsal.dto.NotFoundResponse;
import br.ucsal.dto.rental.*;
import br.ucsal.service.interfaces.IRentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
@Tag(name = "Rentals", description = "Operations for managing vehicle rentals.")
public class RentalController {

    @Autowired
    private IRentalService rentalService;

    @GetMapping("/{id}")
    @Operation(summary = "Get rental by ID", description = "Retrieve a rental by its unique ID.")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var rental = rentalService.get(id);
        if (rental.isPresent()) {
            return ResponseEntity.ok(rental.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(id, "Rental"));
        }
    }

    @GetMapping
    @Operation(summary = "List all rentals", description = "Retrieve all registered rentals.")
    public ResponseEntity<List<RentalResponse>> getAll() {
        return ResponseEntity.ok(rentalService.getAll());
    }

    @PostMapping
    @Operation(summary = "Create a rental", description = "Register a new vehicle rental.")
    public ResponseEntity<AddRentalResponse> create(@RequestBody RentalRequest request) {
        var response = rentalService.add(request);
        if (response.success()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/{id}")
    @Operation(summary = "Delete a rental", description = "Delete a rental by its ID.")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestBody DeleteRequest request) {
        var response = rentalService.delete(id, request);
        if (response.success()) {
            return ResponseEntity.ok(response);
        }
        if (response.message().contains("não encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "List rentals for a client", description = "Retrieve rentals for a specific client, ordered by status priority.")
    public ResponseEntity<List<RentalResponse>> getClientRentals(@PathVariable Long clientId) {
        var rentals = rentalService.getRentalsByClientOrdered(clientId);
        return ResponseEntity.ok(rentals);
    }

    @PostMapping("/available")
    @Operation(summary = "List available vehicles", description = "Retrieve all vehicles available for rent in a given date range.")
    public ResponseEntity<?> getAvailableVehicles(@RequestBody AvailabilityRequest request) {
        if (request.startDate() == null || request.endDate() == null) {
            return ResponseEntity.badRequest().body("Both startDate and endDate are required.");
        }

        var availableVehicles = rentalService.getAvailableVehicles(request);
        return ResponseEntity.ok(availableVehicles);
    }

}
