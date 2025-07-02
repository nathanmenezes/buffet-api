package br.com.mnz.shift.entity.user;

import br.com.mnz.shift.core.exception.DontHaveCurrentUserException;
import br.com.mnz.shift.entity.BaseEntity;
import br.com.mnz.shift.entity.workspace.Workspace;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails, Serializable {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private boolean active;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    public static User currentUser() {
        Object user = Objects.requireNonNull(RequestContextHolder.getRequestAttributes())
                .getAttribute("user", RequestAttributes.SCOPE_REQUEST);
        if (user instanceof User) {
            return (User) user;
        }
        throw new DontHaveCurrentUserException("No user is currently set in the request context.");
    }

    public static void setCurrentUser(User user) {
        Objects.requireNonNull(RequestContextHolder.getRequestAttributes())
                .setAttribute("user", user, RequestAttributes.SCOPE_REQUEST);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
