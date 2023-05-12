package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Adresa;
import uni.proiect.modbd.model.ArieCurierat;
import uni.proiect.modbd.repository.ArieCurieratRepository;

import java.util.List;

@RestController
@RequestMapping("/ariecurierat")
public class ArieCurieratController {

    @Autowired
    private ArieCurieratRepository arieCurieratRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ArieCurierat> getArieCurieratById(@PathVariable("id") Long id) {
        ArieCurierat arieCurierat = arieCurieratRepository.findById(id).orElse(null);
        if (arieCurierat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arieCurierat, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ArieCurierat>> getAll() {
        List<ArieCurierat> list = arieCurieratRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArieCurierat> createArieCurierat(@RequestBody ArieCurierat arieCurierat) {
        ArieCurierat savedArieCurierat = arieCurieratRepository.save(arieCurierat);
        return new ResponseEntity<>(savedArieCurierat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArieCurierat> updateArieCurierat(@PathVariable("id") Long id, @RequestBody ArieCurierat arieCurierat) {
        ArieCurierat existingArieCurierat = arieCurieratRepository.findById(id).orElse(null);
        if (existingArieCurierat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingArieCurierat.getCurier().setId(arieCurierat.getCurier().getId());
        ArieCurierat updatedArieCurierat = arieCurieratRepository.save(existingArieCurierat);
        return new ResponseEntity<>(updatedArieCurierat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArieCurierat(@PathVariable("id") Long id) {
        if (arieCurieratRepository.existsById(id)) {
            arieCurieratRepository.deleteById(id);
            return ResponseEntity.ok("ArieCurierat deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}