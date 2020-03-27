package com.nogal.nogal.tecnicos.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tecnico")
public class Tecnico{
    @Id
    @Column(name="id_tecnico")
    private long id;


    @Column(name="especialidad")
    private String especialidad;

    public Tecnico(){
        
    }

    public Tecnico(long id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecialidad(){
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
}