package uni.proiect.modbd.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Client;
import uni.proiect.modbd.model.ClientBuc;
import uni.proiect.modbd.repository.ClientBucRepository;
import uni.proiect.modbd.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientBucRepository clientBucRepository;

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAll() {
        List<Client> list = clientRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/clients-buc/{id}")
    public ResponseEntity<ClientBuc> getClientBuc(@PathVariable("id") Long id) {
        Optional<ClientBuc> client = clientBucRepository.findById(id);
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
            if(clientData.getNume()!=null) {
                client.get().setNume(clientData.getNume());
            }
            if (clientData.getPrenume() != null) {
                client.get().setNume(clientData.getPrenume());
            }
            if(clientData.getTelefon()!=null) {
                client.get().setTelefon(clientData.getTelefon());
            }
            if(clientData.getEmail()!=null) {
                client.get().setEmail(clientData.getEmail());
            }

            client.get().setCardDeFidelitate(clientData.isCardDeFidelitate());

            Client updatedClient = clientRepository.save(client.get());
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/clients-buc/{id}")
    public ResponseEntity<ClientBuc> updateClient(@PathVariable("id") Long id, @RequestBody ClientBuc clientData) {
        Optional<ClientBuc> client = clientBucRepository.findById(id);
        if (client.isPresent()) {

            client.get().setCardDeFidelitate(clientData.isCardDeFidelitate());

            ClientBuc updatedClient = clientBucRepository.save(client.get());
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok("Client deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}