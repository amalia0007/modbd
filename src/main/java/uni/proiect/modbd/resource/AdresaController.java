package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Adresa;
import uni.proiect.modbd.repository.AdresaRepository;

import java.util.List;

@RestController
@RequestMapping("/adresa")
public class AdresaController {

    @Autowired
    private AdresaRepository adresaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Adresa> getAdresaById(@PathVariable("id") Long id) {
        Adresa adresa = adresaRepository.findById(id).orElse(null);
        if (adresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(adresa, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Adresa>> getAll() {
        List<Adresa> adrese = adresaRepository.findAll();
        if (adrese.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(adrese, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adresa> createAdresa(@RequestBody Adresa adresa) {
        Adresa savedAdresa = adresaRepository.save(adresa);
        return new ResponseEntity<>(savedAdresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adresa> updateAdresa(@PathVariable("id") Long id, @RequestBody Adresa adresa) {
        Adresa existingAdresa = adresaRepository.findById(id).orElse(null);
        if (existingAdresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAdresa.setNume(adresa.getNume());
        existingAdresa.setCodPostal(adresa.getCodPostal());
        Adresa updatedAdresa = adresaRepository.save(existingAdresa);
        return new ResponseEntity<>(updatedAdresa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdresa(@PathVariable("id") Long id) {
        if (adresaRepository.existsById(id)) {
            adresaRepository.deleteById(id);
            return ResponseEntity.ok("Adresa deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}