package br.com.mnz.buffet.resource.user;

import br.com.mnz.buffet.dto.response.user.AccountResponse;
import br.com.mnz.buffet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/resource/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/account")
    public ResponseEntity<AccountResponse> getUserAccount() {
        return ResponseEntity.ok(userService.getCurrentAccount());
    }
}
