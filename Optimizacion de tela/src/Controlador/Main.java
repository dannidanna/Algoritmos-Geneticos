/*
* este controlador es de optimizacion
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlgorithmG;
import Modelo.Individual;
import Modelo.Material;
import Modelo.Medida;
import Modelo.Objeto;
import Modelo.Piece;
import Vista.Interface;
import java.util.ArrayList;

/**
 *
 * @author santiago
 */
public class Main {
    public static void main(String[] arg)
    {
        Controlador control  = Controlador.getControlador();
        AlgorithmG ag1 = new AlgorithmG();
        control.setAlgorithmG(ag1);
        Piece p1             = new Piece(new Medida(3,"cm"),new Medida(4,"cm"),"p1");
        Piece p2             = new Piece(new Medida(3,"cm"),new Medida(3,"cm"),"p2");
        Piece p3             = new Piece(new Medida(2,"cm"),new Medida(1,"cm"),"p3");
        Piece p4             = new Piece(new Medida(3,"cm"),new Medida(1,"cm"),"p4");
        Piece p5             = new Piece(new Medida(2,"cm"),new Medida(2,"cm"),"p5");
        Material m1          = new Material(new Medida(10,"cm"),new Medida(10,"cm"),"material1");
        ArrayList<Objeto> obj= new ArrayList<>();
        obj.add(m1);
        obj.add(p1);
        obj.add(p2);
        obj.add(p3);
        obj.add(p4);
        obj.add(p5);
        Individual ind1 = control.inicio(obj);
        Objeto [][] piezas= ind1.getPieces();
        
        print(piezas);
        
        
        
        
        //new Interface(); 
    }  

    private static void print(Objeto[][] piezas) {
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j <piezas[0].length; j++) {
                if(piezas[i][j]!=null)
                    System.out.print(piezas[i][j].getName());
                else
                    System.out.print("p*");
            }
            System.out.println();
        }
        System.out.println("=============================================================");
    }
}
