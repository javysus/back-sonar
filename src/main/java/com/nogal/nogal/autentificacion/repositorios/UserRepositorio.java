package com.nogal.nogal.autentificacion.repositorios;

import java.io.Serializable;
import java.util.Optional;

import com.nogal.nogal.autentificacion.modelos.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<User, Serializable>{
    Optional<User> findByUserName(String userName);
    Optional<User> findById(long Id);
}