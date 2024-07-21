package vasquez.store.domain.repository;

import vasquez.store.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<Product> getById(int id);

    Optional<List<Product>> getScarceProducts(int quantity);

    Product save(Product product);

    void delete(int productId);

}
