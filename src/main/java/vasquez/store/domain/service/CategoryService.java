package vasquez.store.domain.service;

import org.springframework.stereotype.Service;
import vasquez.store.domain.dto.Category;
import vasquez.store.domain.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public List<Category> getAllActive() {
        return categoryRepository.getAllActive();
    }

    public List<Category> getAllDesactive() {
        return categoryRepository.getAllDesactive();
    }

    public Optional<Category> getById(int categoryId) {
        return categoryRepository.getById(categoryId);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> update(int categoryId, Category category) {
        return categoryRepository.getById(categoryId).map(existingCategory -> {
            category.setCategoryId(categoryId);
            if (category.getName() != null){
                existingCategory.setName(category.getName());
            }
            if (category.getActive() != null) {
                existingCategory.setActive(category.getActive());
            }
            return categoryRepository.save(existingCategory);
        });
    }

    public boolean deleteById(int categoryId) {
        return categoryRepository.getById(categoryId)
                .map(category -> {
                    categoryRepository.delete(categoryId);
                    return true;
                })
                .orElse(false);
    }
}
