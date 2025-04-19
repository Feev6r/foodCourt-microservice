package ferv.dev.foodcourtmicroservice.category.infrastructure.mappers;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.infrastructure.entities.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RestaurantMapper.class, DishOrderMapper.class})
public interface OrderMapper {

    OrderEntity toEntity(Order order);
    Order toModel(OrderEntity orderEntity);
    List<Order> toModelList(List<OrderEntity> orderEntityList);
}
