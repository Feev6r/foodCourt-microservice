package ferv.dev.foodcourtmicroservice.category.application.services.impl;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.application.mappers.DishRequestMapper;
import ferv.dev.foodcourtmicroservice.category.application.services.DishService;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishPort dishPort;
    private final DishRequestMapper dishRequestMapper;

    @Override
    public void createDish(DishRequest request) {
        dishPort.createDish(dishRequestMapper.toModel(request));
    }
}
