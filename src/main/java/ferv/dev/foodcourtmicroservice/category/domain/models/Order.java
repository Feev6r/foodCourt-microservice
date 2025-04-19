package ferv.dev.foodcourtmicroservice.category.domain.models;

import java.util.List;

public class Order {

    private Long id;
    private Restaurant restaurant;
    private List<DishOrder> dishOrders;
    private OrderStates state = OrderStates.PENDING;


    public Order(Long id, Restaurant restaurant, List<DishOrder> dishOrders, OrderStates state) {
        this.id = id;
        this.restaurant = restaurant;
        this.dishOrders = dishOrders;
        this.state = state;
    }

    public OrderStates getState() {
        return state;
    }

    public void setState(OrderStates state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<DishOrder> getDishOrders() {
        return dishOrders;
    }

    public void setDishOrders(List<DishOrder> dishOrders) {
        this.dishOrders = dishOrders;
    }
}
