package ferv.dev.foodcourtmicroservice.category.application.services;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;

public interface RestaurantService {

    void createRestaurant(RestaurantRequest request);

}
