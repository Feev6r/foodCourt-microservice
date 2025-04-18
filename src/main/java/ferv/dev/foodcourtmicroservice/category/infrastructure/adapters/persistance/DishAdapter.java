package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.persistance;

import ferv.dev.foodcourtmicroservice.category.domain.models.Dish;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.DishPersistencePort;
import ferv.dev.foodcourtmicroservice.category.infrastructure.mappers.DishMapper;
import ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql.DishRepository;
import ferv.dev.foodcourtmicroservice.commons.configurations.utils.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DishAdapter implements DishPersistencePort {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    public void saveDish(Dish dish) {
        dishRepository.save(dishMapper.toEntity(dish));
    }

    @Override
    public Dish getDish(Long id) {
        return dishMapper.toModel(dishRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<Dish> listDishes(Integer page, Integer size, boolean orderAsc, Long restaurantId, Long categoryId) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        return dishMapper.toModelList(dishRepository.findAllByRestaurantAndCategory(pagination, restaurantId, categoryId).getContent());
    }
}
