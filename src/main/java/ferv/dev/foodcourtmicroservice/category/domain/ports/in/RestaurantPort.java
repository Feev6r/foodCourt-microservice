package ferv.dev.foodcourtmicroservice.category.domain.ports.in;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;

import java.util.List;

public interface RestaurantPort {

    void createRestaurant(Restaurant restaurant);
    List<Restaurant> listRestaurants(Integer page, Integer size, boolean orderAsc);
    Restaurant getRestaurant(Long id);
}
