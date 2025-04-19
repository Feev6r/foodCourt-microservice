package ferv.dev.foodcourtmicroservice.category.infrastructure.entities;

import ferv.dev.foodcourtmicroservice.category.domain.models.OrderStates;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<DishOrderEntity> dishOrders = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStates state;

}
