package com.restaurantfoodandmore.api.security.presenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtPresenter {
    @NotBlank
    private String token;
    private String bearer;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
}