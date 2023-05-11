package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.Plata;
import uni.proiect.modbd.repository.PlataRepository;

import java.time.Instant;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/plata")
public class PlataController {

    @Autowired
    private PlataRepository plataRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Plata> getPlataById(@PathVariable("id") Long id) {
        Plata plata = plataRepository.findById(id).orElse(null);
        if (plata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plata, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plata> createPlata(@RequestBody Plata plata) {
        plata.setData(LocalDateTime.now());
        Plata savedPlata = plataRepository.save(plata);
        return new ResponseEntity<>(savedPlata, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plata> updatePlata(@PathVariable("id") Long id, @RequestBody Plata plata) {
        Plata existingPlata = plataRepository.findById(id).orElse(null);
        if (existingPlata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingPlata.setTip(plata.getTip());
        existingPlata.setCost(plata.getCost());
        existingPlata.setCifreCard(plata.getCifreCard());
        existingPlata.setData(LocalDateTime.now());
        Plata updatedPlata = plataRepository.save(existingPlata);
        return new ResponseEntity<>(updatedPlata, HttpStatus.OK);
    }
}