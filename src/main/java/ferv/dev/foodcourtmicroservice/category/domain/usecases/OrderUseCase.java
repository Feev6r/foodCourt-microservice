package ferv.dev.foodcourtmicroservice.category.domain.usecases;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.OrderPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.OrderPersistencePort;

public class OrderUseCase implements OrderPort {

    private final OrderPersistencePort orderPersistencePort;

    public OrderUseCase(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    @Override
    public void makeOrder(Order order) {
        orderPersistencePort.saveOrder(order);
    }
}
