package com.restaurantfoodandmore.api.security.service.imp;

import com.restaurantfoodandmore.api.security.entity.PrimaryUser;
import com.restaurantfoodandmore.api.security.entity.User;
import com.restaurantfoodandmore.api.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get();
        return PrimaryUser.build(user);
    }
}
