/*
 * esta clase almacena todas la generaciones, en nuestro caso 
* alamcena todas la posibles fomras que se genero desde
* el inicio, hasta la optima.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public class Generacion {
    private ArrayList<Population> generaciones;
    public Generacion(){
     generaciones= new ArrayList<>();
    }
    public void addPopulation(Population p){
      generaciones.add(p);
    }
    
}
