package ferv.dev.foodcourtmicroservice.category.infrastructure.endpoints.res;


import ferv.dev.foodcourtmicroservice.category.application.dto.request.RestaurantRequest;
import ferv.dev.foodcourtmicroservice.category.application.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@Validated
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<Void> createRestaurant(RestaurantRequest request){
        restaurantService.createRestaurant(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
