package ferv.dev.foodcourtmicroservice.category.domain.models;

import java.util.List;

public class Restaurant {

    private Long id;
    private String name;
    private String address;
    private String nit;
    private String phoneNumber;
    private String urlLogo;
    private Long ownerId;
    private List<String> dishes;

}
