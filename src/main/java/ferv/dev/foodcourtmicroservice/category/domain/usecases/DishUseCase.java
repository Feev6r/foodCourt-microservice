package ferv.dev.foodcourtmicroservice.category.domain.usecases;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.DishPersistencePort;

public class DishUseCase implements DishPort {

    private final DishPersistencePort dishPersistencePort;

    public DishUseCase(DishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public void createDish(Dish dish) {
        dishPersistencePort.saveDish(dish);
    }
}
