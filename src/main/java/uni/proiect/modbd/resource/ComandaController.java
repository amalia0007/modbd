package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Client;
import uni.proiect.modbd.model.Comanda;
import uni.proiect.modbd.repository.ComandaRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comanda")
public class ComandaController {

    @Autowired
    private ComandaRepository comandaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getComandaById(@PathVariable("id") Long id) {
        Comanda comanda = comandaRepository.findById(id).orElse(null);
        if (comanda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comanda, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Comanda>> getAll() {
        List<Comanda> list = comandaRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comanda> createComanda(@RequestBody Comanda comanda) {
        comanda.setData(LocalDateTime.now());
        Comanda savedComanda = comandaRepository.save(comanda);
        return new ResponseEntity<>(savedComanda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comanda> updateComanda(@PathVariable("id") Long id, @RequestBody Comanda comanda) {
        Comanda existingComanda = comandaRepository.findById(id).orElse(null);
        if (existingComanda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingComanda.setStare(comanda.getStare());
        existingComanda.setCost(comanda.getCost());
        existingComanda.setCantitate(comanda.getCantitate());
        existingComanda.setData(LocalDateTime.now());
        Comanda updatedComanda = comandaRepository.save(existingComanda);
        return new ResponseEntity<>(updatedComanda, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComanda(@PathVariable("id") Long id) {
        if (comandaRepository.existsById(id)) {
            comandaRepository.deleteById(id);
            return ResponseEntity.ok("Comanda deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}