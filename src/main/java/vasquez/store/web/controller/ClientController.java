package vasquez.store.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vasquez.store.domain.dto.Client;
import vasquez.store.domain.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClienteService clienteService;

    public ClientController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clienteService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") String clientId) {
        return clienteService.getClientById(clientId)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<>(clienteService.saveClient(client), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") String clientId, @RequestBody Client client) {
        return clienteService.updateClient(clientId,client)
                .map(clientUpdated -> new ResponseEntity<>(clientUpdated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> delete(@PathVariable("id") String clientId) {
        return clienteService.deleteClient(clientId)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
