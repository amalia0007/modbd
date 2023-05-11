package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Judet;
import uni.proiect.modbd.repository.JudetRepository;

@RestController
@RequestMapping("/judet")
public class JudetController {

    @Autowired
    private JudetRepository judetRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Judet> getJudetById(@PathVariable("id") Long id) {
        Judet judet = judetRepository.findById(id).orElse(null);
        if (judet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(judet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Judet> createJudet(@RequestBody Judet judet) {
        Judet savedJudet = judetRepository.save(judet);
        return new ResponseEntity<>(savedJudet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Judet> updateJudet(@PathVariable("id") Long id, @RequestBody Judet judet) {
        Judet existingJudet = judetRepository.findById(id).orElse(null);
        if (existingJudet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingJudet.setNume(judet.getNume());
        Judet updatedJudet = judetRepository.save(existingJudet);
        return new ResponseEntity<>(updatedJudet, HttpStatus.OK);
    }
}