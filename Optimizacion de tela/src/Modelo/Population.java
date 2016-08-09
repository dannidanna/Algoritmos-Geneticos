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
  public Population(){
  individuos = new ArrayList<>();
  
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
            individuos.add(individual);
        }
        return this;
    }
    public Individual getIndividualMejor(){
    return null;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public int cantIndividual(){
     return individuos.size();
    }

    public ArrayList<Individual> getIndividuos() {
        return individuos;
    }

   
    
}
