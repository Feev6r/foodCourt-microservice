package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.persistance;

import ferv.dev.foodcourtmicroservice.category.domain.models.Order;
import ferv.dev.foodcourtmicroservice.category.domain.models.OrderSearchCriteria;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.OrderPersistencePort;
import ferv.dev.foodcourtmicroservice.category.infrastructure.mappers.OrderMapper;
import ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql.OrderRepository;
import ferv.dev.foodcourtmicroservice.commons.configurations.utils.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPersistencePort {

    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    @Override
    public void saveOrder(Order order) {
        repository.save(orderMapper.toEntity(order));
    }

    @Override
    public List<Order> getOrders(OrderSearchCriteria searchCriteria) {
        Pageable pagination;
        if (searchCriteria.getOrderAsc())
            pagination = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize(), Sort.by(Constants.PAGEABLE_FIELD_ID).ascending());
        else
            pagination = PageRequest.of(searchCriteria.getPage(), searchCriteria.getSize(), Sort.by(Constants.PAGEABLE_FIELD_ID).descending());

        return orderMapper.toModelList(
                repository.findByRestaurantIdAndState(pagination, searchCriteria.getRestaurantId(), searchCriteria.getState()).getContent());

    }


}
