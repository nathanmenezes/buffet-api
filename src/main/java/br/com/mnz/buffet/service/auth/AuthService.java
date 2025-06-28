package br.com.mnz.buffet.service.auth;

import br.com.mnz.buffet.dto.request.auth.LoginRequest;
import br.com.mnz.buffet.dto.response.auth.LoginResponse;
import br.com.mnz.buffet.core.exception.EntityNotFoundException;
import br.com.mnz.buffet.entity.user.User;
import br.com.mnz.buffet.repository.user.UserRepository;
import br.com.mnz.buffet.security.service.JWTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {
        log.debug("Logging in user {}", request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        String token = jwtService.generateToken(user);
        return new LoginResponse(token);
    }
}
