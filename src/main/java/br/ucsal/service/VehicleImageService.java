package br.ucsal.service;

import br.ucsal.domain.vehicle.VehicleImage;
import br.ucsal.dto.image.VehicleImageRequest;
import br.ucsal.dto.image.VehicleImageResponse;
import br.ucsal.dto.users.DeleteResponse;
import br.ucsal.infrastructure.IVehicleImageRepository;
import br.ucsal.infrastructure.IVehicleRepository;
import br.ucsal.service.interfaces.IVehicleImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleImageService implements IVehicleImageService {

    @Autowired
    private IVehicleImageRepository vehicleImageRepository;

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public VehicleImageResponse save(VehicleImageRequest request) {
        var vehicle = vehicleRepository.findById(request.vehicleId()).orElse(null);
        if (vehicle == null) {
            return new VehicleImageResponse(null, null, null, null, "Veículo não encontrado.", false);
        }

        VehicleImage vehicleImage = new VehicleImage(vehicle, request.url(), request.description());
        vehicleImageRepository.save(vehicleImage);

        return new VehicleImageResponse(vehicleImage.getId(), vehicle.getId(), vehicleImage.getImageUrl(),
                vehicleImage.getDescription(), "Veículo localizado", true);
    }

    @Override
    public List<VehicleImageResponse> findByVehicle(Long vehicleId) {
        return vehicleImageRepository.findByVehicleId(vehicleId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DeleteResponse delete(Long imageId) {
        var optionalVehicleImage = vehicleImageRepository.findById(imageId);
        if (optionalVehicleImage.isEmpty()) {
            return new DeleteResponse(false, "Imagem não encontrada.");
        }

        vehicleImageRepository.delete(optionalVehicleImage.get());

        return new DeleteResponse(true, "Imagem excluída com sucesso.");
    }

    @Override
    public Optional<VehicleImageResponse> findById(Long id) {
        return vehicleImageRepository.findById(id).map(this::mapToResponse);
    }

    private VehicleImageResponse mapToResponse(VehicleImage vehicle) {
        return new VehicleImageResponse(
                vehicle.getId(),
                vehicle.getVehicle().getId(),
                vehicle.getImageUrl(),
                vehicle.getDescription(),
                "Veículo encontrado",
                true);
    }
}
