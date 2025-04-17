package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.persistance;

import ferv.dev.foodcourtmicroservice.category.domain.models.Restaurant;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;
import ferv.dev.foodcourtmicroservice.category.infrastructure.mappers.RestaurantMapper;
import ferv.dev.foodcourtmicroservice.category.infrastructure.repositories.mysql.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantAdapter implements RestaurantPersistencePort {

    private final RestaurantRepository repository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        repository.save(restaurantMapper.toEntity(restaurant));
    }
}
