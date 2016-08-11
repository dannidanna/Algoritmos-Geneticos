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
public class AlgorithmG {
 private static final double  mutation_chance=0.2;
 private static final int pressure=2;
 private static final int cant_individuos=6;///debo cambiar el valor a 6
 private Population population;

    public AlgorithmG() {
        population = new Population();
    }

    public Population getPopulation() {
        return population;
    }
 
    
    /**
     * este metodo recibe todos los objetos introducidos 
     * ya sea piezas o el material, para luego formar una poblacion inicial
     * @param obs  es una lista de objetos p
     * @return retorna una plano inicial
     */
      public  Population inicialPopulation(ArrayList<Objeto> obs) {
         
         Population populat=null;
         Material material=getMaterial(obs);
         populat= population.generatePopulation(material, obs,cant_individuos);
         
        return populat;
     }
     
     
 
     
     
     
     /**
      * es para obtener la tela que sera cortado o su caso marcado
      * @param obs es una lista donde estan las [piesas y la tela
      * @return 
      */
     private Material getMaterial(ArrayList<Objeto> obs){
         boolean bandera = false;
         Material material=null;
      int i=0;
        while (!bandera&&i<obs.size()) {            
            Objeto objeto = obs.get(i);
            if(objeto instanceof Material){
              material= (Material)obs.remove(i);
             bandera=true;
                //System.out.println("agarro el material");
            }
            i++;
        }
        return material;
     }
 
    
    /**
      * este metodo mustra la nueva evolucion
      * @param pop
      * @return 
      */
    public Population evolvePopulation(Population pop) {
    
           String name="";
            Individual indiv1      = tournamentSelection(pop,"");

            Individual indiv2      = tournamentSelection(pop,indiv1.getName());
         
            Population newPopul    = reprodictionIndividual(indiv1,indiv2);
            Individual idPol = newPopul.getIndividualMejor();

            Population newEvol     = crossover(newPopul);
            Individual id = newEvol.getIndividualMejor();
            Population newMutation = mutate(newEvol);
       
       return newMutation;

    }

        // Mutate an individual
    /**
     * este metodo no esta siendo usado
     * @param indiv 
     */
//    private  void mutate(Individual indiv) {
//        // Loop through genes
//        ///
//        //el limite 10 debe ser sustituido por el tamanio de individus
//        for (int i = 0; i < 10; i++) {
//            if (Math.random() <= mutation_chance) {
//                // Create random gene
//               
//            }
//        }
//    }

    /**
     * selecciona individuos para el cruce
     * @param pop
     * @return 
     */
    private  Individual tournamentSelection(Population pop,String name) {
        
        int size=pop.cantIndividual();  
         int fitness_mejor=10000;// iniciando en 100 porque el fitnes es cada
         int pos_mejor=0;
        ArrayList<Individual> individuos= pop.getIndividuos();
        
        for (int i = 0; i < size; i++) {
            Individual aux_ind = individuos.get(i);
            int fitness_aux=aux_ind.getFitness();
            if(fitness_aux<fitness_mejor&&(!aux_ind.getName().equals(name))){
             fitness_mejor= fitness_aux;
             pos_mejor=i;
            }
           }
        Individual res =individuos.get(pos_mejor);
        
        
        return res;
     
    }

    private Population reprodictionIndividual(Individual indiv1, Individual indiv2) {
        ArrayList<Individual> newInd = new ArrayList<>();
         for (int i = 0; i < cant_individuos/pressure; i++) {
             newInd.add(indiv1);
             
            
        }
         for (int i = 0; i < cant_individuos/pressure; i++) {
             newInd.add(indiv2);
            
        }
         Population newPop= new Population(newInd);
              
     return newPop;
    }
/**
 * se cruza la poclacion en este caso 
 * son 6 individuos en cada poblacion
 * @param newPopul
 * @return 
 */
    private Population crossover(Population newPopul) {
        Population newPopC=new Population();
        ArrayList<Individual> ind =  newPopul.getIndividuos();      
        newPopC.addIndividual(ind.get(0));
        int j=3;
        int i=1;
        for (i = 1; i <=2 ; i++) {
            
           Individual newInd = cross(ind.get(i),ind.get(j));
           newPopC.addIndividual(newInd);
        }
         j=4;
        for (i = 1; i <=2 ; i++) {
           Individual newInd = cross(ind.get(i),ind.get(j));
           
           newPopC.addIndividual(newInd);
        }        
     return newPopC;
    }

    private Population mutate(Population newEvol) {
        System.out.println("MUTANDO");
        //Individual indMejor =  newEvol.getIndividualMejor();
        //Piece pieza = (Piece)indMejor.getPieceSmall();
        newEvol.getIndividualMejor().mutar();
        return newEvol;
    }
   public int random(){
    return (int)(Math.random()*2);
   }
//    private Individual cross(Individual ind1, Individual ind2) {
//        ArrayList<Objeto> piezas = ind1.getObj_pieces();
//        for (int i = 0; i < piezas.size(); i++) {
//            ind1.reIniciar();
//            ind1.generateIndividual();
//           // System.out.println("creze exitoso");
//        }
//        return ind1;
//    }
   private Individual cross(Individual ind1, Individual ind2) {
   
        ArrayList<Objeto> piezas1 = ind1.getObj_pieces();
        ArrayList<Objeto> piezas2 = ind2.getObj_pieces();
        int cantP = piezas1.size();
        Individual newInd = new Individual(ind1.getM(),ind1.getN());
        //int numRand= random();
       // boolean insertado=false;
        
        for (int i = 0; i < cantP; i++) {
            
              int numRand= random();
              boolean insertado=false;
               if(numRand==0){
                 //insertado= insertar(newInd,piezas1.get(i));
                insertado = newInd.insertar(ind1,piezas1.get(i));
              }else 
              {
             
                  insertado = newInd.insertar(ind2,piezas2.get(i));
              
              }
               
               
               if(insertado!=true){
                   if(numRand==0)
                    insertado = newInd.insertar(ind2,piezas2.get(i));  
                   else insertado = newInd.insertar(ind1,piezas1.get(i));  
               }
                if(insertado!=true){
                    System.out.println("all");
                    insertado = newInd.insertarAll(ind2,piezas2.get(i));  
                   
               }
               
            
       }
       
        return newInd;
         
    }

    private void print(Objeto[][] obj) {
                    for (int i = 0; i < obj.length; i++) {
                for (int j = 0; j < obj[0].length; j++) {
                    if(obj[i][j]!=null){
                        System.out.print(obj[i][j].getName());
                    }
                    else System.out.print("v*");
                }
                System.out.println();
             }
    }

 
    
}
