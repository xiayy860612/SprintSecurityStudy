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
@Order(WebSecurityConfig.USERNAME_PASSWORD_AUTH_ORDER)
public class UsernamePasswordSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.antMatcher("/accounts/username/*")
            .authorizeRequests()
            .antMatchers("/accounts/username/login").permitAll()
            .anyRequest().authenticated();
        http.httpBasic();
    }

    /**
     * SecurityFilterChain Authentication config
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //            super.configure(auth);
        auth.userDetailsService(usernameUserDetailsService());
    }

    UserDetailsService usernameUserDetailsService(){
        String finalPassword = "123456";
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("test").password(finalPassword).authorities("ROLE_USER").build());
        return manager;
    }
}
