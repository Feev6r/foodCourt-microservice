package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;

import java.util.List;

public interface RestaurantPersistencePort {

    void saveRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurants(Integer page, Integer size, boolean orderAsc);
    Restaurant getRestaurant(Long id);
    Restaurant getRestaurantByOwner(Long id);
}
