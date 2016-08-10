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
    private int m,n;
    private ArrayList<Objeto> obj_pieces;
    private int fitness;
    private boolean selected;
    private String name;
    private FitnessCalc fitnessCal;
        
  /**
   *  este es para definir el tamanio de la tela
   * @param alto
   * @param ancho 
   */
    public Individual(Medida alto,Medida ancho){
    m= alto.getSize();
    n=ancho.getSize();
    pieces = new Objeto[m][n];
    fitness=0;
    selected = false;
    name="";
    fitnessCal = new FitnessCalc();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public void reIniciar(){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 pieces[i][j]=null;
            }
        }
            fitness=0;
    selected = false;
    name="";
    fitnessCal = new FitnessCalc();
    }
    /**
     * retorna la cantidad de piezas
     * @return 
     */
    public int cantPieces(){
    return obj_pieces.size();
    }

    public ArrayList<Objeto> getObj_pieces() {
        return obj_pieces;
    }
    
    public void setObj_pieces(ArrayList<Objeto> obj_pieces) {
        this.obj_pieces = obj_pieces;
    }
    
    public int getFitness() {
        if (fitness == 0) {
            fitness = fitnessCal.getFitness(this);
        }
        return fitness;
    }



    private int posX() {
  byte posX = (byte) Math.round(Math.random()*m);
       
      return posX;       
    }

    private int posY() {
   byte posY = (byte) Math.round(Math.random()*n);
  
   return posY;
    }

    private void acomodar(Piece piece) {
        
            do {            
                       int num_alt= (int)(Math.random()*2);// es para comensar con alto o con el ancho
            Medida m_alto = piece.getAlto();
            Medida m_ancho = piece.getAncho();
            int alto=0; 
            int ancho=0;
            if(num_alt==0){
             alto= m_alto.getSize();
             ancho= m_ancho.getSize();
            }else{
             alto= m_ancho.getSize();
             ancho= m_alto.getSize();
            }
           // int posX=posX();
           // int posY=posY();
            
           
           m_alto.setSize(alto);
           m_ancho.setSize(ancho);
           piece.setAlto(m_alto);
           piece.setAncho(m_ancho);
        } while (!acomodo(piece,posX(),posY()));
 
            
    }

    private boolean acomodo(Piece piece, int posX, int posY) {
  
      boolean res =true;// es para saber si esta vacion el lugar para acomodar la pieza
      int alto= piece.getAlto().getSize();
      int ancho=piece.getAncho().getSize();
      int altoIni=alto;
      int anchoIni= ancho;
      //System.out.println("entro a acomodo.pos x:" + posX + " y: "+posY+" alto: "+alto+" ancho:"+ancho+"pieza: " + piece.getName());
      int i= posX;
      int j = posY;
       alto =  alto +posX;
       ancho= ancho+posY;
     // int visitadosX=0;
     // int visitadosY=0;
        while (res&&posX<m&&posX<alto) {
          posY=j;            
            while (res&&posY<n&&posY<ancho) {                
                
                if(pieces[posX][posY]!=null){
                    res =false;
                    //System.out.println("no esta vacio matriz para: " +piece.getName());
                }
                    
                posY++;
            }
            posX++;
        }
        
        int auxAlto= posX-i;
        int auxAncho = posY-j;
        
        if (((auxAlto*auxAncho)!=altoIni*anchoIni)) {
            res=false;
        }
        
        if(res==true&&((auxAlto*auxAncho)==altoIni*anchoIni)) {
            insertarPiezas(piece,i,j);
        //System.out.println("entro a acomodo....if_llama a inserta pieza");
        }
      
      
     return res;
    }

    private void insertarPiezas(Piece piece, int i, int j) {
      int alto= piece.getAlto().getSize();
      int ancho=piece.getAncho().getSize();
       alto =  alto +i;
       ancho= ancho+j;
        for (int posI=i;posI < alto; posI++) {
            for (int posJ=j; posJ < ancho; posJ++) {
                pieces[posI][posJ]= piece;
                //System.out.println("insertadndo: " + piece.getName());
            }
        }
    }

    public Objeto[][] getPieces() {
        return pieces;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}
