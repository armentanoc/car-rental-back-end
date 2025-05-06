package br.ucsal.controller;

import br.ucsal.dto.NotFoundResponse;
import br.ucsal.dto.rental.*;
import br.ucsal.service.interfaces.IRentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @Operation(summary = "Get paginated rentals", description = "Retrieve all registered rentals with pagination.")
    public ResponseEntity<Page<RentalResponse>> getAll(Pageable pageable) {
        Page<RentalResponse> rentals = rentalService.getAll(pageable);
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Get paginated rentals for a client", description = "Retrieve rentals for a specific client, ordered by status priority with pagination.")
    public ResponseEntity<Page<RentalResponse>> getClientRentals(@PathVariable Long clientId, Pageable pageable) {
        Page<RentalResponse> rentals = rentalService.getRentalsByClientOrdered(clientId, pageable);
        return ResponseEntity.ok(rentals);
    }

    @PostMapping("/available")
    @Operation(summary = "Get paginated available vehicles", description = "Retrieve all vehicles available for rent in a given date range with pagination.")
    public ResponseEntity<?> getAvailableVehicles(
        @RequestBody AvailabilityRequest request, Pageable pageable) {
        
        if (request.startDate() == null || request.endDate() == null) {
            return ResponseEntity.badRequest().body("Both startDate and endDate are required.");
        }

        var availableVehicles = rentalService.getAvailableVehicles(request, pageable);
        return ResponseEntity.ok(availableVehicles);
    }

}
