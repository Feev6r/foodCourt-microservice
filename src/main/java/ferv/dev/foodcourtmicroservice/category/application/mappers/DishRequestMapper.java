package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishModified;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.DishResponse;
import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;

import java.util.List;

public interface DishRequestMapper {

    Dish toModel(DishRequest request);
    Dish toModel(DishModified request);
    DishResponse toResponse(Dish dish);
    List<DishResponse> toResponseList(List<Dish> dishList);
}
