package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Furnizor;

@Repository
public interface FurnizorRepository extends JpaRepository<Furnizor, Long> {
}