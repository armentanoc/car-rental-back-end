// package br.ucsal.service;

// import br.ucsal.domain.client.Client;
// import br.ucsal.domain.client.Address;
// import br.ucsal.dto.client.*;
// import br.ucsal.infrastructure.client.IClientRepository;
// import br.ucsal.infrastructure.client.IAddressRepository;
// import br.ucsal.service.interfaces.IClientService;
// import br.ucsal.service.interfaces.IEncryptionService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;
// import java.util.regex.Pattern;
// import java.util.stream.Collectors;

// @Service
// public class ClientService implements IClientService {

//     @Autowired
//     private IClientRepository clientRepository;

//     @Autowired
//     private IAddressRepository addressRepository;

//     @Autowired
//     private IEncryptionService encryptor;

//     @Override
//     public AddClientResponse add(ClientRequest request) {

//         if (!isValidEmailAddress(request.email())) {
//             return new AddClientResponse(false, "E-mail inválido.");
//         }

//         var address = new Address(request.street(), request.number(), request.state(), request.cep(), request.country(), request.complement());
//         addressRepository.save(address);

//         var hashedPassword = encryptor.encode(request.password());
//         var client = new Client(request.name(), request.documentNumber(), address, request.phone(), request.email(), request.driverLicense(), request.licenseExpiryDate(), hashedPassword);

//         clientRepository.save(client);

//         return new AddClientResponse(true, "Cliente criado com sucesso.", client.getId());
//     }

//     @Override
//     public Optional<ClientResponse> get(Long clientId) {
//         return clientRepository.findById(clientId)
//                 .map(client -> new ClientResponse(client.getId(), client.getName(), client.getEmail(), client.getPhone(), client.getDocumentNumber()));
//     }

//     @Override
//     public List<ClientResponse> getAll() {
//         return clientRepository.findAll().stream()
//                 .map(client -> new ClientResponse(client.getId(), client.getName(), client.getEmail(), client.getPhone(), client.getDocumentNumber()))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public DeleteResponse delete(Long clientId) {
//         var optionalClient = clientRepository.findById(clientId);
//         if (optionalClient.isEmpty()) {
//             return new DeleteResponse(false, "Cliente não encontrado.");
//         }

//         clientRepository.delete(optionalClient.get());
//         return new DeleteResponse(true, "Cliente excluído com sucesso.");
//     }

//     @Override
//     public UpdateResponse update(Long clientId, ClientRequest request) {

//         var optionalClient = clientRepository.findById(clientId);
//         if (optionalClient.isEmpty()) {
//             return new UpdateResponse(false, "Cliente não encontrado.");
//         }

//         var client = optionalClient.get();

//         if (request.email() != null && !isValidEmailAddress(request.email())) {
//             return new UpdateResponse(false, "E-mail inválido.");
//         }

//         client.setEmail(request.email());
//         client.setPhone(request.phone());
//         client.setName(request.name());
//         client.setDocumentNumber(request.documentNumber());
//         client.setDriverLicense(request.driverLicense());
//         client.setLicenseExpiryDate(request.licenseExpiryDate());

//         if (request.password() != null) {
//             client.setSecurePassword(encryptor.encode(request.password()));
//         }

//         clientRepository.save(client);

//         return new UpdateResponse(true, "Cliente atualizado com sucesso.");
//     }

//     private boolean isValidEmailAddress(String email) {
//         if (email == null) return false;
//         String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//         Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
//         return EMAIL_PATTERN.matcher(email).matches();
//     }
// }
