package ferv.dev.foodcourtmicroservice.category.infrastructure.mappers;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.DishEntity;

import java.util.List;

public interface DishMapper {

    DishEntity toEntity(Dish dish);
    Dish toModel(DishEntity dish);
    List<Dish> toModelList(List<DishEntity> dishEntityList);

}
