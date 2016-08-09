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
public class Individual {
    private Objeto [][] pieces;
    private ArrayList<Objeto> obj_pieces;
    private int fitness;
        // Create a random individual
  /**
   *  este es para definir el tamanio de la tela
   * @param alto
   * @param ancho 
   */
    public Individual(Medida alto,Medida ancho){
    pieces = new Objeto[alto.getSize()][ancho.getSize()];
    fitness=0;
    }
    /**
     * este metodo genera un plano donde
     * se visualiza las piezas acomodadas
     */
    public void generateIndividual() {
        for (int i = 0; i < obj_pieces.size(); i++) {
            Piece piece = (Piece) obj_pieces.get(i);
            acomodar(piece);       
            }
    }

    public void setObj_pieces(ArrayList<Objeto> obj_pieces) {
        this.obj_pieces = obj_pieces;
    }
    
    public Individual getFittest() {
       return null;
    }



    private byte posX() {
  byte posX = (byte) Math.round(Math.random()*pieces[0].length);
      return posX;       
    }

    private byte posY() {
   byte posY = (byte) Math.round(Math.random()*pieces.length);
   return posY;
    }

    private void acomodar(Piece piece) {
            byte num_alt= (byte)(Math.random()*2);// es para comensar con alto o con el ancho
            int alto=0; 
            int ancho=0;
            if(num_alt==0){
             alto= piece.getAlto().getSize();
             ancho= piece.getAncho().getSize();
            }else{
             ancho= piece.getAlto().getSize();
             alto= piece.getAncho().getSize();
            }
            
            //////sigo desarrollando esta parte
            
            
    }
}
