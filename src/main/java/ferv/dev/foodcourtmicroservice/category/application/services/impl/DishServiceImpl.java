package ferv.dev.foodcourtmicroservice.category.application.services.impl;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishModified;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.DishResponse;
import ferv.dev.foodcourtmicroservice.category.application.mappers.DishRequestMapper;
import ferv.dev.foodcourtmicroservice.category.application.services.DishService;
import ferv.dev.foodcourtmicroservice.category.domain.ports.in.DishPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishPort dishPort;
    private final DishRequestMapper dishRequestMapper;

    @Override
    public void createDish(DishRequest request) {
        dishPort.createDish(dishRequestMapper.toModel(request));
    }

    @Override
    public void modifyDish(DishModified request) {
        dishPort.modifyDish(dishRequestMapper.toModel(request));
    }

    @Override
    public List<DishResponse> listDishes(Integer page, Integer size, boolean orderAsc, Long restaurantId, Long categoryId) {
        return dishRequestMapper.toResponseList(dishPort.listDishes(page, size, orderAsc, restaurantId, categoryId));
    }
}
