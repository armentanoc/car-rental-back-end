package br.ucsal.service.interfaces;

import br.ucsal.dto.vehicle.*;

import java.util.List;
import java.util.Optional;
import br.ucsal.dto.users.DeleteResponse;

public interface IVehicleService {

    AddVehicleResponse add(VehicleRequest request);

    Optional<VehicleResponse> get(Long id);

    List<VehicleResponse> getAll();

    DeleteResponse delete(Long id, DeleteRequest request);
}
