/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author santiago
 */
public class FitnessCalc {

    public FitnessCalc() {
    }
    
       
    /**
     * calcula el fitnes , cuanto mas optimizado retorna un 
     * fitness menor
     * @param individual
     * @return retorna el fitnes menor
     */
    public  int getFitness(Individual individual) {
        //System.out.println("holafitnes");
        int fitness= alto(individual)*ancho(individual);
           individual.setFitness(fitness);
       return fitness ;
        
    
    }

    private  int alto(Individual individual) {
        
        //System.out.println("ENTRPPPPPPPPPPPPP");
          Objeto [][] pieces = individual.getPieces();
        int altoIni=1000;
        int altoFin=0;
        
        int altoIniAux=0;
        int altoFinAux=0;
        
        boolean iniEncontrado=false;
        
        for (int j = 0; j < pieces.length ; j++) {
            for (int i = 0; i < pieces[0].length; i++) {
                if (pieces[i][j]!=null) {
                     
                     if(!iniEncontrado){
                         altoIniAux=i;
                         iniEncontrado=true;
                       
                     }else{
                       altoFinAux=i;
                     }
                }
            }
            iniEncontrado=false;
            if(altoIniAux<altoIni){
              altoIni = altoIniAux;
            }
            if(altoFinAux>altoFin){
              altoFin = altoFinAux;
            }     
            
            individual.setAltoIni(altoIni); //desabilitar para almacenar el ini  
            individual.setAltoFin(altoFin);//desabilitar para almacenar el fin  
        }
        int alto =  altoFin-altoIni+1;
        //System.out.println("fit altossss: " +alto);
        return alto;
    }

    private int ancho(Individual individual) {
           Objeto [][] pieces = individual.getPieces();
        int anchoIni=1000;
        int anchoFin=0;
        
        int anchoIniAux=0;
        int anchoFinAux=0;
        
        boolean iniEncontrado=false;
        
        for (int i = 0; i < pieces.length ; i++) {
            for (int j = 0; j < pieces[0].length; j++) {
                if (pieces[i][j]!=null) {
                     
                     if(!iniEncontrado){
                         anchoIniAux=j;
                         iniEncontrado=true;
                       
                     }else{
                       anchoFinAux=j;
                     }
                }
            }
            iniEncontrado=false;
            if(anchoIniAux<anchoIni){
              anchoIni = anchoIniAux;
            }
            if(anchoFinAux>anchoFin){
              anchoFin = anchoFinAux;
            }     
            
            individual.setAnchIni(anchoIni); //desabilitar para almacenar el ini  
            individual.setAnchFin(anchoFin);//desabilitar para almacenar el fin  
        }
        int ancho =  anchoFin-anchoIni+1;
       // System.out.println("fit altossss: " +ancho);
        return ancho;
    }
}
