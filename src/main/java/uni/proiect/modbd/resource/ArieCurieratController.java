package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.ArieCurierat;
import uni.proiect.modbd.repository.ArieCurieratRepository;

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
}