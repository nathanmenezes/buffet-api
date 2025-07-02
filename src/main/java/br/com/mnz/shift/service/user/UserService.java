package br.com.mnz.shift.service.user;

import br.com.mnz.shift.dto.response.user.AccountResponse;
import br.com.mnz.shift.entity.user.User;
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
