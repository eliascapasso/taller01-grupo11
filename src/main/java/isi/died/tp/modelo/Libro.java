/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;
    
    public Libro() {
    }
    
    public Libro(String titulo, Double costo, String iSBN, Integer paginas){
        super(titulo);
        this.costo = costo;
        this.isbn = iSBN;
        this.paginas = paginas;
        super.estado = EstadoPromocion.ACCESO_TEMPRANO;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }
    @Override
    public boolean equals(Object l){
        if(l instanceof Libro){
            return ((Libro)l).titulo.equalsIgnoreCase(this.titulo);
        }
        return false;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
        
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }
    
    
    @Override
    public void publicar(String f){
        super.publicar(f);
        this.estado = EstadoPromocion.LANZAMIENTO;
        
    }
    
    @Override
    public Double precio(){        
        switch(this.estado){
            case REGULAR:
                
                return (getCosto() + getCosto()*(this.paginas/150)*0.03);
                
            case ACCESO_TEMPRANO:
                
                return (getCosto() + getCosto()*(this.paginas/150)*0.03)*0.9;
            
            case LANZAMIENTO:
                
                return (getCosto() + getCosto()*(this.paginas/150)*0.03)*1.2;
                
            case OFERTA:
                
                return getCosto()*0.8;
        }
        
        return 0.0;       
    }
    
    @Override
    public void suscribir(){
        super.suscribir();
        if(suscripciones() > 1){
            this.estado = EstadoPromocion.REGULAR;
        }
    }
    
    @Override
    public void liquidar() {
          super.estado = EstadoPromocion.OFERTA;
    }



    
    
}