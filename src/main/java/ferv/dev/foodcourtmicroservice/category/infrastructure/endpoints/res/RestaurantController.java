package ferv.dev.foodcourtmicroservice.category.infrastructure.endpoints.res;


import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.RestaurantResponse;
import ferv.dev.foodcourtmicroservice.category.application.services.RestaurantService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
@Validated
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Void> createRestaurant(RestaurantRequest request){
        restaurantService.createRestaurant(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> listRestaurants(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "5") @Min(1) int size,
            @RequestParam(defaultValue = "false") boolean orderAsc){

        return ResponseEntity.ok(restaurantService.listRestaurants(page, size, orderAsc));
    }

}
