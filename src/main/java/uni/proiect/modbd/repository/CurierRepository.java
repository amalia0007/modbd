package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Curier;

@Repository
public interface CurierRepository extends JpaRepository<Curier, Long> {
}