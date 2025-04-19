package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishOrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.DishOrderResponse;
import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.models.DishOrder;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DishOrderMapper {

    private final DishDtoMapper dishDtoMapper;
    private final DishPort dishPort;

    public DishOrder toDish(DishOrderRequest request){
        if(request == null) return null;

        Dish dish = dishPort.getDish(request.getDishId());
        return new DishOrder(null, request.getQuantity(), dish);
    }

    DishOrderResponse toDishOrderResponse(DishOrder dishOrder){
        if(dishOrder == null) return null;

        DishOrderResponse dishOrderResponse = new DishOrderResponse();
        dishOrderResponse.setDish(dishDtoMapper.toResponse(dishOrder.getDish()));
        dishOrderResponse.setQuantity(dishOrder.getQuantity());

        return dishOrderResponse;
    }

    List<DishOrderResponse> toDishOrderResponses(List<DishOrder> dishOrderList){
        if(dishOrderList == null) return null;

        List<DishOrderResponse> dishOrderResponseList = new ArrayList<>();
        for(DishOrder dishOrder : dishOrderList){
            dishOrderResponseList.add(toDishOrderResponse(dishOrder));
        }
        return dishOrderResponseList;
    }
}
