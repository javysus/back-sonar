package com.nogal.nogal.solicitudes.controladores;

import java.util.List;

import javax.validation.Valid;

import com.nogal.nogal.autentificacion.util.JwtUtil;
import com.nogal.nogal.solicitudes.modelos.Solicitud;
import com.nogal.nogal.solicitudes.servicio.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class SolicitudController{
    @Autowired
    SolicitudService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/crearsolicitud")
    public boolean crear(@RequestHeader("Authorization") @RequestBody @Valid @PathVariable Solicitud solicitud){
        return servicio.crear(solicitud);
    }

    @GetMapping("/solicitudes/{token}")
    public List<Solicitud> obtenerId(@RequestHeader("Authorization") @PathVariable("token") String token){
        long id = jwtUtil.extractId(token);

        return servicio.obtenerAllId(id);
    }

    @GetMapping("/solicitudesAdmin")
    public List<Solicitud> obtenerSolAdmin(){
        return servicio.obtenerAllAdmin();
    }

    @GetMapping("/asignarTecnicos")
    public List<Solicitud> obtenerSolicitudesSinTecnico(){
        return servicio.solicitudesSinTecnico();
    }

    @PutMapping("/actualizarsolicitud")
    public boolean actualizarSol(@RequestHeader("Authorization") @RequestBody @Valid @PathVariable Solicitud solicitud){
        return servicio.actualizar(solicitud);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSol(@RequestHeader("Authorization") @PathVariable("id") long id) {
        servicio.eliminar(id);
    }


}