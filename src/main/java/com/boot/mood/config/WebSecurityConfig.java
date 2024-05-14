package com.boot.mood.config;

import com.boot.mood.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig{

    private final UserDetailService userService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/login", "/newUser", "/user").permitAll()
//                                .anyRequest().authenticated()
//                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/boardList")
                                .usernameParameter("uid")
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login")
                                .invalidateHttpSession(true)
                )
                .csrf(AbstractHttpConfigurer::disable);


        return http.build();
    }

    public AuthenticationManager authenticationManager() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



}