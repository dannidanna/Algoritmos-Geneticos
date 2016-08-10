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
    private int gen;
    public Generacion(){
     generaciones= new ArrayList<>();
     gen=0;
    }

    public int getGen() {
        return gen;
    }
    
    public void addPopulation(Population p){
      generaciones.add(p);
      gen++;
    }
    
    public Population getMejorPopulation(){
      //getIndividualMejor()
        int auxMejor=10000;
        int mejor=0;
        int posMejor=0;
        for (int i = 0; i < getGen(); i++) {
            Population auxPop=  generaciones.get(i);
            auxMejor=auxPop.getIndividualMejor().getFitness();
            if(auxMejor<mejor){
                mejor  = auxMejor;
               posMejor= i;
            }
            
        }
        return generaciones.get(posMejor);
    }
    
}
