package ferv.dev.foodcourtmicroservice.category.application.services.impl;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderListRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.OrderResponse;
import ferv.dev.foodcourtmicroservice.category.application.mappers.OrderDtoMapper;
import ferv.dev.foodcourtmicroservice.category.application.mappers.OrderSearchCriteriaMapper;
import ferv.dev.foodcourtmicroservice.category.application.services.OrdersService;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersService {

    private final OrderDtoMapper orderDtoMapper;
    private final OrderPort orderPort;
    private final OrderSearchCriteriaMapper criteriaMapper;

    @Transactional
    @Override
    public void makeOrder(OrderRequest orderRequest) {
        orderPort.makeOrder(orderDtoMapper.toOrder(orderRequest));
    }

    @Override
    public List<OrderResponse> listOrders(OrderListRequest orderListRequest) {
        return orderDtoMapper.toOrderResponseList(
                orderPort.listOrders(criteriaMapper.toSearchCriteria(orderListRequest)));
    }
}
