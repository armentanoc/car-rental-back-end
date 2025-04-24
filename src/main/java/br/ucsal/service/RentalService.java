// package br.ucsal.service;

// import br.ucsal.domain.rental.Rental;
// import br.ucsal.dto.rental.*;
// import br.ucsal.infrastructure.rental.IRentalRepository;
// import br.ucsal.infrastructure.vehicle.IVehicleRepository;
// import br.ucsal.service.interfaces.IRentalService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;

// @Service
// public class RentalService implements IRentalService {

//     @Autowired
//     private IRentalRepository rentalRepository;

//     @Autowired
//     private IVehicleRepository vehicleRepository;

//     @Override
//     public AddRentalResponse add(RentalRequest request) {

//         var vehicle = vehicleRepository.findById(request.vehicleId()).orElse(null);
//         if (vehicle == null) {
//             return new AddRentalResponse(false, "Veículo não encontrado.");
//         }

//         var rental = new Rental(
//                 vehicle,
//                 request.rentalDate(),
//                 request.returnDate(),
//                 request.totalAmount(),
//                 request.renterName()
//         );

//         rentalRepository.save(rental);

//         return new AddRentalResponse(true, "Aluguel registrado com sucesso.", rental.getId());
//     }

//     @Override
//     public Optional<RentalResponse> get(Long id) {
//         return rentalRepository.findById(id).map(r -> 
//                 new RentalResponse(
//                         r.getId(),
//                         r.getVehicle().getId(),
//                         r.getRentalDate(),
//                         r.getReturnDate(),
//                         r.getTotalAmount(),
//                         r.getRenterName()
//                 ));
//     }

//     @Override
//     public List<RentalResponse> getAll() {
//         return rentalRepository.findAll().stream()
//                 .map(r -> new RentalResponse(
//                         r.getId(),
//                         r.getVehicle().getId(),
//                         r.getRentalDate(),
//                         r.getReturnDate(),
//                         r.getTotalAmount(),
//                         r.getRenterName()
//                 ))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public DeleteResponse delete(Long id) {
//         var optionalRental = rentalRepository.findById(id);
//         if (optionalRental.isEmpty()) {
//             return new DeleteResponse(false, "Aluguel não encontrado.");
//         }

//         rentalRepository.delete(optionalRental.get());

//         return new DeleteResponse(true, "Aluguel removido com sucesso.");
//     }

//     @Override
//     public UpdateResponse update(Long id, RentalRequest request) {

//         var optionalRental = rentalRepository.findById(id);
//         if (optionalRental.isEmpty()) {
//             return new UpdateResponse(false, "Aluguel não encontrado.");
//         }

//         var rental = optionalRental.get();
//         rental.setRentalDate(request.rentalDate());
//         rental.setReturnDate(request.returnDate());
//         rental.setTotalAmount(request.totalAmount());
//         rental.setRenterName(request.renterName());

//         rentalRepository.save(rental);

//         return new UpdateResponse(true, "Aluguel atualizado com sucesso.");
//     }
// }
