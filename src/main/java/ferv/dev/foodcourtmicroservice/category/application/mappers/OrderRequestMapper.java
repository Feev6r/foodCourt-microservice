package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishOrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.models.DishOrder;
import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.RestaurantPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderRequestMapper {

    private final DishPort dishPort;
    private final RestaurantPort restaurantPort;

    public DishOrder toDish(DishOrderRequest request){
        if(request == null) return null;

        Dish dish = dishPort.getDish(request.getDishId());
        return new DishOrder(null, request.getQuantity(), dish);
    }

    public Order toOrder(OrderRequest request){
        Restaurant restaurant = restaurantPort.getRestaurant(request.getRestaurantId());

        List<DishOrder> dishOrders = new ArrayList<>();
        for(DishOrderRequest dishOrderRequest : request.getOrder()){
             dishOrders.add(toDish(dishOrderRequest));
        }

        return new Order(null, restaurant, dishOrders);
    }

}
