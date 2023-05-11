package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Plata;

@Repository
public interface PlataRepository extends JpaRepository<Plata, Long> {
}