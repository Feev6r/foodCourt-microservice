package ferv.dev.foodcourtmicroservice.category.application.services;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.OrderResponse;
import ferv.dev.foodcourtmicroservice.category.domain.models.OrderStates;

import java.util.List;

public interface OrdersService {

    void makeOrder(OrderRequest orderRequest);

}
