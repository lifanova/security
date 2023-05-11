package ru.netology.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import ru.netology.security.service.UserCredentialsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig {
    protected final UserCredentialsService userCredentialsService;



    public WebSecurityConfig(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("Denis").password("{noop}123345").roles("READ");

        auth.userDetailsService(userCredentialsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/persons/by-city").permitAll()
                .anyRequest().authenticated();

        http.formLogin();
    }
}
