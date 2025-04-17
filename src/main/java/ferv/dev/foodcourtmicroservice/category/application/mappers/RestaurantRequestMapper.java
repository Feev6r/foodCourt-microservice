package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;
import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantRequestMapper {

    Restaurant toModel(RestaurantRequest request);

}
