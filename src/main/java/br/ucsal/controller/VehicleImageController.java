package br.ucsal.controller;

import br.ucsal.dto.NotFoundResponse;
import br.ucsal.dto.image.VehicleImageRequest;
import br.ucsal.dto.image.VehicleImageResponse;
import br.ucsal.dto.users.DeleteResponse;
import br.ucsal.service.interfaces.IVehicleImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-images")
@Tag(name = "Vehicle Images", description = "Operations for managing images related to vehicles.")
public class VehicleImageController {

    @Autowired
    private IVehicleImageService vehicleImageService;

    @PostMapping
    @Operation(summary = "Add vehicle image", description = "Save a new image for a specific vehicle.")
    public ResponseEntity<VehicleImageResponse> save(@RequestBody VehicleImageRequest request) {
        var response = vehicleImageService.save(request);
        return response.success()
                ? ResponseEntity.status(HttpStatus.CREATED).body(response)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get image by ID", description = "Retrieve a single image by its unique ID.")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        var image = vehicleImageService.findById(id);
        if (image.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(image);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(id, "Image"));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete image by ID", description = "Remove a specific vehicle image by its ID.")
    public ResponseEntity<DeleteResponse> delete(@PathVariable Long id) {
        var response = vehicleImageService.delete(id);
        return response.success()
                ? ResponseEntity.ok(response)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/vehicle/{vehicleId}")
    @Operation(summary = "Get images by vehicle ID", description = "Retrieve all images related to a specific vehicle.")
    public ResponseEntity<List<VehicleImageResponse>> getByVehicleId(@PathVariable Long vehicleId) {
        var images = vehicleImageService.findByVehicle(vehicleId);
        return ResponseEntity.ok(images);
    }
}
