/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Material;
import Modelo.Objeto;
import Modelo.Population;
import java.util.ArrayList;

/**
 *
 * @author relos
 */
public class Controlador 
{
    public static Controlador control;
    private int cant_individuos=5;
    
    public static Controlador getControlador()
    {
        if( control == null )
        {
            control = new Controlador();
        }
        return control;
    }

}