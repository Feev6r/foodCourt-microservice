package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;

public interface RestaurantPersistencePort {

    void saveRestaurant(Restaurant restaurant);

}
