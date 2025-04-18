package ferv.dev.foodcourtmicroservice.category.application.dto.request;

import ferv.dev.foodcourtmicroservice.category.application.dto.response.RestaurantResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {

    @NotNull
    private RestaurantResponse restaurant;
    private List<DishOrderRequest> order;

}
