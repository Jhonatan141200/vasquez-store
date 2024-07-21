package vasquez.store.domain.service;

import org.springframework.stereotype.Service;
import vasquez.store.domain.dto.Product;
import vasquez.store.domain.repository.CategoryRepository;
import vasquez.store.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getById(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarceProducts(int quantity) {
        return productRepository.getScarceProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> update(int productId, Product product) {
        return productRepository.getById(productId).map(productToUpdate -> {
            if (categoryRepository.getById(product.getCategoryId()).isEmpty()){
                return null;
            }
            product.setProductId(productId);
            return productRepository.save(product);
        });
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
