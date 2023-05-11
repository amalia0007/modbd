package uni.proiect.modbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.proiect.modbd.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}