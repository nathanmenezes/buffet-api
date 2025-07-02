package br.com.mnz.shift.service.auth;

import br.com.mnz.shift.dto.request.auth.LoginRequest;
import br.com.mnz.shift.dto.response.auth.LoginResponse;
import br.com.mnz.shift.core.exception.EntityNotFoundException;
import br.com.mnz.shift.entity.user.User;
import br.com.mnz.shift.repository.user.UserRepository;
import br.com.mnz.shift.security.service.JWTService;
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
