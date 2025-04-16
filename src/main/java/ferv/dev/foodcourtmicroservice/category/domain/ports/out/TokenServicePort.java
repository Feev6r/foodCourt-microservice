package ferv.dev.foodcourtmicroservice.category.domain.ports.out;

public interface TokenServicePort {

    String extractUsername(String token);
    Long getUserIdBySecurityContext();
    boolean isTokenValid(String token, String username);

}
