package br.ucsal;

import br.ucsal.domain.users.Address;
import br.ucsal.domain.users.Client;
import br.ucsal.domain.users.User;
import br.ucsal.domain.enums.Role;
import br.ucsal.infrastructure.IAddressRepository;
import br.ucsal.infrastructure.IClientRepository;
import br.ucsal.infrastructure.IUserRepository;
import br.ucsal.service.interfaces.IEncryptionService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IEncryptionService encryptionService;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByusername("admin").isEmpty()) {
            var securePassword = encryptionService.encode("admin");
            User admin = new User("Administrador", "admin@admin.com", "admin", securePassword, Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Default user created for admin.");
        } else {
            System.out.println("Default admin already exists.");
        }

        if (userRepository.findByusername("client").isEmpty()) {
            var securePassword = encryptionService.encode("client");
            User user = new User("Cliente", "client@client.com", "client", securePassword, Role.CLIENT);
            userRepository.save(user);
            System.out.println("Default user created for client.");

            Address address = new Address();
            address.setCep("123456789");
            address.setComplement("Complement");
            address.setCountry("Country");
            address.setNumber("123");
            address.setState("State");
            address.setStreet("Street");
            addressRepository.save(address);
            System.out.println("Default address created.");

            Client client = new Client();
            client.setAddress(null);
            client.setDocumentNumber("12345");
            client.setDriverLicense("67890");
            client.setEmail(user.getEmail());
            client.setLicenseExpiryDate(LocalDateTime.now().plusMonths(6));
            client.setName(user.getName());
            client.setPhone("71123456789");
            clientRepository.save(client);
            System.out.println("Default client created.");

        } else {
            System.out.println("Default client already exists.");
        }
    }
}