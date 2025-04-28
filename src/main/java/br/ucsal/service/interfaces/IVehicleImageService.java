package br.ucsal.service.interfaces;

import br.ucsal.dto.image.VehicleImageRequest;
import br.ucsal.dto.image.VehicleImageResponse;
import br.ucsal.dto.users.DeleteResponse;

import java.util.List;
import java.util.Optional;

public interface IVehicleImageService {

    VehicleImageResponse save(VehicleImageRequest vehicleImage);

    Optional<VehicleImageResponse> findById(Long id);

    List<VehicleImageResponse> findByVehicle(Long vehicleId);

    DeleteResponse delete(Long id);
}
