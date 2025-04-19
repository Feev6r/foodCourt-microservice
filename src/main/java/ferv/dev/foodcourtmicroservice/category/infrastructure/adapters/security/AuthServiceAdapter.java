package ferv.dev.foodcourtmicroservice.category.infrastructure.adapters.security;

import ferv.dev.foodcourtmicroservice.category.domain.ports.out.AuthServicePort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthServiceAdapter implements AuthServicePort {

    @Override
    public Long getUserIdBySecurityContext(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // contexto de seguridad
        return Long.parseLong(authentication.getName());
    }
}
