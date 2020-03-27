package com.nogal.nogal.autentificacion.servicios;

import java.util.Optional;

import com.nogal.nogal.autentificacion.modelos.User;
import com.nogal.nogal.autentificacion.repositorios.UserRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicio{

    @Autowired
    UserRepositorio repositorio;

    public User obtenerNombre(String nombre){
        Optional<User> user = repositorio.findByUserName(nombre);

        user.orElse(null);
        return user.get();
    }

    public String obtenerUser(long id){
        Optional<User> user = repositorio.findById(id);
        
        user.orElse(null);
        return user.get().getUserName();
    }

    public String obtenerRol(long id){
        Optional<User> user = repositorio.findById(id);
        
        user.orElse(null);
        return user.get().getRoles();
    }

    public long crear(User usuario){
        try{
            repositorio.save(usuario);
            return usuario.getId();
        } catch (Exception e){
            return 0;
        }
    }

}