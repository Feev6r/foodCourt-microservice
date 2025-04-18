package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;

import java.util.List;

public interface DishPersistencePort {

    void saveDish(Dish dish);
    Dish getDish(Long id);
    List<Dish> listDishes(Integer page, Integer size, boolean orderAsc, Long restaurantId, Long categoryId);

}
