package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.ClientBuc;

@Repository
public interface ClientBucRepository extends JpaRepository<ClientBuc, Long> {

}