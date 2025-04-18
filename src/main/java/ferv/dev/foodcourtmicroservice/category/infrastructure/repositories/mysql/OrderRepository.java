package ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql;

import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
