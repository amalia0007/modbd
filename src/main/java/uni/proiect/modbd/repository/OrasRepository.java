package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Oras;

import java.util.List;

@Repository
public interface OrasRepository extends JpaRepository<Oras, Long> {
    List<Oras> findByJudetId(Long idJudet);
}