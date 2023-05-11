package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}