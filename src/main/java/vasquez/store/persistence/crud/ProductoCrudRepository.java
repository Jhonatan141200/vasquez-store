package vasquez.store.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import vasquez.store.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadLessThanAndEstado(int cantidadStock, boolean estado);

}
