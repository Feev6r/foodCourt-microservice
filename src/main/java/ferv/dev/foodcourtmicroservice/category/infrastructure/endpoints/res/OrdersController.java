package ferv.dev.foodcourtmicroservice.category.infrastructure.endpoints.res;

import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderListRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.request.OrderRequest;
import ferv.dev.foodcourtmicroservice.category.application.dto.response.OrderResponse;
import ferv.dev.foodcourtmicroservice.category.application.services.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid OrderRequest request){
        ordersService.makeOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> listOrders(OrderListRequest request){
        return ResponseEntity.ok(ordersService.listOrders(request));
    }

}
