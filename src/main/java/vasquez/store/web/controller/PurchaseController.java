package vasquez.store.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vasquez.store.domain.dto.Purchase;
import vasquez.store.domain.service.PurchaseService;
import vasquez.store.web.utils.ApiResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id") int purchaseId) {
        return purchaseService.getPurchaseById(purchaseId)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getAllPurchasesByClientId(@PathVariable("id") String clientId) {
        return purchaseService.getAllPurchasesByClientId(clientId)
                .map(purchases -> new ResponseEntity(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Optional<Purchase>>> savePurchase(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

}
