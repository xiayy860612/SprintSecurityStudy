package com.s2u2.demo.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Order(WebSecurityConfig.PHONE_CODE_AUTH_ORDER)
public class PhoneCodeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.antMatcher("/accounts/phone/*")
            .authorizeRequests()
            .antMatchers("/accounts/phone/login").permitAll()
            .anyRequest().authenticated();
        http.httpBasic();
    }

    /**
     * SecurityFilterChain Authentication config
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //            super.configure(auth);
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    private DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(phoneUserDetailsService());
        return provider;
    }

    UserDetailsService phoneUserDetailsService(){
        String code = "123456";
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("12345678").password(code).authorities("ROLE_USER").build());
        return manager;
    }
}
