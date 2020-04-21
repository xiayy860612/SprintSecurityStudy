package com.s2u2.demo.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(WebSecurityConfig.LATEST_GLOBAL_AUTH_ORDER)
public class GlobalSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/error", "/login").permitAll()
            .antMatchers("/cn").hasRole("USER")
            .anyRequest().authenticated();

        http.logout()
            .logoutUrl("/logout").permitAll()
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID");
    }
}
