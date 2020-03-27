package com.nogal.nogal.autentificacion.servicios;

import java.util.Optional;

import com.nogal.nogal.autentificacion.modelos.AuthenticationRequest;
import com.nogal.nogal.autentificacion.modelos.MyUserDetails;
import com.nogal.nogal.autentificacion.modelos.User;
import com.nogal.nogal.autentificacion.repositorios.UserRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServicio implements UserDetailsService{
    
    @Autowired
    UserRepositorio repositorio;
    
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Optional<User> user = repositorio.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("No se encontro a: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    public Boolean crear(final AuthenticationRequest request) {
        final User usuario = new User();
        usuario.setUserName(request.getUsername());
        usuario.setPassword(request.getPassword());
        try {
            repositorio.save(usuario);
            return true;
        } catch (final Exception e) {
            return false;
        }
    }
}