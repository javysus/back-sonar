package com.nogal.nogal.tecnicos.repositorio;

import java.io.Serializable;
import java.util.Optional;
import java.util.List;

import com.nogal.nogal.tecnicos.modelos.Tecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepo extends JpaRepository<Tecnico, Serializable>{
    Optional<Tecnico> findById(long id);
    public abstract List<Tecnico> findByEspecialidad(String especialidad);
}