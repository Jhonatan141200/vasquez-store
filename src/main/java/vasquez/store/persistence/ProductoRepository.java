package vasquez.store.persistence;


import org.springframework.stereotype.Repository;
import vasquez.store.domain.dto.Product;
import vasquez.store.domain.repository.ProductRepository;
import vasquez.store.persistence.crud.ProductoCrudRepository;
import vasquez.store.persistence.entity.Producto;
import vasquez.store.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoCrudRepository productoCrudRepository;
    private final ProductMapper mapper;

    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper mapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>)productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getById(int id) {
        return productoCrudRepository.findById(id).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository
                .findByCantidadLessThanAndEstado(quantity, true);
        return productos.map(producto -> mapper.toProducts(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }


}
