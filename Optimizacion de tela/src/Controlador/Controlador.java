/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlgorithmG;
import Modelo.Generacion;
import Modelo.Individual;
import Modelo.Material;
import Modelo.Objeto;
import Modelo.Population;
import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public class Controlador 
{
    public static Controlador control;
    public Population population;
    public AlgorithmG algorithmG;
    //private int cant_individuos=6;
    private Generacion generacion;
    
    public static Controlador getControlador()
    {
        if( control == null )
        {
            control = new Controlador();
        }
        return control;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public void setAlgorithmG(AlgorithmG algorithmG) {
        this.algorithmG = algorithmG;
    }

    public void setGeneracion(Generacion generacion) {
        this.generacion = generacion;
    }
    
    
    /**
     * este metodo retorna una plano de piezas acomodas
     * a un inicio
     *  
     * @param obs
     * @return 
     */
    public Individual inicio(ArrayList<Objeto> obs){
        Population pop =  algorithmG.inicialPopulation(obs);
        generacion.addPopulation(pop);
     return pop.getIndividualMejor();//retorna el mejor individuo
    }
    /**
     * 
     * @return 
     */
    public  Individual getInicio(){
    ArrayList<Population> gens =  new ArrayList<>();
    Population popIni = gens.get(0);
    return popIni.getIndividualMejor();
    }
    
    public Population getMejorPopulation(){
      return generacion.getMejorPopulation();
    }
    /**
     * este metodo retorna las piezas mejor acomodadas, cuando presionamos siguiente.
     * @return 
     */
    public Individual optimizar(){
        Population newPop = algorithmG.evolvePopulation(getMejorPopulation());
        generacion.addPopulation(newPop);
        return newPop.getIndividualMejor();
    }
    public Individual optimizadoFinal(){
    return null;
    }

}