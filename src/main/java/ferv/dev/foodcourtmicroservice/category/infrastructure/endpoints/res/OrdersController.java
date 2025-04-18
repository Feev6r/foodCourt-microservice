package ferv.dev.foodcourtmicroservice.category.infrastructure.endpoints.res;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.services.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid OrderRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
