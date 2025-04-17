package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.persistance;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;
import ferv.dev.foodcourtmicroservice.category.infrastructure.mappers.RestaurantMapper;
import ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql.RestaurantRepository;
import ferv.dev.foodcourtmicroservice.commons.configurations.utils.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantAdapter implements RestaurantPersistencePort {

    private final RestaurantRepository repository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        repository.save(restaurantMapper.toEntity(restaurant));
    }

    @Override
    public List<Restaurant> getRestaurants(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        return restaurantMapper.toModelList(repository.findAll(pagination).getContent());
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantMapper.toModel(repository.findById(id)
                .orElseThrow(RuntimeException::new));
        //TODO MAKE A CUSTOM EXEPTION TO RETURN HERE
    }
}
