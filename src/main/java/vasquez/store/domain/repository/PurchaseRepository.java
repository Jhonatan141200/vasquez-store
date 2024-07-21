package vasquez.store.domain.repository;

import vasquez.store.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getAllByClientId(String clientId);
    Optional<Purchase> getById(int purchaseId);
    Purchase save(Purchase purchase);
}
