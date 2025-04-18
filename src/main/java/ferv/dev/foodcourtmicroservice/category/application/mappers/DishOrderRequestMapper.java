package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishOrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.models.DishOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishOrderRequestMapper {

    Dish toDish(DishRequest request){

    }

    DishOrder toDishOrder(DishOrderRequest request){


    }

}
