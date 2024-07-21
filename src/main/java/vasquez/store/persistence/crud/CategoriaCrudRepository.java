package vasquez.store.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import vasquez.store.persistence.entity.Categoria;

import java.util.List;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {

    List<Categoria> findAllByEstado(boolean status);

}
