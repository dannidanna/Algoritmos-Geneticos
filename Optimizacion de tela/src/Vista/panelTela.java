/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Dayne
 */
class panelTela extends JPanel {
    
    int [][] matriz;
    Color [] colors;
    Controlador control;
    
 /*   public panelTela(int [][] m){
    colors = new Color[]{Color.red, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.green, Color.ORANGE, Color.YELLOW,Color.DARK_GRAY};  
    matriz = m;
    }*/
    public panelTela(){
    control = Controlador.getControlador();
    colors = new Color[]{Color.black,Color.red, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.green, Color.ORANGE, Color.YELLOW,Color.DARK_GRAY};  
    int [][] ma ={     { 0, 2, 2, 3, 3 },
                       { 0, 2, 2, 3, 3 },
                       { 0, 0, 0, 0, 0 },
                       { 1, 1, 0, 0, 0 },
                       { 1, 1, 0, 0, 4 },
                       { 1, 1, 0, 0, 4 }
                             };
    int[][] matrizT = new int[ma[0].length][ma.length];
    for (int x=0; x < ma.length; x++) {
  for (int y=0; y < ma[x].length; y++) {
    matrizT[y][x] = ma[x][y];
  }
}
    matriz = matrizT;
    }
    

  public void paint(Graphics g) {
      pintarMatriz(g);
  }
  
  public void pintarMatriz(Graphics g){
  int fil = matriz.length;
  int col = matriz[0].length;
  
  for (int i = 0; i < fil; i++) {  //número de filas
     for (int j = 0; j < col; j++) { //número de columnas de cada fila
         pintarPieza(i*10, j*10, matriz[i][j], g);
     }
     
}
    
  }
  
  public void pintarPiezaEntera(int x1, int y1, int x2, int y2, int col, Graphics g){
    Color c = colors[col];
      
      g.setColor(c);
    g.fillRect(x1, y1, (x2-x1), (y2-y1));
  
  }
  
    public void pintarPieza(int x, int y, int col, Graphics g){
    Color c = colors[col];
      
      g.setColor(colors[col]);
    g.fillRect(x, y, (x+10), (y+10));
    

  
  }
}