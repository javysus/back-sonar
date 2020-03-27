package com.nogal.nogal.solicitudes.servicio;

import java.util.List;

import com.nogal.nogal.solicitudes.modelos.Solicitud;
import com.nogal.nogal.solicitudes.repositorio.SolicitudRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService{
    @Autowired
    SolicitudRepo repositorio;

    public boolean crear(Solicitud sol){
        try{
            repositorio.save(sol);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean actualizar(Solicitud sol){
        try{
            repositorio.save(sol);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public List<Solicitud> obtenerAllId(long id){
        return repositorio.findByTecnicoOrCliente(id, id);
    }

    public List<Solicitud> obtenerAllAdmin(){
        return repositorio.findByAceptadaAdmFalse();
    }

    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    public List<Solicitud> solicitudesSinTecnico(){
        return repositorio.findSolporAsignar();
    }
}