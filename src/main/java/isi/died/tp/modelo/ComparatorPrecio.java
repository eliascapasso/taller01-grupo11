/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.Comparator;

/**
 *
 * @author usser
 */
public class ComparatorPrecio implements Comparator<MaterialCapacitacion>{

    @Override
    public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
        if(o1.precio().intValue() == o2.precio().intValue()){
            return 0;
        }else if(o1.precio().intValue() < o2.precio().intValue()){
            return -1;
        }else {
            return 1;
        }
    }
     
}
