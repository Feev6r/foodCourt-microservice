package ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql;

import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {



}
