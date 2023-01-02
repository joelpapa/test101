package com.example.test101.config;

import com.example.test101.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    MemberService memberService;



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/members/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .usernameParameter("memberid")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutUrl("/members/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))

        ;

        http.authorizeHttpRequests((requests) ->requests
                .requestMatchers("/css/**", "/js/**", "/img/**", "/fragments/**", "/layouts/**").permitAll()
                .requestMatchers("/", "/members/**", "/item/**", "/images/**", "/board/**", "/category/**").permitAll()
//                .requestMatchers("/board/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated())
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


