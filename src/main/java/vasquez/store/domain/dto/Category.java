package vasquez.store.domain.dto;

import lombok.Data;

@Data
public class Category {
    private int categoryId;
    private String name;
    private Boolean active;
}
