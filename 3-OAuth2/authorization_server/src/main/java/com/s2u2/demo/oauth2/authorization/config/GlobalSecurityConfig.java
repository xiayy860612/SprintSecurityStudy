package com.s2u2.demo.oauth2.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//            .antMatchers("/error", "/login", "/login/*", "/oauth/*").permitAll()
//            .anyRequest().authenticated();
//
//        http.logout()
//            .logoutUrl("/logout").permitAll()
//            .logoutSuccessUrl("/")
//            .invalidateHttpSession(true)
//            .clearAuthentication(true)
//            .deleteCookies("JSESSIONID");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("test")
//            .password("123456")
//            .authorities("USER");
//    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();
        var user = User.builder()
            .username("test")
            .password("123456")
            .authorities("USER")
            .build();
        manager.createUser(user);
        return manager;
    }
}
