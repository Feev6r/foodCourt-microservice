package ferv.dev.foodcourtmicroservice.category.application.services;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    void createRestaurant(RestaurantRequest request);
    List<RestaurantResponse> listRestaurants(Integer page, Integer size, boolean orderAsc);

}
