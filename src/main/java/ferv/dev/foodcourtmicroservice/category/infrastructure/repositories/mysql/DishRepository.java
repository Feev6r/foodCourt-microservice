package ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql;

import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<DishEntity, Long> {

    Page<DishEntity> findByRestaurantIdAndCategoryNameIsAvailable(Pageable pegeable, Long restaurantId, Long categoryId, boolean isAvailable);

    default Page<DishEntity> findAllByRestaurantAndCategory( Pageable pageable, Long restaurantId, Long categoryId) {
        return findByRestaurantIdAndCategoryNameIsAvailable(pageable, restaurantId, categoryId, true);
    }
}
