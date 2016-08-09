/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interface;

/**
 *
 * @author santiago
 */
public class Main {
    public static void main(String[] arg)
    {
         Controlador control = Controlador.getControlador();
        new Interface(); 
    }  
}
