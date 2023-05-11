package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {
}