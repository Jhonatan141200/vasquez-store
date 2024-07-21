package vasquez.store.persistence;

import org.springframework.stereotype.Repository;
import vasquez.store.domain.dto.Client;
import vasquez.store.domain.repository.ClientRepository;
import vasquez.store.persistence.crud.ClienteCrudRepository;
import vasquez.store.persistence.entity.Cliente;
import vasquez.store.persistence.mapper.ClientMapper;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    private final ClienteCrudRepository clienteCrudRepository;
    private final ClientMapper mapper;

    public ClienteRepository(ClienteCrudRepository clienteCrudRepository, ClientMapper mapper) {
        this.clienteCrudRepository = clienteCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getById(String clientId) {
        return clienteCrudRepository.findById(clientId)
                .map(mapper::toClient);
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}
