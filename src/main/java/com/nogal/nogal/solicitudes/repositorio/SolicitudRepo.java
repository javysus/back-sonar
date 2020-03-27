package com.nogal.nogal.solicitudes.repositorio;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.nogal.nogal.solicitudes.modelos.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SolicitudRepo extends JpaRepository<Solicitud, Serializable>{

    Optional<Solicitud> findById(long id);
    public abstract List<Solicitud> findByTecnicoOrCliente(long tecnico, long cliente);

    public abstract List<Solicitud> findByAceptadaAdmFalse();

    @Query("SELECT s FROM Solicitud s WHERE s.aceptada_cli='true' AND s.aceptada_fecha='true' AND s.tecnico=0")
    public abstract List<Solicitud> findSolporAsignar();

    @Transactional
    void deleteById(long id);

}