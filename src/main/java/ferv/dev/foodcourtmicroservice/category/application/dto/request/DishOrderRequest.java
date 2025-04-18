package ferv.dev.foodcourtmicroservice.category.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishOrderRequest {

    @NotNull
    private Integer quantity;
    @NotNull
    private Long dishId;

}
