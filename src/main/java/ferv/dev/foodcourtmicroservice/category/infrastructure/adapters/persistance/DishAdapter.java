package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.persistance;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.DishPersistencePort;
import ferv.dev.foodcourtmicroservice.category.infrastructure.mappers.DishMapper;
import ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishAdapter implements DishPersistencePort {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    public void saveDish(Dish dish) {
        dishRepository.save(dishMapper.toEntity(dish));
    }
}
