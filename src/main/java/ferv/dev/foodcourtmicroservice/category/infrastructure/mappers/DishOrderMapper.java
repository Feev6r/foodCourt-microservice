package ferv.dev.foodcourtmicroservice.category.infrastructure.mappers;

import ferv.dev.foodcourtmicroservice.category.domain.models.DishOrder;
import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.DishOrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DishMapper.class)
public interface DishOrderMapper {

    DishOrderEntity toEntity(DishOrder dishOrder);

}
