package com.s2u2.demo.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class WebSecurityConfig  {
    private static final int CUSTOM_AUTH_ORDER_BASIC = SecurityProperties.BASIC_AUTH_ORDER - 30;
    public static final int USERNAME_PASSWORD_AUTH_ORDER = CUSTOM_AUTH_ORDER_BASIC + 1;
    public static final int PHONE_CODE_AUTH_ORDER = CUSTOM_AUTH_ORDER_BASIC + 2;

    public static final int LATEST_GLOBAL_AUTH_ORDER = CUSTOM_AUTH_ORDER_BASIC + 29;

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Global Authentication Manager Config
     */
//    @Autowired
//    public void initialize(AuthenticationManagerBuilder builder, DataSource dataSource) {
//    }
}
