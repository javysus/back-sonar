package com.nogal.nogal.autentificacion.configuracion;

import com.nogal.nogal.autentificacion.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    UserDetailsService servicio;

    @Autowired
    JwtRequestFilter filter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(servicio).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/autentificar").permitAll()
            .antMatchers("/crear").permitAll()
            .antMatchers("/crearTecnico").permitAll()
            .antMatchers("/obtenerID/**").permitAll()
            .antMatchers("/obtenerUser/**").permitAll()
            .antMatchers("/obtenerRol/**").permitAll()
            .antMatchers("/asignarTecnicos").permitAll()
            .antMatchers("/solicitudesAdmin").permitAll()
            .antMatchers("/actualizarsolicitud").permitAll()
            .antMatchers("/tecnicosEspecialidad/**").permitAll()
            .antMatchers("/crearsolicitud").access("hasRole('USER')")
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // no crear una sesion
        // usa nuestro filtro antes que el de spring security
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class); 
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}