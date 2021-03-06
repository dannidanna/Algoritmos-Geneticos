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
public class Population {

  private ArrayList<Individual> individuos;
  private boolean selected;
  private String name;
  public Population(){
  individuos = new ArrayList<>();
  name = ""; 
  selected = false;
  
  }

    Population(ArrayList<Individual> newInd) {
      individuos = newInd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int cantIndividual(){
     return individuos.size();
    }
   /**
    * retorna todo los individuos en este caso los posibles
    * formas de acomodar las piezas
    * @return 
    */
    public ArrayList<Individual> getIndividuos() {
        return individuos;
    }
    
/**
 * este metodo genera una poblacion inicial
 * @param material
 * @param obs
 * @param cant_individuos
 * @return 
 */
    public Population generatePopulation(Material material, ArrayList<Objeto> obs, int cant_individuos) {
         
        for (int i = 0; i < cant_individuos; i++) {
            Individual individual = new Individual(material.getAlto(),material.getAncho());
            
            individual.setObj_pieces(obs);
            individual.generateIndividual();
            individual.setName("individual"+i);
            //System.out.println("Fitness individual "+i+": "+individual.getFitness());
            individual.getFitness();
                        
            individuos.add(individual);
         
        }
        return this;
    }
    public Individual getIndividualMejor(){
        int aux_fitness=0;
        int fitness_mejor=10000;
        int pos_mejor=0;
        for (int i = 0; i < individuos.size(); i++) {
            Individual auxInd= individuos.get(i);
            aux_fitness =  auxInd.getFitness();
            if(aux_fitness<fitness_mejor)
            {
             pos_mejor = i;
             fitness_mejor= aux_fitness;
            }
        }
        return individuos.get(pos_mejor);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * aniade nuevos individuos
     * @param newInd 
     */
    public void addIndividual(Individual newInd){
        individuos.add(newInd);
    }

    public boolean isSelected() {
        return selected;
    }
    

   
    
}
