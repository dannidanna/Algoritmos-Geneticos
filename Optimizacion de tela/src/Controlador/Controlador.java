/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlgorithmG;
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
    private int cant_individuos=6;
    
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
    
    /**
     * este metodo retorna una plano de piezas acomodas
     * a un inicio
     *  
     * @param obs
     * @return 
     */
    public Individual inicio(ArrayList<Objeto> obs){
        Population pop =  algorithmG.inicialPopulation(obs);
     return pop.getIndividualMejor();
    }
    /**
     * este metodo retorna las piezas mejor acomodadas
     * @return 
     */
    public Individual optimizar(){
    return null;
    }
    public Individual optimizadoFinal(){
    return null;
    }

}