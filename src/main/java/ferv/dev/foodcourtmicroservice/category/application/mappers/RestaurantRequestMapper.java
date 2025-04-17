package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.RestaurantResponse;
import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantRequestMapper {

    Restaurant toModel(RestaurantRequest request);
    RestaurantResponse toResponse(Restaurant restaurant);
    List<RestaurantResponse> toResponseList(List<Restaurant> restaurantsList);
}
