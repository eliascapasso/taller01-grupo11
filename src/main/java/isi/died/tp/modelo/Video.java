/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.Date;

/**
 *
 * @author st
 */
public class Video extends MaterialCapacitacion {

    private Double duracion;
    private Double costo;

    public Video() {
        this.estado = EstadoPromocion.REGULAR;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public EstadoPromocion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPromocion estado) {
        this.estado = estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Video(String titulo, Double duracion, Double costo) {
        super(titulo);
        this.estado = EstadoPromocion.REGULAR;

        this.duracion = duracion;
        this.costo = costo;
    }

    public Video(Double duracion, Double costo, String titulo) {
        super(titulo);
        this.estado = EstadoPromocion.REGULAR;
        this.duracion = duracion;
        this.costo = costo;
    }
    
    @Override
    public boolean equals(Object v){
        if(v instanceof Video){
            return ((Video)v).titulo.equalsIgnoreCase(this.titulo);
        }
        return false;
    }
    
    @Override
    public void publicar(String f){
        super.publicar(f);
        this.estado = EstadoPromocion.REGULAR;
    }
    
    @Override
    public Double precio() {
        switch (this.estado) {
            case REGULAR:

                return (getCosto() * this.duracion);

            case OFERTA:

                return getCosto() * 0.5;
        }

        return 0.0;
    }

    @Override
    public void suscribir() {
        super.suscribir();
        if (suscripciones() > 1) {
            this.estado = EstadoPromocion.REGULAR;
        }
    }

    @Override
    public void liquidar() {
        super.estado = EstadoPromocion.OFERTA;
    }

}
