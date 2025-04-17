package ferv.dev.foodcourtmicroservice.category.infrastructure.endpoints.res;


import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishModified;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.DishRequest;
import ferv.dev.foodcourtmicroservice.category.application.services.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
@Validated
public class DishController {

    private final DishService dishService;

    @PostMapping("/create")
    public ResponseEntity<Void> createDish(DishRequest request){
        dishService.createDish(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/modify")
    public ResponseEntity<Void> modifyDish(DishModified request){
        dishService.modifyDish(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
