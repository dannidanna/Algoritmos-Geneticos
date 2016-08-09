/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public class AlgorithmG {
 private static final double  mutation_chance=0.2;
 private static final int pressure=3;
 private static final int cant_individuos=5;
 private Population population;
    /**
     * este metodo recibe todos los objetos introducidos 
     * ya sea piezas o el material, para luego formar una poblacion inicial
     * @param obs  es una lista de objetos p
     * @return retorna una plano inicial
     */
 
 
     public  Population inicialPopulation(ArrayList<Objeto> obs) {
         Population populat=null;
         Material material=getMaterial(obs);
         populat= population.generatePopulation(material, obs,cant_individuos);
         
        return populat;
     }
     
     
 
     
     
     
     /**
      * es para obtener la tela que sera cortado o su caso marcado
      * @param obs es una lista donde estan las [piesas y la tela
      * @return 
      */
     private Material getMaterial(ArrayList<Objeto> obs){
         boolean bandera = false;
         Material material=null;
      int i=0;
        while (!bandera&&i<obs.size()) {            
            Objeto objeto = obs.get(i);
            if(objeto instanceof Material){
              material= (Material)obs.remove(i);
             bandera=true;
            }
            i++;
        }
        return material;
     }
 
    
    /**
      * este metodo mustra la nueva evolucion
      * @param pop
      * @return 
      */
    public Population evolvePopulation(Population pop) {
         for (int i = 0; i < cant_individuos; i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
           
        }
             // Mutate population
//        for (int i = cant_individuos; i < newPopulation.size(); i++) {
//            mutate(newPopulation.getIndividual(i));
//        }
//
//        return newPopulation;

       
        return null;
    }
  // Crossover individuals, es para cruzar individuos, este caso puede ser piezas
    private  Individual crossover(Individual indiv1, Individual indiv2) {
      return null;
    }
        // Mutate an individual
    private  void mutate(Individual indiv) {
        // Loop through genes
        //el limite 10 debe ser sustituido por el tamanio de individus
        for (int i = 0; i < 10; i++) {
            if (Math.random() <= mutation_chance) {
                // Create random gene
               
            }
        }
    }

    // selecciona individuos para el cruce
    private  Individual tournamentSelection(Population pop) {
       return null;
    }
    
}
