package com.certus.yvencrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/principal", "/home", "/inicio", "/logeo", "/login", "/rest/**")
                .permitAll()
                .antMatchers("/eventos/eventList").hasAnyRole("ADMIN", "LECTOR", "CREADOR", "EDITOR", "DEPURADOR")
                .antMatchers("/eventos/eventNew").hasAnyRole("ADMIN", "CREADOR")
                .antMatchers("/eventos/guardar").hasAnyRole("ADMIN", "CREADOR", "EDITOR")
                .antMatchers("/eventos/actualizar/**").hasAnyRole("ADMIN", "EDITOR")
                .antMatchers("/eventos/eliminar/**").hasAnyRole("ADMIN", "DEPURADOR")
                .antMatchers("/personas/personList").hasAnyRole("ADMIN", "LECTOR", "CREADOR", "EDITOR", "DEPURADOR")
                .antMatchers("/personas/personNew").hasAnyRole("ADMIN", "CREADOR")
                .antMatchers("/personas/guardar").hasAnyRole("ADMIN", "CREADOR", "EDITOR")
                .antMatchers("/personas/actualizar/**").hasAnyRole("ADMIN", "EDITOR")
                .antMatchers("/personas/eliminar/**").hasAnyRole("ADMIN", "DEPURADOR")
                .antMatchers("/tarjetas/cardList").hasAnyRole("ADMIN", "LECTOR", "CREADOR", "EDITOR", "DEPURADOR")
                .antMatchers("/tarjetas/cardNew").hasAnyRole("ADMIN", "CREADOR")
                .antMatchers("/tarjetas/guardar").hasAnyRole("ADMIN", "CREADOR", "EDITOR")
                .antMatchers("/tarjetas/actualizar/**").hasAnyRole("ADMIN", "EDITOR")
                .antMatchers("/tarjetas/eliminar/**").hasAnyRole("ADMIN", "DEPURADOR")
                .antMatchers("/usuarios/userList").hasAnyRole("ADMIN", "LECTOR", "CREADOR", "EDITOR", "DEPURADOR")
                .antMatchers("/usuarios/userNew").hasAnyRole("ADMIN", "CREADOR")
                .antMatchers("/usuarios/guardar").hasAnyRole("ADMIN", "CREADOR", "EDITOR")
                .antMatchers("/usuarios/actualizar/**").hasAnyRole("ADMIN", "EDITOR")
                .antMatchers("/usuarios/eliminar/**").hasAnyRole("ADMIN", "DEPURADOR")


                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
                .and().logout()
                .permitAll();
    }
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            auth.inMemoryAuthentication()
                    .withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
                    .withUser("alessandro").password(encoder.encode("alessandro")).roles("LECTOR").and()
                    .withUser("dayne").password(encoder.encode("dayne")).roles("LECTOR","CREADOR").and()
                    .withUser("geraldo").password(encoder.encode("geraldo")).roles("LECTOR","DEPURADOR").and()
                    .withUser("anyperson").password(encoder.encode("anyperson")).roles("LECTOR","EDITOR");

        }

    }