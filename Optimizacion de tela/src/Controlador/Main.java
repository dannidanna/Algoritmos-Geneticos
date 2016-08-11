/*
* este controlador es de optimizacion
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlgorithmG;
import Modelo.Generacion;
import Modelo.Individual;
import Modelo.Material;
import Modelo.Medida;
import Modelo.Objeto;
import Modelo.Piece;
import Vista.Interface;
import Vista.panelTela;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author santiago
 */
public class Main {
    public static void main(String[] arg)
    {   
        Controlador control  = Controlador.getControlador();
        AlgorithmG ag1 = new AlgorithmG();
        Generacion generacion = new Generacion();
    //    panelTela panelT =  new panelTela();
        control.setGeneracion(generacion);
        control.setAlgorithmG(ag1);
        Interface admin=new Interface();
  //      control.setPanelTela(panelT);
        //new Interface();
        // esta es la froma que debes crear objetos 
        // Piece(medida(alto,unidad),medida(ancho,unidad),nombre de la pieza)
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
        Individual ind1 = control.inicio(obj);//este es la forma que dedes llamar , para mostrar las piesas en el interfaz
        int cant_indi=ag1.getPopulation().cantIndividual();
        //System.out.println("Mejor Poblacion: " + control.getMejorPopulation().getIndividualMejor().getName());
        //System.out.println("Cantidad de individuos: " + cant_indi);
         
        for (int i = 0; i < 1000; i++) {
            
        }
        System.out.println("=====================================================");
        System.out.println("la matriz es de: " + ind1.getName());
        
        System.out.println("Fitness: " + ind1.getFitness());
        
//        System.out.println("altoIni: " + ind1.getAltoIni());
//        System.out.println("altoFni: " + ind1.getAltoFin());
//        
//        System.out.println("anchoIni: " + ind1.getAnchoIni());
//        System.out.println("anchoFin: " + ind1.getAnchoFin());
        
        Objeto [][] piezas= ind1.getPieces();
        
        printIni(piezas);
       // dibujar(piezas);
        for (int i = 0; i < 10000; i++) {
            
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Individual newInd1 = control.optimizar();
        
        System.out.println("=====================================================");
        System.out.println("la matriz es de: " + newInd1.getName());
        System.out.println("Fitness: " + newInd1.getFitness());
        Objeto [][] newPiezas= newInd1.getPieces();
        
        
        printOptimizar1(newPiezas);
        ////////////////////////////////////////////////////////////////////////////////////////////
          for (int i = 0; i < 100000; i++) {
            
        }
                ////////////////////////////////////////////////////////////////////////////////////////////
        
        Individual newInd2 = control.optimizar();
        
        System.out.println("=====================================================");
        System.out.println("la matriz es de: " + newInd2.getName());
        System.out.println("Fitness: " + newInd2.getFitness());
        Objeto [][] newPiezas2= newInd2.getPieces();
        
        
        printOptimizar1(newPiezas2);
         ////////////////////////////////////////////////////////////////////////////////////////////
          for (int i = 0; i < 100000; i++) {
            
        }
                ////////////////////////////////////////////////////////////////////////////////////////////
        
        Individual newInd3 = control.optimizar();
        
        System.out.println("=====================================================");
        System.out.println("la matriz es de: " + newInd3.getName());
        System.out.println("Fitness: " + newInd3.getFitness());
        Objeto [][] newPiezas3= newInd3.getPieces();
        
        
        printOptimizar1(newPiezas3);
        
        //new Interface(); 
    }  

    private static void printIni(Objeto[][] piezas) {
        
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j <piezas[0].length; j++) {
                if(piezas[i][j]!=null)
                    System.out.print(piezas[i][j].getName());
                else
                    System.out.print("v*");
            }
            System.out.println();
        }
        System.out.println("=============================================================");
    }

   
    private static void printOptimizar1(Objeto[][] piezas) {
        
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j <piezas[0].length; j++) {
                if(piezas[i][j]!=null)
                    System.out.print(piezas[i][j].getName());
                else
                    System.out.print("v*");
            }
            System.out.println();
        }
        System.out.println("=============================================================");
    }
    
    public static void dibujar(Objeto[][] obs){
     panelTela panel = new panelTela(obs);
 
    // create a basic JFrame
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("JFrame Color Example");
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    // add panel to main frame
    frame.add(panel);
 
    frame.setVisible(true);
 
    
    }
}
