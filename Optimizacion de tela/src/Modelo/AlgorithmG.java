/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author santiago
 */
public class AlgorithmG {
 private static final double  mutation_chance=0.2;
 private static final double pressure=3;
 
  /* Public metodos */
    
    // Retorna la poblacino evolucionada
    public  Population evolvePopulation(Population pop) {
       
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
