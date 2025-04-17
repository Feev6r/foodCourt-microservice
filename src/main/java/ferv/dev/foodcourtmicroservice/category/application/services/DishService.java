package ferv.dev.foodcourtmicroservice.category.application.services;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;

public interface DishService {

    void createDish(DishRequest request);
}
