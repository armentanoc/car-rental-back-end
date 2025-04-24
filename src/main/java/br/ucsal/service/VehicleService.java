package br.ucsal.service;

import br.ucsal.domain.vehicle.Vehicle;
import br.ucsal.dto.users.DeleteResponse;
import br.ucsal.dto.vehicle.AddVehicleResponse;
import br.ucsal.dto.vehicle.DeleteRequest;
import br.ucsal.dto.vehicle.VehicleRequest;
import br.ucsal.dto.vehicle.VehicleResponse;
import br.ucsal.infrastructure.IVehicleRepository;
import br.ucsal.service.interfaces.IVehicleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public AddVehicleResponse add(VehicleRequest request) {
        var vehicle = new Vehicle();
        vehicle.setBrand(request.brand());
        vehicle.setAdditionalFeatures(request.additionalFeatures());
        vehicle.setCategory(request.category());
        vehicle.setChassiNumber(request.chassiNumber());
        vehicle.setColor(request.color());
        vehicle.setFuelType(request.fuelType());
        vehicle.setLicensePlate(request.licensePlate());
        vehicle.setMileage(request.mileage());
        vehicle.setModel(request.model());
        vehicle.setStatus(request.status());
        vehicle.setYear(request.year());
        vehicleRepository.save(vehicle);
        return new AddVehicleResponse(true, "Veículo criado com sucesso.", vehicle.getId());
    }

    @Override
    public Optional<VehicleResponse> get(Long id) {
        return vehicleRepository.findById(id).map(this::mapToResponse);
    }

    @Override
    public List<VehicleResponse> getAll() {
        return vehicleRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DeleteResponse delete(Long id, DeleteRequest request) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        if (optionalVehicle.isPresent()) {
            vehicleRepository.deleteById(id);
            return new DeleteResponse(true, "Veículo deletado com sucesso.");
        } else {
            return new DeleteResponse(false, "Veículo não encontrado.");
        }
    }

    private VehicleResponse mapToResponse(Vehicle vehicle) {
        return new VehicleResponse(
            vehicle.getId(),
            vehicle.getModel(),
            vehicle.getBrand(),
            vehicle.getColor(),
            vehicle.getYear(),
            vehicle.getLicensePlate(), 
            vehicle.getChassiNumber(),
            vehicle.getFuelType(),
            vehicle.getMileage(),
            vehicle.getAdditionalFeatures(),
            vehicle.getStatus(),
            vehicle.getCategory()
        );
    }    
}
