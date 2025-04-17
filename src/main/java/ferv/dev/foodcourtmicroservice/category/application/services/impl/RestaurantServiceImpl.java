package ferv.dev.foodcourtmicroservice.category.application.services.impl;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.RestaurantResponse;
import ferv.dev.foodcourtmicroservice.category.application.mappers.RestaurantRequestMapper;
import ferv.dev.foodcourtmicroservice.category.application.services.RestaurantService;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.RestaurantPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantPort restaurantPort;
    private final RestaurantRequestMapper restaurantRequestMapper;

    @Override
    public void createRestaurant(RestaurantRequest request) {
        restaurantPort.createRestaurant(restaurantRequestMapper.toModel(request));
    }

    @Override
    public List<RestaurantResponse> listRestaurants(Integer page, Integer size, boolean orderAsc) {
        return restaurantRequestMapper.toResponseList(restaurantPort.listRestaurants(page, size, orderAsc));
    }


}
