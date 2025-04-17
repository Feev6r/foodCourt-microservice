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
        //TODO search for onwer's restaurant
        //TODO set restaurant id (make the connection)

        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void modifyDish(Dish dish) {
        //TODO search for onwer's restaurant
        //TODO check if the dish id is on his restaurant

        //TODO first get the dish then update it (save)

        dishPersistencePort.saveDish(dish);
    }
}
