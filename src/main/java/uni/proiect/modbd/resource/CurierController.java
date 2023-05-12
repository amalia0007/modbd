package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Comanda;
import uni.proiect.modbd.model.Curier;
import uni.proiect.modbd.repository.CurierRepository;

import java.util.List;

@RestController
@RequestMapping("/curier")
public class CurierController {

    @Autowired
    private CurierRepository curierRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Curier> getCurierById(@PathVariable("id") Long id) {
        Curier curier = curierRepository.findById(id).orElse(null);
        if (curier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curier, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Curier>> getAll() {
        List<Curier> list = curierRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Curier> createCurier(@RequestBody Curier curier) {
        Curier savedCurier = curierRepository.save(curier);
        return new ResponseEntity<>(savedCurier, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curier> updateCurier(@PathVariable("id") Long id, @RequestBody Curier curier) {
        Curier existingCurier = curierRepository.findById(id).orElse(null);
        if (existingCurier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCurier.setNume(curier.getNume());
        existingCurier.setPrenume(curier.getPrenume());
        existingCurier.setTelefon(curier.getTelefon());
        existingCurier.setEmail(curier.getEmail());
        Curier updatedCurier = curierRepository.save(existingCurier);
        return new ResponseEntity<>(updatedCurier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurier(@PathVariable("id") Long id) {
        if (curierRepository.existsById(id)) {
            curierRepository.deleteById(id);
            return ResponseEntity.ok("Curier deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}