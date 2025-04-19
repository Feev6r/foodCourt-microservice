package ferv.dev.foodcourtmicroservice.category.infrastructure.endpoints.res;


import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishListRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishModified;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.DishResponse;
import ferv.dev.foodcourtmicroservice.category.application.services.DishService;
import ferv.dev.foodcourtmicroservice.commons.configurations.utils.constants.ApiPaths;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.DISHES)
@RequiredArgsConstructor
@Validated
public class DishController {

    private final DishService dishService;

    @PostMapping
    public ResponseEntity<Void> createDish(@Valid DishRequest request){
        dishService.createDish(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> modifyDish(DishModified request){
        dishService.modifyDish(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<DishResponse>> listDishes(@Valid DishListRequest request){

        return ResponseEntity.ok(dishService.listDishes(
                request.getPage(),
                request.getSize(),
                request.isOrderAsc(),
                request.getRestaurantId(),
                request.getCategoryId()));
    }

}
