package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;

public interface DishPersistencePort {

    void saveDish(Dish dish);
}
