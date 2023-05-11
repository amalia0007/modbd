package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Furnizor;
import uni.proiect.modbd.repository.FurnizorRepository;

@RestController
@RequestMapping("/furnizor")
public class FurnizorController {

    @Autowired
    private FurnizorRepository furnizorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Furnizor> getFurnizorById(@PathVariable("id") Long id) {
        Furnizor furnizor = furnizorRepository.findById(id).orElse(null);
        if (furnizor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(furnizor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Furnizor> createFurnizor(@RequestBody Furnizor furnizor) {
        Furnizor savedFurnizor = furnizorRepository.save(furnizor);
        return new ResponseEntity<>(savedFurnizor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Furnizor> updateFurnizor(@PathVariable("id") Long id, @RequestBody Furnizor furnizor) {
        Furnizor existingFurnizor = furnizorRepository.findById(id).orElse(null);
        if (existingFurnizor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingFurnizor.setNume(furnizor.getNume());
        existingFurnizor.setTelefon(furnizor.getTelefon());
        Furnizor updatedFurnizor = furnizorRepository.save(existingFurnizor);
        return new ResponseEntity<>(updatedFurnizor, HttpStatus.OK);
    }
}