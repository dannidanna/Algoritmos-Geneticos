/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.*;
import javax.swing.*;
 
public class DrawRectangle {
 
  public static void main(String[] arguments) {
    
   panelTela panel = new panelTela();
 
    // create a basic JFrame
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("JFrame Color Example");
    frame.setSize(100,100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    // add panel to main frame
    frame.add(panel);
 
    frame.setVisible(true);
 
  }
}
 
