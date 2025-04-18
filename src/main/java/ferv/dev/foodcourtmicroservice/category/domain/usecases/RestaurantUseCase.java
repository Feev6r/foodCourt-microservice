package ferv.dev.foodcourtmicroservice.category.domain.usecases;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.RestaurantPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;

import java.util.List;

public class RestaurantUseCase implements RestaurantPort {

    private final RestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(RestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantPersistencePort.saveRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> listRestaurants(Integer page, Integer size, boolean orderAsc) {
        return restaurantPersistencePort.getRestaurants(page, size, orderAsc);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantPersistencePort.getRestaurant(id);
    }

}
