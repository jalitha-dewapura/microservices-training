package com.jalitha.rentcloud.authorizationserver.service;

import com.jalitha.rentcloud.authorizationserver.model.AuthUserDetail;
import com.jalitha.rentcloud.authorizationserver.model.User;
import com.jalitha.rentcloud.authorizationserver.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailsRepository.findByUsername(username);

        optionalUser.orElseThrow( ()-> new UsernameNotFoundException("Username or password is not valid"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }


}
