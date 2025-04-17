package ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql;

import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    Page<RestaurantEntity> findAll(Pageable pegeable);

}
