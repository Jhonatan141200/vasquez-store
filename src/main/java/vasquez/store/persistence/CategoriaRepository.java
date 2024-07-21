package vasquez.store.persistence;

import org.springframework.stereotype.Repository;
import vasquez.store.domain.dto.Category;
import vasquez.store.domain.repository.CategoryRepository;
import vasquez.store.persistence.crud.CategoriaCrudRepository;
import vasquez.store.persistence.entity.Categoria;
import vasquez.store.persistence.mapper.CategoryMapper;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    private final CategoriaCrudRepository categoriaCrudRepository;
    private final CategoryMapper mapper;

    public CategoriaRepository(CategoriaCrudRepository categoriaCrudRepository, CategoryMapper mapper) {
        this.categoriaCrudRepository = categoriaCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getById(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(mapper::toCategory);
    }

    @Override
    public List<Category> getAllActive() {
        List<Categoria> categorias = categoriaCrudRepository.findAllByEstado(true);
        return mapper.toCategories(categorias);
    }

    @Override
    public List<Category> getAllDesactive() {
        List<Categoria> categorias = categoriaCrudRepository.findAllByEstado(false);
        return mapper.toCategories(categorias);
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
