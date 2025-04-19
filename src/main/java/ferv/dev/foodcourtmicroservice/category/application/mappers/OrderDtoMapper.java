package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishOrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.OrderResponse;

import ferv.dev.foodcourtmicroservice.category.domain.models.DishOrder;
import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.RestaurantPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDtoMapper {

    private final RestaurantPort restaurantPort;
    private final RestaurantDtoMapper restaurantDtoMapper;
    private final DishOrderMapper dishOrderMapper;


    public Order toOrder(OrderRequest request){
        Restaurant restaurant = restaurantPort.getRestaurant(request.getRestaurantId());

        List<DishOrder> dishOrders = new ArrayList<>();
        for(DishOrderRequest dishOrderRequest : request.getOrder()){
             dishOrders.add(dishOrderMapper.toDish(dishOrderRequest));
        }

        return new Order(null, restaurant, dishOrders);
    }

    public OrderResponse toOrderResponse(Order order){

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setRestaurant(restaurantDtoMapper.toResponse(order.getRestaurant()));
        orderResponse.setOrders(dishOrderMapper.toDishOrderResponses(order.getDishOrders()));
        orderResponse.setState(order.getState());

        return orderResponse;
    }

    public List<OrderResponse> toOrderResponseList(List<Order> orderList){

        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order order : orderList){
            orderResponseList.add(toOrderResponse(order));
        }
        return orderResponseList;
    }
}
