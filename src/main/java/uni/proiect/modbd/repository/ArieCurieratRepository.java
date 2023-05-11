package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.ArieCurierat;

@Repository
public interface ArieCurieratRepository extends JpaRepository<ArieCurierat, Long> {
}