package vasquez.store.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vasquez.store.domain.dto.Category;
import vasquez.store.persistence.entity.Categoria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "name"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);
    List<Category> toCategories(List<Categoria> categorias);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
