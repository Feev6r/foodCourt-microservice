package ferv.dev.foodcourtmicroservice.category.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishListRequest {

    @Min(0)
    private int page = 0;

    @Min(1)
    private int size = 5;

    private boolean orderAsc = false;

    @NotNull
    private Long restaurantId;

    @NotNull
    private Long categoryId;

}
