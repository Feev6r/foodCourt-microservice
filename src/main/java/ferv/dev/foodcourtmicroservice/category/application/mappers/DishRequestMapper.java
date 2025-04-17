package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;

public interface DishRequestMapper {

    Dish toModel(DishRequest request);
}
