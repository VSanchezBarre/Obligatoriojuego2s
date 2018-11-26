//author Valentin Sanchez Ignacio Pigatto
package PackageJuego;

import java.io.Serializable;

public class Jugador implements Comparable, Serializable{
    private String nombre;
    private String alias;
    private int edad;
    private int partidasGanadas;
    private Ficha fichasJugador;

    public void setFichasJugador(Ficha fichasJugador) {
        this.fichasJugador = fichasJugador;
    }

    public Ficha getFichasJugador() {
        return fichasJugador;
    }

    public Jugador(String nombre, String alias, int edad, int partidasGanadas, Ficha fichasJugador) {
        this.nombre = nombre;
        this.alias = alias;
        this.edad = edad;
        this.partidasGanadas = partidasGanadas;
        this.fichasJugador = fichasJugador;
    }
   
   

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

   public Jugador(){
       this.alias="";
       this.nombre="";
       this.edad=0;
       this.fichasJugador= new Ficha();
       this.partidasGanadas=0;
       
   }
    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
   
    
    
    
    
    
    @Override
    public String toString() {
        return "Jugador :" +" "+ "Nombre = " + nombre + ", Alias = " + alias +" "+ " Partidas ganadas = "+partidasGanadas;
    }
    
    public boolean equals (Object obj) {
        Jugador jugador =(Jugador)obj;
        return this.getAlias().equalsIgnoreCase(jugador.getAlias());
    }
    
    
    
    
    
    @Override
    public int compareTo(Object o) {
        Jugador jugador =(Jugador)o;
        return this.getPartidasGanadas() - jugador.getPartidasGanadas();
    }
    
    
}
