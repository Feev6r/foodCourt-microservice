package ferv.dev.foodcourtmicroservice.category.application.dto.response;

import ferv.dev.foodcourtmicroservice.category.domain.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponse {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String urlImage;
    private Category category;
}
