package com.restaurantfoodandmore.api.security.service;

import com.restaurantfoodandmore.api.security.presenter.JwtPresenter;
import com.restaurantfoodandmore.api.security.presenter.LoginUserPresenter;

public interface AuthenticationService {
    JwtPresenter login(LoginUserPresenter userLogin);
}
