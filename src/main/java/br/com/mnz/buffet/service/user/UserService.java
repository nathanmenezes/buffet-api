package br.com.mnz.buffet.service.user;

import br.com.mnz.buffet.dto.response.user.AccountResponse;
import br.com.mnz.buffet.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    public AccountResponse getCurrentAccount() {
        log.info("Fetching current user account details");
        User currentUser = User.currentUser();
        return new AccountResponse(currentUser);
    }
}
