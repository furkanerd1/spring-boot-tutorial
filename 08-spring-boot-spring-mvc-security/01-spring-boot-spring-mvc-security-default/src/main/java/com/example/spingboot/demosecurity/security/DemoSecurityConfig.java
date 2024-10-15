package com.example.spingboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    //For the custom tables
    @Bean
     public UserDetailsManager userDetailsManager(DataSource dataSource) {
         JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

         userDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

         userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");

         return   userDetailsManager;
     }


    @Bean
     public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(c ->
              c.requestMatchers("/").hasRole("EMPLOYEE")
                      .requestMatchers("/leaders/**").hasRole("MANAGER")
                      .requestMatchers("/systems/**").hasRole("ADMIN")
                      .anyRequest().authenticated()
                )

                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()

                ).logout(logout -> logout.permitAll())
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/acces-denied")
                );


        return http.build();
     }
}

/*
//Basic Configuration
@Bean
public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

    UserDetails john = User.builder()
            .username("john")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build();


    UserDetails mary = User.builder()
            .username("mary")
            .password("{noop}test123")
            .roles("EMPLOYEE", "MANAGER")
            .build();

    UserDetails susan = User.builder()
            .username("susan")
            .password("{noop}test123")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build();

    return new InMemoryUserDetailsManager(john, mary, susan);
}
*/
