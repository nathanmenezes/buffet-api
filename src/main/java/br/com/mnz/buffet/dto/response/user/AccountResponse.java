package br.com.mnz.buffet.dto.response.user;

import br.com.mnz.buffet.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phone;
    private boolean active;

    public AccountResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.fullName = user.getFirstName() + (StringUtils.isNotBlank(user.getLastName()) ? " " + user.getLastName() : "");
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.active = user.isActive();
    }
}
