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
    
    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
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
            Medida m_alto = piece.getAlto();
            Medida m_ancho = piece.getAncho();
            int alto=0; 
            int ancho=0;
            if(num_alt==0){
             alto= m_alto.getSize();
             ancho= m_ancho.getSize();
            }else{
             ancho= m_ancho.getSize();
             alto= m_alto.getSize();
            }
            byte posX=posX();
            byte posY=posY();
            
           // while(!acomodo(piece,alto,ancho,posX,posY)){
           m_alto.setSize(alto);
           m_ancho.setSize(ancho);
           piece.setAlto(m_alto);
           piece.setAncho(m_ancho);
           while(!acomodo(piece,posX,posY)){
              posX=posX();
              posY=posY();
            }
            
            //////sigo desarrollando esta parte
            
            
    }

    private boolean acomodo(Piece piece, byte posX, byte posY) {
        
      boolean res =true;// es para saber si esta vacion el lugar para acomodar la pieza
      int alto= piece.getAlto().getSize();
      int ancho=piece.getAncho().getSize();
      int visitadosX=0;
      int visitadosY=0;
        while (res&&posX<pieces.length&&posX<alto) {            
            while (res&&posY<pieces[0].length&&posY<ancho) {                
                if(pieces[posX][posY]!=null)
                    res =false;
                posY++;
            }
            posX++;
        }
        //int totalV= posX*posY;
        if(res==true&&(posX*posY==alto*ancho)) 
            insertarPiezas(piece,posX,posY);
      
      
     return res;
    }

    private void insertarPiezas(Piece piece, byte posX, byte posY) {
      int alto= piece.getAlto().getSize();
      int ancho=piece.getAncho().getSize();
        for (; posX < alto; posX++) {
            for (; posY < ancho; posY++) {
                pieces[posX][posY]= piece;
            }
        }
    }

    public Objeto[][] getPieces() {
        return pieces;
    }
    
}
