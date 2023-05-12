package uni.proiect.modbd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.proiect.modbd.model.PiesaCalculator;
import uni.proiect.modbd.repository.PiesaCalculatorRepository;

import java.util.List;

@RestController
@RequestMapping("/piesacalculator")
public class PiesaCalculatorController {

    @Autowired
    private PiesaCalculatorRepository piesaCalculatorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PiesaCalculator> getPiesaCalculatorById(@PathVariable("id") Long id) {
        PiesaCalculator piesaCalculator = piesaCalculatorRepository.findById(id).orElse(null);
        if (piesaCalculator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(piesaCalculator, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PiesaCalculator>> getAll() {
        List<PiesaCalculator> list = piesaCalculatorRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PiesaCalculator> createPiesaCalculator(@RequestBody PiesaCalculator piesaCalculator) {
        PiesaCalculator savedPiesaCalculator = piesaCalculatorRepository.save(piesaCalculator);
        return new ResponseEntity<>(savedPiesaCalculator, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PiesaCalculator> updatePiesaCalculator(@PathVariable("id") Long id, @RequestBody PiesaCalculator piesaCalculator) {
        PiesaCalculator existingPiesaCalculator = piesaCalculatorRepository.findById(id).orElse(null);
        if (existingPiesaCalculator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingPiesaCalculator.setNume(piesaCalculator.getNume());
        existingPiesaCalculator.setDescriere(piesaCalculator.getDescriere());
        existingPiesaCalculator.setTip(piesaCalculator.getTip());
        existingPiesaCalculator.setPret(piesaCalculator.getPret());
        PiesaCalculator updatedPiesaCalculator = piesaCalculatorRepository.save(existingPiesaCalculator);
        return new ResponseEntity<>(updatedPiesaCalculator, HttpStatus.OK);
    }
}