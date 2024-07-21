package vasquez.store.domain.service;

import org.springframework.stereotype.Service;
import vasquez.store.domain.dto.Client;
import vasquez.store.domain.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClientRepository clientRepository;

    public ClienteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClientById(String clientId) {
        return clientRepository.getById(clientId);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
    public Optional<Client> updateClient(String clientId, Client client) {
        return getClientById(clientId).map(clientToUpdate -> {
            client.setClientId(clientId);
            return clientRepository.save(client);
        });
    }

    public boolean deleteClient(String clientId) {
        return getClientById(clientId).map(client -> {
            clientRepository.delete(clientId);
            return true;
        }).orElse(false);
    }

}
