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
public class Medida {
    private int size;
    private String united;

    public Medida(int size, String united) {
        this.size = size;
        this.united = united;
    }

    public int getSize() {
        return size;
    }

    public String getUnited() {
        return united;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setUnited(String united) {
        this.united = united;
    }
    
    
    
}
