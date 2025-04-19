package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.models.OrderSearchCriteria;

import java.util.List;

public interface OrderPersistencePort {
    void saveOrder(Order order);
    List<Order> getOrders(OrderSearchCriteria searchCriteria);
}
