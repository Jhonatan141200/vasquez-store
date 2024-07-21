package vasquez.store.domain.repository;

import vasquez.store.domain.dto.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();

    Optional<Category> getById(int categoryId);

    List<Category> getAllActive();

    List<Category> getAllDesactive();

    Category save(Category category);

    void delete(int categoryId);
}
