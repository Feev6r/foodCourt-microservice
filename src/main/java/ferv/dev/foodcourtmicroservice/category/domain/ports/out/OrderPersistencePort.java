package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;

public interface OrderPersistencePort {
    void saveOrder(Order order);
}
