package ferv.dev.foodcourtmicroservice.category.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishModified {

    @NotNull
    private Long id;
    private Double price;
    private String description;
    private boolean isAvailable;
}

//escoger el restaurante del owner
//buscar el plato que ya existe
//ver su restaurante