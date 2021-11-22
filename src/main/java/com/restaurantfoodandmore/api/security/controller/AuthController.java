package com.restaurantfoodandmore.api.security.controller;

import com.restaurantfoodandmore.api.security.jwt.JwtProvider;
import com.restaurantfoodandmore.api.security.presenter.JwtPresenter;
import com.restaurantfoodandmore.api.security.presenter.LoginUserPresenter;
import com.restaurantfoodandmore.api.security.service.AuthenticationService;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/api")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public JwtPresenter login(@Valid @RequestBody LoginUserPresenter loginUserPresenter) {
        return authenticationService.login(loginUserPresenter);
    }
}
