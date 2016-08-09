/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author relos
 */
public class Controlador 
{
    public static Controlador control;

    
    public static Controlador getControlador()
    {
        if( control == null )
        {
            control = new Controlador();
        }
        return control;
    }

}