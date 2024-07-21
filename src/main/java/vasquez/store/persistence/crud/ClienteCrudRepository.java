package vasquez.store.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import vasquez.store.persistence.entity.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

}
