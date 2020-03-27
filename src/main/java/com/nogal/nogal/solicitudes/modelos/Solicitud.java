package com.nogal.nogal.solicitudes.modelos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solicitud")
public class Solicitud{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_solicitud")
    private long id;

    @Column(name="id_tecnico")
    private long tecnico;

    @Column(name="id_usuario", updatable=false)
    private long cliente;

    @Column(name="monto")
    private long monto;

    @Column(name="direccion", updatable=false)
    private String direccion;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name="latitud", updatable=false)
    private float latitud;

    @Column(name="longitud", updatable=false)
    private float longitud;

    @Column(name="asunto", updatable=false)
    private String asunto;

    @Column(name="categoria", updatable=false)
    private String categoria;

    @Column(name="descripcion", updatable=false)
    private String descripcion;
    
    @Column(name="aceptada_cli")
    private boolean aceptadaCli = false;

    @Column(name="aceptada_fecha")
    private boolean aceptadaFecha = false;

    @Column(name = "aceptada_adm")
    private boolean aceptadaAdm = false;

    @Column(name = "aceptada_tec")
    private boolean aceptadaTec = false;

    public Solicitud() {

    }

    public Solicitud(long id, long tecnico, long cliente, long monto, String direccion, Date fecha, String asunto, String categoria, 
            String descripcion, float latitud, float longitud,
            boolean aceptadaCli, boolean aceptadaFecha, boolean aceptadaAdm, boolean aceptadaTec) {
        this.id = id;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.monto = monto;
        this.direccion = direccion;
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.asunto = asunto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.aceptadaCli = aceptadaCli;
        this.aceptadaFecha = aceptadaFecha;
        this.aceptadaAdm = aceptadaAdm;
        this.aceptadaTec = aceptadaTec;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(long tecnico) {
        this.tecnico = tecnico;
    }

    public long getCliente() {
        return this.cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public boolean isAceptadaCli() {
        return aceptadaCli;
    }

    public void setAceptadaCli(boolean aceptadaCli){
        this.aceptadaCli = aceptadaCli;
    }

    public boolean isAceptadaFecha() {
        return this.aceptadaFecha;
    }

    public void setAceptadaFecha(boolean aceptadaFecha) {
        this.aceptadaFecha = aceptadaFecha;
    }
    
    public boolean isAceptadaAdm() {
        return aceptadaAdm;
    }

    public void setAceptadaAdm(boolean aceptadaAdm){
        this.aceptadaAdm= aceptadaAdm;
    }

    public boolean isAceptadaTec() {
		return aceptadaTec;
    }

    public void setAceptadaTec(boolean aceptadaTec){
        this.aceptadaTec = aceptadaTec;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

