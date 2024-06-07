package br.unitins.topicos1.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
// import java.util.HashSet;
// import java.util.Set;
import java.util.Set;

import br.unitins.topicos1.dto.AdministradorResponseDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME_ADMIN = Duration.ofHours(24);
    private static final Duration EXPIRATION_TIME_CLIENTE = Duration.ofHours(24);

    @Override
    public String generateJwt(AdministradorResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME_ADMIN);

        
        Set<String> roles = new HashSet<String>();
        roles.add("ADMIN");

        return Jwt.issuer("instruments-jwt")
            .subject(Long.toString(dto.id()))
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }

    @Override
    public String generateJwt(ClienteResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME_CLIENTE);

        // exemplo para teste
        Set<String> roles = new HashSet<String>();
        roles.add("CLIENTE");

        return Jwt.issuer("instruments-jwt")
            .subject(Long.toString(dto.id()))
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }


}