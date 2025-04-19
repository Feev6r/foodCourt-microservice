package ferv.dev.foodcourtmicroservice.category.application.mappers;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderListRequest;
import ferv.dev.foodcourtmicroservice.category.domain.models.OrderSearchCriteria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderSearchCriteriaMapper {
    OrderSearchCriteria toSearchCriteria(OrderListRequest request);
}
