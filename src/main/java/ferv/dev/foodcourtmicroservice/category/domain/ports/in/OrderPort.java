package ferv.dev.foodcourtmicroservice.category.domain.ports.in;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;

public interface OrderPort {

    void makeOrder(Order order);
}
