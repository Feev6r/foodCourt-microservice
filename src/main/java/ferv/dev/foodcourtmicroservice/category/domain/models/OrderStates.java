package ferv.dev.foodcourtmicroservice.category.domain.models;

public enum OrderStates {

    CANCELLED(1),
    PENDING(1),
    PREPARING(2),
    READY(3),
    DELIVERED(4);

    private final int value;

    private OrderStates(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
