package ferv.dev.foodcourtmicroservice.category.domain.usecases;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.AuthServicePort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.DishPersistencePort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;

import java.util.List;
import java.util.Objects;

public class DishUseCase implements DishPort {

    private final DishPersistencePort dishPersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;
    private final AuthServicePort authServicePort;

    public DishUseCase(DishPersistencePort dishPersistencePort, RestaurantPersistencePort restaurantPersistencePort, AuthServicePort authServicePort) {
        this.dishPersistencePort = dishPersistencePort;
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.authServicePort = authServicePort;
    }

    @Override
    public void createDish(Dish dish) {
        Long ownerId = authServicePort.getUserIdBySecurityContext();
        Restaurant restaurant = restaurantPersistencePort.getRestaurantByOwner(ownerId);

        dish.setRestaurant(restaurant);
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public void modifyDish(Dish modifiedDish) {
        //Get the owner id and restaurant of the modified dish in order to verify if the dish is in the owner's restaurant
        Long ownerId = authServicePort.getUserIdBySecurityContext();

        Dish oldDish = dishPersistencePort.getDish(modifiedDish.getId());

        if(!Objects.equals(oldDish.getRestaurant().getOwnerId(), ownerId)){
            throw new RuntimeException("Current dish is not from owners restaurant");
        }

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
