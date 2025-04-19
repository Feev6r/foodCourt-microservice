package ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql;

import ferv.dev.foodcourtmicroservice.category.domain.models.OrderStates;
import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Page<OrderEntity> findByRestaurantIdAndState(Pageable pageable, Long restaurantId, OrderStates state);

}
