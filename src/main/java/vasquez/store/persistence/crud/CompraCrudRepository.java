package vasquez.store.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import vasquez.store.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String clientId);

}
