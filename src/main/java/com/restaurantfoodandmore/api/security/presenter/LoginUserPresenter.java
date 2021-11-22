package com.restaurantfoodandmore.api.security.presenter;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class LoginUserPresenter {
    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    private String password;
}