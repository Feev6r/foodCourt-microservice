package ferv.dev.foodcourtmicroservice.category.domain.ports.in;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;

public interface RestaurantPort {

    void createRestaurant(Restaurant restaurant);

}
