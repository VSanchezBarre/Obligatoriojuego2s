//author Valentin Sanchez Ignacio Pigatto
package PackageJuego;

import java.io.Serializable;
import java.util.ArrayList;

public class Ficha implements Serializable {
   String color; int[] posicionesi,posicionesj;Partida partida;

    public String getColor() {
        return color;
    }

    public int[] getPosicionesi() {
        return posicionesi;
    }

    public int[] getPosicionesj() {
        return posicionesj;
    }

    public Ficha(String color, int[] posicionesi, int[] posicionesj,Partida unaPartida) {
        this.color = color;
        this.posicionesi = posicionesi;
        this.posicionesj = posicionesj;
       
    }
    
    public Ficha(){
        this.color="";
        this.posicionesi=new int[8];
        this.posicionesj=new int[8];
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPosicionesi(int[] posicionesi) {
        this.posicionesi = posicionesi;
    }

    public void setPosicionesj(int[] posicionesj) {
        this.posicionesj = posicionesj;
    }


}
