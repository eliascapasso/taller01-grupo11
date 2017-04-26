/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author mdominguez
 */
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        if(arregloOrdenado.tamanio() <= 1){
            return arregloOrdenado;
        }
        else{
            int centro = arregloOrdenado.tamanio()/2;
            ArregloDied izq = new ArregloDied(centro);
            ArregloDied der = new ArregloDied((arregloOrdenado.tamanio() - centro));
            for (int i = 0; i < centro; i++) {
                izq.agregarEnPosicion(i, arregloOrdenado.get(i));

            }
            for (int i = centro; i < arregloOrdenado.tamanio(); i++) {
                der.agregarEnPosicion(i, arregloOrdenado.get(i));
            }
        return mezclar(ordenar (izq) , ordenar(der));
        
        }
        
    }
    
    private ArregloDied mezclar(ArregloDied izq, ArregloDied der){
            
            int tam = izq.tamanio() + der.tamanio();
            int tope = 0;
            ArregloDied intercambiar = new ArregloDied(tam);
            int i = 0, d = 0;
                
                while(d < der.tamanio() && i < izq.tamanio() ){
                   
                        if(der.get(d).valorOrdenamiento() <= izq.get(i).valorOrdenamiento()){
                        intercambiar.agregarEnPosicion(tope, der.get(d));
                        tope++;
                        d++;
                        }
                        else{
                        intercambiar.agregarEnPosicion(tope, izq.get(i));
                        tope++;
                        i++;
                        }
                }
                if(d == der.tamanio()){
                    while(i < izq.tamanio()){
                    intercambiar.agregarEnPosicion(tope, izq.get(i));
                    tope++;
                    i++;
                    }        
                }
                else{
                    while(d < der.tamanio()){
                    intercambiar.agregarEnPosicion(tope, der.get(d));
                    tope++;
                    d++;
                    }  
                    
                }
                return intercambiar;    
    }
}
