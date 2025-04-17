package ferv.dev.foodcourtmicroservice.category.domain.ports.in;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;

public interface DishPort {

    void createDish(Dish dish);
    void modifyDish(Dish dish);

}
