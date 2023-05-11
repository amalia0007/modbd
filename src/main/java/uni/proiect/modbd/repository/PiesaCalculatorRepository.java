package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.PiesaCalculator;

@Repository
public interface PiesaCalculatorRepository extends JpaRepository<PiesaCalculator, Long> {
}