package com.kinoxp.demo.config;

import com.kinoxp.demo.service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests()
    //     .antMatchers( "/css/**").permitAll()
    //     .antMatchers( "/img/**").permitAll()


    //                 .antMatchers("/admin").hasRole("ADMIN")
    //             .antMatchers("/user").hasAnyRole("ADMIN", "USER")
    //             .antMatchers("/**").permitAll()
           
    //             .and().formLogin().permitAll()
                
    //     ;

    //     http.csrf().disable();

    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/createmoviejs").hasRole("ADMIN")
                .antMatchers("/createmovie").hasRole("ADMIN")
                .antMatchers("/createemployee").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").permitAll()
                .antMatchers("/").permitAll()
                .and().formLogin();

        
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }

}
