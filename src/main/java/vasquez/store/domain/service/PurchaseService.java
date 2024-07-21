package vasquez.store.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vasquez.store.domain.dto.Product;
import vasquez.store.domain.dto.Purchase;
import vasquez.store.domain.dto.PurchaseItem;
import vasquez.store.domain.repository.ClientRepository;
import vasquez.store.domain.repository.ProductRepository;
import vasquez.store.domain.repository.PurchaseRepository;
import vasquez.store.web.utils.ApiResponse;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.getAll();
    }
    public Optional<Purchase> getPurchaseById(int purchaseId) {
        return purchaseRepository.getById(purchaseId);
    }

    public Optional<List<Purchase>> getAllPurchasesByClientId(String clientId) {
        return purchaseRepository.getAllByClientId(clientId);
    }

    public ResponseEntity<ApiResponse<Optional<Purchase>>> save(Purchase purchase) {
        // Verificamos si el cliente Existe
        if (clientRepository.getById(purchase.getClientId()).isEmpty()){
            return new ResponseEntity<>(new ApiResponse<>(false, "El cliente no existe", Optional.empty()), HttpStatus.PRECONDITION_FAILED);
        }
        for (PurchaseItem producto : purchase.getItems()) {
            // Verificamos si el producto Existe
            Optional<Product> productSelected = productRepository.getById(producto.getProductId());
            if (productSelected.isEmpty()){
                return new ResponseEntity<>(new ApiResponse<>(false, "El producto no existe", Optional.empty()), HttpStatus.PRECONDITION_FAILED);
            } else {
                // Si existe, Verificamos si el producto dispone de la cantidad requerida
                if (productSelected.get().getStock() < producto.getQuantity()){
                    return new ResponseEntity<>(new ApiResponse<>(false, "El producto no tiene stock suficiente", Optional.empty()), HttpStatus.PRECONDITION_FAILED);
                }
            }

        }
        return new ResponseEntity<>(new ApiResponse<>(true, "Compra registrada con éxito", Optional.of(purchaseRepository.save(purchase))), HttpStatus.CREATED);

    }
}
