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
       
    /**
     * calcula el fitnes , cuanto mas optimizado retorna un 
     * fitness menor
     * @param individual
     * @return retorna el fitnes menor
     */
    public static int getFitness(Individual individual) {
       return alto(individual)*ancho(individual) ;
        
    
    }

    private static int alto(Individual individual) {
        Objeto [][] pieces = individual.getPieces();
        int altoF=0;
        int cantF=0;
        for (int j = 0; j < pieces[0].length ; j++) {
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i][j]!=null) {
                    cantF++;
                }
            }
            if(cantF>altoF)
                altoF= cantF;
        }
        return altoF;
    }

    private static int ancho(Individual individual) {
           Objeto [][] pieces = individual.getPieces();
        int anchoF=0;
        int cantF=0;
        for (int i = 0; i < pieces.length ; i++) {
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[i][j]!=null) {
                    cantF++;
                }
            }
            if(cantF>anchoF)
                anchoF= cantF;
        }
        return anchoF;
    }
}
