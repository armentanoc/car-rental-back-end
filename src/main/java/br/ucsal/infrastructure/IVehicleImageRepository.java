package br.ucsal.infrastructure.vehicle;

import br.ucsal.domain.vehicle.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IVehicleImageRepository extends JpaRepository<VehicleImage, Long> {
    List<VehicleImage> findByVehicleId(Long vehicleId);
}
