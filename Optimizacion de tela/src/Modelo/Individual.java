/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
    private int altoIni,altoFin,anchoIni,anchoFin;
        
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
    /**
     * aal optimizar
     * @param m
     * @param n 
     */
      public Individual(int m,int n){
    this.m= m;
    this.n=n;
    pieces = new Objeto[m][n];
    fitness=0;
    selected = false;
    name="";
    fitnessCal = new FitnessCalc();
    obj_pieces= new ArrayList<>();
    }
      
      
      //metodos get/set
          public Objeto[][] getPieces() {
        return pieces;
    }
          

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setAltoIni(int altoIni) {
     this.altoIni=altoIni;
    }

    public void setAltoFin(int altoFin) {
     this.altoFin= altoFin;
    }

    public void setAnchIni(int anchoIni) {
      this.anchoIni= anchoIni;
    }
    
    public void setAnchFin(int anchoFin) {
      this.anchoFin=anchoFin;
    }

    public int getAltoIni() {
        return altoIni;
    }

    public int getAltoFin() {
        return altoFin;
    }

    public int getAnchoIni() {
        return anchoIni;
    }

    public int getAnchoFin() {
        return anchoFin;
    }
    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private int posX() {
      byte posX = (byte) Math.round(Math.random()*m);
       
      return posX;       
    }

    private int posY() {
   byte posY = (byte) Math.round(Math.random()*n);
  
   return posY;
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
    public void addPiece(Objeto obj){
     obj_pieces.add(obj);
    }
       
    public int getFitness() {
        if (fitness == 0) {
            fitness = fitnessCal.getFitness(this);
              }
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    public Objeto getPieceSmall(){
    Objeto obj=null;
     int areaMejor=10000;
     int areaAux=0;
     int posPiece = 0;
        for (int i = 0; i < obj_pieces.size(); i++) {
            Piece pieceAux = (Piece)obj_pieces.get(i);
            areaAux        = (pieceAux.getAlto().getSize())*(pieceAux.getAncho().getSize());
            if(areaAux<areaMejor){
             areaMejor =  areaAux;
             posPiece = i;
                
            }
        }
        return obj_pieces.get(posPiece);
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

/**
 * es cuando se esta optimiando
 * @param ind1
 * @param piece
 * @return 
 */
    public boolean insertar(Individual ind1, Objeto piece) {
        boolean vacio=true;
        int i = 0;
        Objeto [][] objetos = ind1.getPieces();
        String namePiece = piece.getName();
        while (i<m&&vacio) {            
            int j = 0;
            while (j<n&&vacio) {
              if(objetos[i][j]!=null){
              if(objetos[i][j] instanceof Piece)
             {            
                
             String namePieceAux = objetos[i][j].getName();
             if(namePiece.equals(namePieceAux))
                if(pieces[i][j]!=null)
                    vacio = false;
                }
              }              
       
             j++;
            }
            i++;
        }
        if(vacio==true)
        insertarPiezaM(ind1,piece);
        return vacio;
    }

    public boolean insertarAll(Individual ind2, Objeto get) {
      return false;
    }

    private void insertarPiezaM(Individual ind1, Objeto piece) {
         Objeto [][] objetos = ind1.getPieces();
        String namePiece = piece.getName();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                             
             if(objetos[i][j]!=null){
              if(objetos[i][j] instanceof Piece)
             {            
             String nameAux= objetos[i][j].getName();
                if(namePiece.equals(nameAux))
                    pieces[i][j]=piece;          
               
            }
        }
        }
        }
    }

//    public void mutar() {
//        int i = altoIni;
//        boolean vacioIni = false;
//        boolean marcado = true;
//      while(vacio && i< altoFin){
//          int j=anchoIni;
//          while (vacio && j<anchoFin) {              
//              if(pieces[i][j]==null&&!vacioIni){
//               vacioIni = true;
//               
//              }
//              j++;
//          }
//          i++;
//      }
//    }
//    
    
     public void mutar(){
             ArrayList<Objeto> list= piezasMutar();
          while(!list.isEmpty()){
          
                      Piece piece = (Piece)list.remove(list.size()-1);
             quitarPieza(piece);
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
            m_alto.setSize(alto);
           m_ancho.setSize(ancho);
           piece.setAlto(m_alto);
           piece.setAncho(m_ancho);
           //int posI = ThreadLocalRandom.current().nextInt(altoIni,altoFin + 1);
           //int posJ = ThreadLocalRandom.current().nextInt(anchoIni,anchoFin + 1);
           //int posX =  (int)Math.round(Math.random()*n);
           //int posY =  (int)Math.round(Math.random()*n);
        } while (!acomodoMutacion(piece,getRandomRangoX(),getRandomRangoY()));
      }
 
            
    }
     public int getRandomRangoX(){
         int num = ThreadLocalRandom.current().nextInt(altoIni,altoFin + 1);
         System.out.println("numeroRAMDOM_X: " +num);
     return  num;
     }
    public int getRandomRangoY(){
        
        int num = ThreadLocalRandom.current().nextInt(anchoIni,anchoFin + 1);
        System.out.println("numeroRAMDOM+Y: " +num);
     return num;
     }
    private boolean acomodoMutacion(Piece piece, int posX, int posY) {
  
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
        while (res&&posX<altoFin&&posX<alto) {
          posY=j;            
            while (res&&posY<anchoFin&&posY<ancho) {                
                
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
            insertarPiezasMutacion(piece,i,j);
        //System.out.println("entro a acomodo....if_llama a inserta pieza");
        }
      
      
     return res;
    }

    private void insertarPiezasMutacion(Piece piece, int i, int j) {
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

    private void quitarPieza(Piece piece) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pieces[i][j]!=null){
                 if(pieces[i][j] instanceof Piece)
                        if(pieces[i][j].getName().equals(piece.getName())) {
                           pieces[i][j]=null; 
                        }
                }
            }
        }
    }

    private ArrayList<Objeto> piezasMutar() {
      ArrayList<Objeto> auxList = obj_pieces;
      ArrayList<Objeto> listOrd = new ArrayList<>();
      int areaAux = 10000;
      int areaSmall = 1000;
      int posSmall = 0;
        for (int i = 0; i < auxList.size(); i++) {
            areaAux = auxList.get(i).getArea();
            
        }
        //int posI=0;
        while (!auxList.isEmpty()) {            
            for (int i = 0; i < auxList.size(); i++) {
              areaAux = auxList.get(i).getArea();
              if(areaAux<areaSmall){
                areaSmall = areaAux;
                posSmall = i;
              }
            
           }
            listOrd.add(auxList.remove(posSmall));
             areaSmall = 10000;
            
        }
        
        int hasta =(int) listOrd.size()/2;
        for (int i = 0; i < hasta; i++) {
            listOrd.remove(listOrd.size()-1);
        }
       return listOrd;
      
    }
        
    
}
