/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.Ordenable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable, Comparable<MaterialCapacitacion>{
    protected String titulo;
    protected EstadoPromocion estado;
    protected Date fechaPublicacion;
    private Integer suscripciones;

    public MaterialCapacitacion() {
        this.suscripciones=0;
    }       

    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
    } 
       
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }  
    
    @Override
    public boolean equals(Object m){
        if(m instanceof MaterialCapacitacion){
            return ((MaterialCapacitacion)m).titulo.equalsIgnoreCase(this.titulo);
        }
        return false;
    }
    
    protected Integer suscripciones(){
        return this.suscripciones;
    }
   
    public void publicar(){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = new Date();
    }
   
    public void publicar(String f){
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        GregorianCalendar dias45 = new GregorianCalendar();
        GregorianCalendar hoy = new GregorianCalendar();
        try {
            hoy.setTime(formato.parse(f));
            dias45.add(GregorianCalendar.DAY_OF_YEAR, -45);
            if(hoy.after(dias45) && (hoy.get(GregorianCalendar.DAY_OF_WEEK)>0 && hoy.get(GregorianCalendar.DAY_OF_WEEK)<6)){   
                
                this.fechaPublicacion = formato.parse(f);
                
            }
            else{
             
                this.fechaPublicacion = fecha;
            }
        }
        catch (ParseException e){
            System.out.println("Ocurrio un error en verificar la fecha");
        }
    }
    
    public abstract Double precio();

    public abstract void liquidar();
    
    public void suscribir(){
        this.suscripciones++;
    }
    
    public void cancelarSuscripcion(){
        this.suscripciones--;
    }
    
     private Long numerarString(String arg) {
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar;
        for (int i = 0; i < 4; i++) {
            Integer aux;
            if (i > origen.length() - 1) {
                aux = 37;
            } else {
                unChar = origen.charAt(i);
                if (unChar >= 'A' && unChar <= 'Z') {
                    aux = unChar - 54;
                } else {
                    aux = 38;
                }
            }
            resultado += aux;
        }
        return Long.valueOf(resultado);
    }

    @Override
    public Long valorOrdenamiento() {
        return Long.valueOf(numerarString(this.titulo) + "" + formatoPrecio(this.precio()));
    }

    private Long formatoPrecio(Double precio) {
        Long precioEntero = Math.round(precio);
        Long x = precioEntero % 10000;
        Long formato = 10000 + x;
        return formato;
    }
    
     final String fechaPublicacion(){
         
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         
         return formato.format(this.fechaPublicacion);
     }
     
    @Override
     public int compareTo(MaterialCapacitacion m){
         int comp = this.titulo.compareTo(m.titulo);
         if(comp < 0){
             return -1;
         }
         else if(comp > 0){
             return 1;
         }
         else{
             int comp2 = this.fechaPublicacion.compareTo(m.fechaPublicacion);
                if(comp2 < 0){
                    return -1;
                }
                else{
                    return 1;
                }
         }
        
     }
     
   }

    