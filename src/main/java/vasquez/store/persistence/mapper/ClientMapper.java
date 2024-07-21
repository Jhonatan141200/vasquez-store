package vasquez.store.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vasquez.store.domain.dto.Client;
import vasquez.store.persistence.entity.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id",target = "clientId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellidos",target = "lastname"),
            @Mapping(source = "celular",target = "phone"),
            @Mapping(source = "direccion",target = "address"),
            @Mapping(source = "correo",target = "email"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toCliente(Client client);
}
