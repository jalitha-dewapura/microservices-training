package com.jalitha.rentcloud.auth.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("jalitha").password(passwordEncoder.encode("j123")).roles("ADMIN", "MANAGER", "USER").authorities("CAN_WRITE", "CAN_DELETE", "CAN_READ").and()
                .withUser("nimal").password(passwordEncoder.encode("n123")).roles("USER").authorities("CAN_WRITE", "CAN_READ");
    }
}
