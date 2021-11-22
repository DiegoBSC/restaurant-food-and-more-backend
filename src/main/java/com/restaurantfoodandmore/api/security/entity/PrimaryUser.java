package com.restaurantfoodandmore.api.security.entity;

import com.restaurantfoodandmore.api.enums.EnumStatusGeneral;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
public class PrimaryUser implements UserDetails {

    private String username;
    private String email;
    private String password;
    private EnumStatusGeneral status;
    private Collection<? extends GrantedAuthority> authorities;

    public static PrimaryUser build( User user){
        List<GrantedAuthority> authorities =
                user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(
                        rol.getName())).collect(Collectors.toList());
        return PrimaryUser.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public EnumStatusGeneral getStatus() {
        return status;
    }
}