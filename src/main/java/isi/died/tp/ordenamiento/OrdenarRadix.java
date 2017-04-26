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
public class OrdenarRadix extends OrdenadorService {
    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        /*int i, exp = 1, n = arrDesordenado.tamanio();
        long m = arrDesordenado.get(0).valorOrdenamiento();
        ArregloDied b = new ArregloDied(10);

        for (i = 1; i < n; i++) {
            if (arrDesordenado.get(i).valorOrdenamiento() > m) {
                m = arrDesordenado.get(i).valorOrdenamiento();
            }
        }

        while (m / exp > 0) {
            ColaDied bucket = new ColaDied(10);

            for (i = 0; i < n; i++) {

                long pos1 = arrDesordenado.get(i).valorOrdenamiento();
                int pos = (int) pos1;
                bucket.agregarEnPosicion(pos, (bucket.get(i).valorOrdenamiento() / exp % 10));
                i++;
            }

            for (i = 1; i < 10; i++) {
               // bucket[i] =  bucket[i] + bucket[i - 1];
               
               long pos1 = arrDesordenado.get(i).valorOrdenamiento();
                int pos = (int) pos1;
               bucket.agregarEnPosicion(i,bucket.get(i).valorOrdenamiento());
               
    
               
            }
            for (i = n - 1; i >= 0; i--) {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }
            for (i = 0; i < n; i++) {
                a[i] = b[i];
            }
            exp *= 10;
        }*/
        return null;
    }
}
