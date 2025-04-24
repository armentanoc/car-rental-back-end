package br.ucsal.service.vehicle;

import br.ucsal.domain.vehicle.VehicleImage;

import java.util.List;
import java.util.Optional;

public interface IVehicleImageService {

    VehicleImage save(VehicleImage vehicleImage);

    Optional<VehicleImage> findById(Long id);

    List<VehicleImage> findByVehicle(Long vehicleId);

    void delete(Long id);
}
