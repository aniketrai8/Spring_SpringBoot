package com.example.bankts.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity

public class BankSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth-> auth.requestMatchers("/swagger-ui/**",
                        "/v3/api-docs/**" ).permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/**")
                        .hasAnyRole("Banker","Customer")
                        .requestMatchers(HttpMethod.POST,"/api/**")
                        .hasRole("Banker")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean

            public UserDetailsService userDetailService (){

    UserDetails customer = User
            .withUsername("customer")
            .password(passwordEncoder().encode("customer"))
            .roles("CUSTOMER")
            .build();

    UserDetails banker = User
            .withUsername("Banker")
            .password(passwordEncoder().encode("Banker"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(customer, banker);
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
}



