package ferv.dev.foodcourtmicroservice.commons.configurations.beans.ports;

import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.OrderPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.RestaurantPort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.AuthServicePort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.DishPersistencePort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.OrderPersistencePort;
import ferv.dev.foodcourtmicroservice.category.domain.ports.out.RestaurantPersistencePort;
import ferv.dev.foodcourtmicroservice.category.domain.usecases.DishUseCase;
import ferv.dev.foodcourtmicroservice.category.domain.usecases.OrderUseCase;
import ferv.dev.foodcourtmicroservice.category.domain.usecases.RestaurantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PortsConfig {

    private final DishPersistencePort dishPersistencePort;
    private final RestaurantPersistencePort restaurantPersistencePort;
    private final AuthServicePort authServicePort;
    private final OrderPersistencePort orderPersistencePort;

    @Bean
    public DishPort dishPort(){
        return new DishUseCase(dishPersistencePort, restaurantPersistencePort, authServicePort);
    }

    @Bean
    public RestaurantPort restaurantPort(){
        return new RestaurantUseCase(restaurantPersistencePort);
    }

    @Bean
    public OrderPort orderPort(){
        return new OrderUseCase(orderPersistencePort);
    }

}
