package ferv.dev.foodcourtmicroservice.category.application.services;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishModified;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.DishResponse;

import java.util.List;

public interface DishService {

    void createDish(DishRequest request);
    void modifyDish(DishModified request);
    List<DishResponse> listDishes(Integer page, Integer size, boolean orderAsc, Long restaurantId, Long categoryId);


}
