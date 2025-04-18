package ferv.dev.foodcourtmicroservice.category.application.dto.response;

import ferv.dev.foodcourtmicroservice.category.domain.models.OrderStates;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {

    private Long id;
    private RestaurantResponse restaurant;
    private List<DishOrderResponse> orders;
    private OrderStates state;

}
