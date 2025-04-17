package ferv.dev.foodcourtmicroservice.category.infrastructure.mappers;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.RestaurantEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantEntity toEntity(Restaurant restaurant);
    Restaurant toModel(RestaurantEntity entity);
    List<Restaurant> toModelList(List<RestaurantEntity> entityList);


}
