package br.ucsal.controller;

import br.ucsal.dto.NotFoundResponse;
import br.ucsal.dto.vehicle.*;
import br.ucsal.service.interfaces.IVehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@Tag(name = "Vehicles", description = "Operations for managing vehicles.")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping("/{id}")
    @Operation(summary = "Get vehicle by ID", description = "Retrieve a vehicle by its ID.")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var vehicle = vehicleService.get(id);
        if (vehicle.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(vehicle);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(id, "Vehicle"));
		}
    }

    @GetMapping
    @Operation(summary = "List all vehicles", description = "Retrieve all registered vehicles.")
    public ResponseEntity<List<VehicleResponse>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PostMapping
    @Operation(summary = "Create a vehicle", description = "Add a new vehicle.")
    public ResponseEntity<AddVehicleResponse> create(@RequestBody VehicleRequest request) {
        var response = vehicleService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Delete a vehicle", description = "Delete a vehicle by its ID.")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestBody DeleteRequest request) {
        var response = vehicleService.delete(id, request);
        if (response.success())
            return ResponseEntity.ok(response);
        if (response.message().contains("não encontrado"))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
