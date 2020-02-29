package com.s2u2.demo.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Order(WebSecurityConfig.PHONE_CODE_AUTH_ORDER)
public class PhoneCodeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.antMatcher("/login/phone")
            .authorizeRequests()
            .antMatchers("/login/phone").permitAll()
            .anyRequest().authenticated();
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //            super.configure(auth);
        auth.userDetailsService(phoneUserDetailsService());
    }

    UserDetailsService phoneUserDetailsService(){
        String code = "123456";
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("12345678").password(code).authorities("USER").build());
        return manager;
    }
}
