package PackageJuego;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.*;

import java.util.ArrayList;

public class Grabacion {

    private static Sistema sistema;
    private static ArrayList<Jugador> listaJugadores;
    String jsonPath;
    
    public Sistema getSistema() {
        return sistema;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public Grabacion() {
        this.sistema = new Sistema();
        this.listaJugadores = new ArrayList<>();
    }

    public Grabacion(Sistema sistema, ArrayList<Jugador> listaJugadores,String path) {
        this.sistema = sistema;
        this.listaJugadores = listaJugadores;
        this.jsonPath = path;
    }
    
    public void crearArchivoJSON (String path,ArrayList<Jugador> listaJugadores){
        JSONObject unaLista = new JSONObject();
        unaLista.put("listaJugadores", listaJugadores);

        try (FileWriter file = new FileWriter(path)) {
            file.write(unaLista.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(unaLista);
        
    }


}
