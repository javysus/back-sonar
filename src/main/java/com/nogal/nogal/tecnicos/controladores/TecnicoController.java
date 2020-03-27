package com.nogal.nogal.tecnicos.controladores;

import java.util.List;

import com.nogal.nogal.autentificacion.util.JwtUtil;
import com.nogal.nogal.tecnicos.modelos.Tecnico;
import com.nogal.nogal.tecnicos.servicio.TecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TecnicoController{
    @Autowired
    TecnicoService servicio;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/crearTecnico")
    public boolean crearTecnico(@RequestBody @PathVariable Tecnico tecnico){
        return servicio.crear(tecnico);
    }

    @GetMapping("/tecnicosEspecialidad/{especialidad}")
    public List<Tecnico> obtenerTecnicos(@RequestHeader("Authorization") @PathVariable("especialidad") String especialidad){
        return servicio.obtenerPorEspecialidad(especialidad);
    }
}