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
public class Objeto {
    private Medida alto;
    private Medida ancho;
    private String name;

    public Objeto(Medida alto, Medida ancho, String name) {
        this.alto = alto;
        this.ancho = ancho;
        this.name = name;
    }


    public Medida getAlto() {
        return alto;
    }

    public Medida getAncho() {
        return ancho;
    }

    public void setAlto(Medida alto) {
        this.alto = alto;
    }

    public void setAncho(Medida ancho) {
        this.ancho = ancho;
    }
    
}
