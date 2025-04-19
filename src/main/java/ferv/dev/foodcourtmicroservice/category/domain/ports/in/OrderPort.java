package ferv.dev.foodcourtmicroservice.category.domain.ports.in;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.models.OrderSearchCriteria;

import java.util.List;

public interface OrderPort {

    void makeOrder(Order order);
    List<Order> listOrders(OrderSearchCriteria searchCriteria);
}
