package vasquez.store.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vasquez.store.domain.dto.PurchaseItem;
import vasquez.store.persistence.entity.CompraProducto;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, PurchaseMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem toPurchaseItem(CompraProducto compraProducto);
    List<PurchaseItem> toPurchaseItems(List<CompraProducto> compraProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "compra", ignore = true),
    })
    CompraProducto toCompraProducto(PurchaseItem purchaseItem);
}
