package vasquez.store.persistence;

import org.springframework.stereotype.Repository;
import vasquez.store.domain.dto.Purchase;
import vasquez.store.domain.repository.PurchaseRepository;
import vasquez.store.persistence.crud.CompraCrudRepository;
import vasquez.store.persistence.entity.Compra;
import vasquez.store.persistence.mapper.PurchaseMapper;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;
    private final PurchaseMapper mapper;

    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper mapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Purchase> getAll() {
        List<Compra> purchases = (List<Compra>) compraCrudRepository.findAll();
        return mapper.toPurchases(purchases);
    }

    @Override
    public Optional<List<Purchase>> getAllByClientId(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(mapper::toPurchases);
    }

    @Override
    public Optional<Purchase> getById(int purchaseId) {
        return compraCrudRepository.findById(purchaseId)
                .map(mapper::toPurchase);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        // Le decimos a que compra pertenece el item (item = CompraProducto)
        compra.getProductos().forEach(item -> item.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
