package ferv.dev.foodcourtmicroservice.category.application.services.impl;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.mappers.OrderRequestMapper;
import ferv.dev.foodcourtmicroservice.category.application.services.OrdersService;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersService {

    private final OrderRequestMapper orderRequestMapper;
    private final OrderPort orderPort;

    @Transactional
    @Override
    public void makeOrder(OrderRequest orderRequest) {
        orderPort.makeOrder(orderRequestMapper.toOrder(orderRequest));
    }
}
