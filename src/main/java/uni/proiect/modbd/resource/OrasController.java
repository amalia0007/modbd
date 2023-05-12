package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Judet;
import uni.proiect.modbd.model.Oras;
import uni.proiect.modbd.repository.OrasRepository;

import java.util.List;

@RestController
@RequestMapping("/oras")
public class OrasController {

    @Autowired
    private OrasRepository orasRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Oras> getOrasById(@PathVariable("id") Long id) {
        Oras oras = orasRepository.findById(id).orElse(null);
        if (oras == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(oras, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Oras>> getAll() {
        List<Oras> list = orasRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Oras> createOras(@RequestBody Oras oras) {
        Oras savedOras = orasRepository.save(oras);
        return new ResponseEntity<>(savedOras, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oras> updateOras(@PathVariable("id") Long id, @RequestBody Oras oras) {
        Oras existingOras = orasRepository.findById(id).orElse(null);
        if (existingOras == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingOras.setNume(oras.getNume());
        Oras updatedOras = orasRepository.save(existingOras);
        return new ResponseEntity<>(updatedOras, HttpStatus.OK);
    }

    @GetMapping("/judet/{id_judet}")
    public ResponseEntity<List<Oras>> getOrasByJudet(@PathVariable("id_judet") Long idJudet) {
        List<Oras> orasList = orasRepository.findByJudetId(idJudet);
        if (orasList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orasList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOras(@PathVariable("id") Long id) {
        if (orasRepository.existsById(id)) {
            orasRepository.deleteById(id);
            return ResponseEntity.ok("Oras deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}