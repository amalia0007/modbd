package uni.proiect.modbd.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Client;
import uni.proiect.modbd.repository.ClientRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client clientData) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            client.get().setNume(clientData.getNume());
            client.get().setPrenume(clientData.getPrenume());
            client.get().setTelefon(clientData.getTelefon());
            client.get().setEmail(clientData.getEmail());
            client.get().setCardDeFidelitate(clientData.isCardDeFidelitate());

            Client updatedClient = clientRepository.save(client.get());
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}