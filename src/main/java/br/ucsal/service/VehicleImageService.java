// package br.ucsal.service;

// import br.ucsal.domain.vehicle.Vehicle;
// import br.ucsal.domain.vehicle.VehicleImage;
// import br.ucsal.dto.vehicle.AddVehicleImageResponse;
// import br.ucsal.dto.vehicle.DeleteResponse;
// import br.ucsal.dto.vehicle.UpdateResponse;
// import br.ucsal.infrastructure.vehicle.IVehicleImageRepository;
// import br.ucsal.infrastructure.vehicle.IVehicleRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class VehicleImageService {

//     @Autowired
//     private IVehicleImageRepository vehicleImageRepository;

//     @Autowired
//     private IVehicleRepository vehicleRepository;

//     public AddVehicleImageResponse addImage(Long vehicleId, String imageUrl, String description) {
//         var vehicle = vehicleRepository.findById(vehicleId).orElse(null);
//         if (vehicle == null) {
//             return new AddVehicleImageResponse(false, "Veículo não encontrado.");
//         }

//         VehicleImage vehicleImage = new VehicleImage(vehicle, imageUrl, description);
//         vehicleImageRepository.save(vehicleImage);

//         return new AddVehicleImageResponse(true, "Imagem registrada com sucesso.", vehicleImage.getId());
//     }

//     public List<VehicleImage> getImagesByVehicle(Long vehicleId) {
//         return vehicleImageRepository.findByVehicleId(vehicleId);
//     }

//     public DeleteResponse deleteImage(Long imageId) {
//         var optionalVehicleImage = vehicleImageRepository.findById(imageId);
//         if (optionalVehicleImage.isEmpty()) {
//             return new DeleteResponse(false, "Imagem não encontrada.");
//         }

//         vehicleImageRepository.delete(optionalVehicleImage.get());

//         return new DeleteResponse(true, "Imagem excluída com sucesso.");
//     }

//     public UpdateResponse updateImage(Long imageId, String newDescription) {
//         var optionalVehicleImage = vehicleImageRepository.findById(imageId);
//         if (optionalVehicleImage.isEmpty()) {
//             return new UpdateResponse(false, "Imagem não encontrada.");
//         }

//         var vehicleImage = optionalVehicleImage.get();
//         vehicleImage.setDescription(newDescription);
//         vehicleImageRepository.save(vehicleImage);

//         return new UpdateResponse(true, "Imagem atualizada com sucesso.");
//     }
// }
