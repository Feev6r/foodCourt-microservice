package ferv.dev.foodcourtmicroservice.category.domain.usecases;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.RestaurantPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;

public class RestaurantUseCase implements RestaurantPort {

    private final RestaurantPersistencePort restaurantPersistancePort;

    public RestaurantUseCase(RestaurantPersistencePort restaurantPersistancePort) {
        this.restaurantPersistancePort = restaurantPersistancePort;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantPersistancePort.saveRestaurant(restaurant);
    }
}
