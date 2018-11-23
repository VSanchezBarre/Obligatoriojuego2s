//author Valentin Sanchez Ignacio Pigatto
package PackageJuego;

import static PackageJuego.JuegoMain.pedirUnIntValidado;
import static PackageJuego.Tablero1.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Sistema implements Serializable {

    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Partida> listaPartidas;
    private ArrayList<Ficha> listaFichas;

    public Sistema() {
        this.listaJugadores = new ArrayList<>();
        this.listaPartidas = new ArrayList<>();
        this.listaFichas = new ArrayList<>();
        Ficha rojas = new Ficha("rojo", generarPosicionesAbajoFila(), generarPosicionesAbajoColumnas());
        listaFichas.add(rojas);
        Ficha azules = new Ficha("azul", generarPosicionesArribaFila(), generarPosicionesArribaColumnas());
        listaFichas.add(azules);  
    }

    public void setListaFichas(ArrayList<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaJugadores(ArrayList<Jugador> unalistaJugadores) {
        this.listaJugadores = unalistaJugadores;
    }

    public void setListaPartidas(ArrayList<Partida> unalistaPartidas) {
        this.listaPartidas = listaPartidas;
    }
    
     public static Jugador[] elegirJugador(Sistema sistema, String color1, String color2) {
        Jugador[] jugadoresElegidos = new Jugador[3];
        ArrayList<Jugador> auxiliar = sistema.getListaJugadores();
        System.out.println("Quien sera el jugador " + " " + color1 + " " + "?");
        for (int i = 0; i < auxiliar.size(); i++) {
            System.out.println(" - " + i + " " + auxiliar.get(i));
        }
        int elegido1 = pedirUnIntValidado(0, auxiliar.size() - 1, "Seleccione de la lista un jugador " + " " + color1 + " ", " Jugador no valido, ingrese denuevo");
        jugadoresElegidos[1] = auxiliar.get(elegido1);
        Jugador jugadorRemovido = auxiliar.get(elegido1);
        auxiliar.remove(auxiliar.get(elegido1));
        for (int i = 0; i < auxiliar.size(); i++) {
            System.out.println(" - " + i + " " + auxiliar.get(i));
        }
        int elegido2 = pedirUnIntValidado(0, auxiliar.size() - 1, "Seleccione de la lista un jugador " + " " + color2 + " ", " Jugador no valido, ingrese denuevo");
        jugadoresElegidos[2] = auxiliar.get(elegido2);
        auxiliar.add(jugadorRemovido);
        return jugadoresElegidos;
    }
public static int elegirTerminacion() {
        Scanner in = new Scanner(System.in);
        System.out.println("METODOS DE TERMINACION");
        System.out.println("1- Movimientos totales a eleccion");
        System.out.println("2- Alcanzar con una ficha el lado opuesto");
        System.out.println("3- Alcanzar con todas las fichas el lado opuesto");
        int opcion = pedirUnIntValidado(1, 3, "Eliga un metodo de terminacion", "Valor fuera de rango, intente denuevo");
        return opcion;
    }

    
    
    public static void jugar(Sistema sistema, int unaCantidadFilas, int unaCantidadColumnas) {
        Jugador[] jugadoresElegidos = elegirJugador(sistema, "rojo", "azul");
        Jugador jugadorRojo = jugadoresElegidos[1];
        Jugador jugadorAzul = jugadoresElegidos[2];
        int[][] tablero = crearTableroPred(unaCantidadFilas, unaCantidadColumnas);
        int opcion = elegirTerminacion();
        Partida partida = new Partida(jugadorRojo, jugadorAzul);
        Ficha rojas = new Ficha("rojo", generarPosicionesAbajoFila(), generarPosicionesAbajoColumnas());
        sistema.getListaFichas().add(rojas);
        Ficha azules = new Ficha("azul", generarPosicionesArribaFila(), generarPosicionesArribaColumnas());
        sistema.getListaFichas().add(azules);
        jugadorRojo.setFichasJugador(rojas);
        jugadorAzul.setFichasJugador(azules);
        int ganador = 0;
        Jugador jugadorGanador = new Jugador();
        boolean ver = false;
        if (opcion == 1) {
            System.out.println("Con cuantos movimientos desea jugar?");
            Scanner in = new Scanner(System.in);
            int maximo = in.nextInt();
            int contador = 0;
            boolean salir = false;
            while (contador < maximo && !salir) {
                imprimir(tablero, ver);
                Posibles unPosibles = movimiento(tablero, azules.getPosicionesi(), azules.getPosicionesj(), 0, rojas.getPosicionesi(), rojas.getPosicionesj(), rojas, partida, ver);
                salir = unPosibles.getEsPosible();
                tablero = unPosibles.getMatriz();
                ver = unPosibles.getVer();
                contador++;
                if (contador < maximo && !salir) {
                    imprimir(tablero, ver);
                    Posibles unPosible2 = movimiento(tablero, rojas.getPosicionesi(), rojas.getPosicionesj(), 1, azules.getPosicionesi(), azules.getPosicionesj(), azules, partida, ver);
                    tablero = unPosible2.getMatriz();
                    salir = unPosible2.getEsPosible();
                    ver = unPosible2.getVer();
                    contador++;
                }
            }
            jugadorGanador = ganador(jugadorRojo, jugadorAzul, 1, tablero);
        }
        if (opcion == 2) {
            boolean nopaso = true;
            boolean seguir = true;
            while (nopaso) {
                imprimir(tablero, ver);
                Posibles esPosible = movimiento(tablero, rojas.getPosicionesi(), rojas.getPosicionesj(), 1, azules.getPosicionesi(), azules.getPosicionesj(), azules, partida, ver);
                tablero = esPosible.getMatriz();
                ver = esPosible.getVer();
                nopaso = verificarPaso(tablero, jugadorRojo, jugadorAzul);
                if (!nopaso) {
                    jugadorGanador = jugadorRojo;
                }
                imprimir(tablero, ver);
                seguir = nopaso;
                if (seguir) {
                    Posibles esPosible2 = movimiento(tablero, azules.getPosicionesi(), azules.getPosicionesj(), 0, rojas.getPosicionesi(), rojas.getPosicionesj(), rojas, partida, ver);
                    tablero = esPosible2.getMatriz();
                    ver = esPosible2.getVer();
                    nopaso = verificarPaso(tablero, jugadorRojo, jugadorAzul);
                }
                if (!nopaso) {
                    jugadorGanador = jugadorAzul;
                }
            }
        }
        if (opcion == 3) {
            boolean paso = false;
            boolean seguir = false;
            while (!paso && !seguir) {
                int rojaspasadas = 0;
                int azulespasadas = 0;
                imprimir(tablero, ver);
                Posibles esPosible = movimiento(tablero, rojas.getPosicionesi(), rojas.getPosicionesj(), 1, azules.getPosicionesi(), azules.getPosicionesj(), azules, partida, ver);
                tablero = esPosible.getMatriz();
                seguir = esPosible.getEsPosible();
                ver = esPosible.getVer();
                imprimir(tablero, ver);
                jugadorGanador = ganador(jugadorRojo, jugadorAzul, 3, tablero);
                if (!seguir) {
                    Posibles esPosible2 = movimiento(tablero, azules.getPosicionesi(), azules.getPosicionesj(), 0, rojas.getPosicionesi(), rojas.getPosicionesj(), rojas, partida, ver);
                    tablero = esPosible2.getMatriz();
                    seguir = esPosible2.getEsPosible();
                    ver = esPosible2.getVer();
                    jugadorGanador = ganador(jugadorRojo, jugadorAzul, 3, tablero);
                    imprimir(tablero, ver);
                }
                for (int i = 1; i < 9; i++) {

                    int[] posicionesrojas = recorrerMatrizValida(tablero, jugadorAzul.getFichasJugador().getPosicionesi(), jugadorAzul.getFichasJugador().getPosicionesj(), i);
                    int[] posicionesazules = recorrerMatrizValida(tablero, jugadorRojo.getFichasJugador().getPosicionesi(), jugadorRojo.getFichasJugador().getPosicionesj(), i);
                    if (posicionesrojas[0] <= 3) {
                        rojaspasadas++;
                    }
                    if (posicionesazules[0] > 3) {
                        azulespasadas++;
                    }
                }
                if (rojaspasadas == 8) {
                    jugadorGanador = jugadorRojo;
                    paso = true;
                }
                if (azulespasadas == 8) {
                    jugadorGanador = jugadorAzul;
                    paso = true;
                }
            }
        }

        System.out.println(" La partida acabo ");
        if (!jugadorGanador.getAlias().equals("Empate")) {
            System.out.println(" El ganador es : " + " " + jugadorGanador);
            if (jugadorGanador.getAlias().equals(jugadorRojo.getAlias())) {
                int partidasGanadas = jugadorRojo.getPartidasGanadas();
                jugadorRojo.setPartidasGanadas(partidasGanadas + 1);
            } else {
                int partidasGanadas = jugadorAzul.getPartidasGanadas();
                jugadorAzul.setPartidasGanadas(partidasGanadas + 1);
            }
        } else {
            System.out.println("La partida acabo en empate! ");
        }

        System.out.println(" GRACIAS POR JUGAR!");
        sistema.getListaPartidas().add(partida);
    }
      public static String pedirUnString(String textoInstruccion) {
        System.out.println(textoInstruccion);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    
    // Metodo para agregar un jugador al sistema, corrobora que no hayan dos con el mismo alias
    public static void altaJugador(Sistema system) {
        String nombre = pedirUnString("Ingrese el nombre del jugador :");
        String alias = pedirUnString("Ingrese el alias del jugador:");
        int edad = pedirUnIntValidado(0, 100, "Ingrese la edad del Jugador :", "Edad incorrecta (0-100) Ingrese nuevamente :");
        while (system.existeAlias(alias)) {
            System.out.println("---Ya existe un Jugador con Dicho Alias!---");
            alias = pedirUnString("Ingrese Nuevamente el alias :");
        }
        system.agregarJugador(nombre, alias, edad, 0, new Ficha());
        System.out.println("\nJugador Agregado con Exito!");
    }
    
    public static void historial(Sistema sistema) {
        boolean vacia;
        vacia = sistema.getListaFichas().isEmpty() && sistema.getListaPartidas().isEmpty();
        if (!vacia) {
            boolean fichasVacias = false;
            Ficha rojas = sistema.getListaFichas().get(0);
            Ficha azules = sistema.getListaFichas().get(1);
            int[][] tablero = crearTableroPred(8, 9);
            imprimir(tablero, false);
            ArrayList<Partida> partidas = sistema.getListaPartidas();
            for (int i = 0; i < partidas.size(); i++) {
                System.out.println("Partida numero " + i);
                System.out.println(partidas.get(i));
            }
            Partida elegida = partidas.get(pedirUnIntValidado(0, partidas.size(), "Elegir una de las partidas", "Partida no valida, ingrese de nuevo"));
            System.out.println("Partida elegida" + elegida);
            imprimir(tablero, false);
            if (!elegida.getListaMovimientos().isEmpty()) {
                System.out.println("Movimientos de la partida, presione enter para mostrar cada movimiento");
                for (int i = 0; i < elegida.getListaMovimientos().size(); i++) {
                    System.out.println("Movimiento numero" + i + 1);
                    tablero = movimientoParm(tablero, elegida, rojas, azules);
                }
                System.out.println("Todos los movimientos mostrados");

            } else {

                System.out.println("No hay movimientos para mostrar");
            }

        } else {
            System.out.println("No hay partidas en su historial!");
        }
    }

     public static void imprimirRanking(Sistema unSistema) {
        boolean vacia = unSistema.getListaJugadores().isEmpty();
        if (!vacia) {
            for (int i = 0; i < unSistema.getListaJugadores().size(); i++) {
                System.out.println(unSistema.getListaJugadores().get(i));
            }
        } else {
            System.out.println("No hay jugadores registrados!");
        }
    }

    
    public void agregarJugador(String nombre, String alias, int edad, int partidasGanadas, Ficha fichas) {
        Jugador jugador = new Jugador(nombre, alias, edad, partidasGanadas, fichas);
        if (!alias.equals("Empate")) {
            listaJugadores.add(jugador);
        }
    }

    public boolean existeAlias(String alias) {
        Jugador auxPlayer = new Jugador();
        auxPlayer.setAlias(alias);
        return this.getListaJugadores().contains(auxPlayer);
    }

}
