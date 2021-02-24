package m6_p4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author carlosromvel
 */
public class Coches implements Serializable{
    String matricula_id;
    String color;
    String modelo;
    int precio;
    
    public Coches(){
    
    }
    public Coches(String matricula_id, String color, String modelo, int precio){
        this.matricula_id = matricula_id;
        this.color = color;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(String matricula_id) {
        this.matricula_id = matricula_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
}


