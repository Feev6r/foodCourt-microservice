package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.persistance;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.OrderPersistencePort;
import ferv.dev.foodcourtmicroservice.category.infrastructure.mappers.OrderMapper;
import ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPersistencePort {

    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    @Override
    public void saveOrder(Order order) {
        repository.save(orderMapper.toEntity(order));
    }
}
