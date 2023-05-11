package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Judet;

@Repository
public interface JudetRepository extends JpaRepository<Judet, Long> {
}