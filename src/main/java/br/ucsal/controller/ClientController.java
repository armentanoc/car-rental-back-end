package br.ucsal.controller;

import br.ucsal.domain.users.Client;
import br.ucsal.dto.NotFoundResponse;
import br.ucsal.service.interfaces.IClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clients")
@Tag(name = "Clients", description = "Operations related to client management, including retrieval of client information.")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get client by user ID", description = "Retrieve a client based on the associated user ID")
    public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
        Optional<Client> client = clientService.getByUserId(userId);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(userId, "Client"));
        }
    }

    @GetMapping
    @Operation(summary = "Get all clients", description = "Retrieve all registered clients")
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        List<Client> response = clients.stream()
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}