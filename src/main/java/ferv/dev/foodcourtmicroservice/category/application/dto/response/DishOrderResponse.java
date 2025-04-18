package ferv.dev.foodcourtmicroservice.category.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishOrderResponse {

    Integer quantity;
    DishResponse dish;

}
