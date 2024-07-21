package vasquez.store.domain.repository;

import vasquez.store.domain.dto.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getById(String clientId);
    Client save(Client client);
    void delete(String clientId);
}
