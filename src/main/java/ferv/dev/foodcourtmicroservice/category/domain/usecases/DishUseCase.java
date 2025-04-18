package ferv.dev.foodcourtmicroservice.category.domain.usecases;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.AuthPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.DishPersistencePort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;

import java.util.List;

public class DishUseCase implements DishPort {

    private final DishPersistencePort dishPersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;
    private final AuthPort authPort;

    public DishUseCase(DishPersistencePort dishPersistencePort, RestaurantPersistencePort restaurantPersistencePort, AuthPort authPort) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.authPort = authPort;
    }

    @Override
    public void createDish(Dish dish) {
        Long ownerId = authPort.getUserIdBySecurityContext();
        Restaurant restaurant = restaurantPersistencePort.getRestaurantByOwner(ownerId);

        dish.setRestaurantId(restaurant.getId());
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void modifyDish(Dish modifiedDish) {
        Long ownerId = authPort.getUserIdBySecurityContext();
        Restaurant restaurant = restaurantPersistencePort.getRestaurant(modifiedDish.getRestaurantId());

        if(restaurant.getOwnerId() != ownerId){
            throw new RuntimeException("Current dish is not from owners restaurant");
        }

        Dish oldDish = dishPersistencePort.getDish(modifiedDish.getId());
        if(modifiedDish.isAvailable() != oldDish.isAvailable()) oldDish.setAvailable(modifiedDish.isAvailable());
        if(modifiedDish.getDescription() != null) oldDish.setDescription(modifiedDish.getDescription());
        if(modifiedDish.getPrice() != null) oldDish.setPrice(modifiedDish.getPrice());

        dishPersistencePort.saveDish(oldDish);
    }

    @Override
    public List<Dish> listDishes(Integer page, Integer size, boolean orderAsc, Long restaurantId, Long categoryId) {
        return dishPersistencePort.listDishes(page, size, orderAsc, restaurantId, categoryId);
    }

    @Override
    public Dish getDish(Long id) {
        return dishPersistencePort.getDish(id);
    }
}
