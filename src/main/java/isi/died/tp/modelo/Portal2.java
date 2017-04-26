/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author st
 */
package isi.died.tp.modelo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Portal2 extends Portal {
    private ArrayList<MaterialCapacitacion> lista;

    public Portal2() {
        this.lista = new ArrayList();
    }
    
    public ArrayList<MaterialCapacitacion> listar(){
         Collections.sort(this.lista);
         return lista;
    }
            
    public Portal2(ArrayList<MaterialCapacitacion> lista) {
        this.lista = lista;
    }
    
    public void agregar(MaterialCapacitacion m){
        this.lista.add(m);
        
        super.agregarMaterial(this.lista.size()-1, m);
        
    }
    
    
}
