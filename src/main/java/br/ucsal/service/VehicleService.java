// package br.ucsal.service;

// import br.ucsal.domain.vehicle.Vehicle;
// import br.ucsal.dto.vehicle.AddVehicleResponse;
// import br.ucsal.dto.vehicle.UpdateResponse;
// import br.ucsal.infrastructure.vehicle.IVehicleRepository;
// import br.ucsal.service.VehicleImageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class VehicleService {

//     @Autowired
//     private IVehicleRepository vehicleRepository;

//     @Autowired
//     private VehicleImageService vehicleImageService;

//     public AddVehicleResponse add(VehicleRequest request) {
//         var vehicle = new Vehicle(
//                 request.brand(),
//                 request.model(),
//                 request.year(),
//                 request.color(),
//                 request.licensePlate(),
//                 request.chassiNumber(),
//                 FuelTypeEnum.valueOf(request.fuelType()),
//                 request.mileage(),
//                 StatusEnum.valueOf(request.status()),
//                 request.additionalFeatures(),
//                 CategoryEnum.valueOf(request.category())
//         );

//         vehicleRepository.save(vehicle);

//         if (request.getImageUrls() != null) {
//             for (String imageUrl : request.getImageUrls()) {
//                 vehicleImageService.addImage(vehicle.getId(), imageUrl, "Imagem do veículo");
//             }
//         }

//         return new AddVehicleResponse(true, "Veículo criado com sucesso.", vehicle.getId());
//     }

//     public UpdateResponse update(Long id, VehicleRequest request) {
//         var optionalVehicle = vehicleRepository.findById(id);
//         if (optionalVehicle.isEmpty()) {
//             return new UpdateResponse(false, "Veículo não encontrado.");
//         }

//         var vehicle = optionalVehicle.get();
//         vehicle.setBrand(request.brand());
//         vehicle.setModel(request.model());
//         vehicle.setYear(request.year());
//         vehicle.setColor(request.color());
//         vehicle.setLicensePlate(request.licensePlate());
//         vehicle.setChassiNumber(request.chassiNumber());
//         vehicle.setFuelType(FuelTypeEnum.valueOf(request.fuelType()));
//         vehicle.setMileage(request.mileage());
//         vehicle.setStatus(StatusEnum.valueOf(request.status()));
//         vehicle.setAdditionalFeatures(request.additionalFeatures());
//         vehicle.setCategory(CategoryEnum.valueOf(request.category()));

//         vehicleRepository.save(vehicle);

//         if (request.getImageUrls() != null) {
//             for (String imageUrl : request.getImageUrls()) {
//                 vehicleImageService.addImage(vehicle.getId(), imageUrl, "Imagem atualizada do veículo");
//             }
//         }

//         return new UpdateResponse(true, "Veículo atualizado com sucesso.");
//     }
// }
