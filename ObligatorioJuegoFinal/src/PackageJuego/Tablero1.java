package PackageJuego;

import static PackageJuego.JuegoMain.enterContinuar;
import static PackageJuego.JuegoMain.posiblesMovimientos;
import static PackageJuego.JuegoMain.setearPosiciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import static paqueteInterfaz.Tablero.buttonaInt;

public class Tablero1 implements Serializable {

    int[][] tablero;

    public Tablero1() {
        this.tablero = crearTableroPred(8, 9);
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public static int[][] crearTableroPred(int unaCantidadFilas, int unaCantidadColumnas) {
        int cantidadfilas = unaCantidadFilas;
        int cantidadcolumnas = unaCantidadColumnas;
        int[][] tablero = new int[cantidadfilas][cantidadcolumnas];
        for (int i = 0; i < tablero[0].length; i++) {
            tablero[0][i] = i;
        }
        for (int i = 0; i < tablero[0].length; i++) {
            tablero[7][i] = 8 - i;
        }
        return tablero;
    }

    public static Posibles movimiento(int[][] unTablero, int[] fichasiinvalidas, int[] fichasjinvalidas, int color, int[] fichasvalidas, int[] fichasjvalidas, Ficha ficha, Partida partida, Boolean verParm) {
        boolean salir = false;
        int[][] tablero = unTablero;
        boolean ver = verParm;
        boolean pasar = false;
        int contador = 0;
        ArrayList<Integer> fichasPosibles = new ArrayList<Integer>();
        if (color == 0) {
            boolean esPosible = true;
            while (esPosible) {
                System.out.println("Jugador rojo, eliga un movimiento");
                String in;
                Scanner intro = new Scanner(System.in);
                in = intro.nextLine();
                String result = in.replaceAll("[^0-9]+", "");
                if (in.length() == 4) {
                    if (in.equals("VERR")) {
                        System.out.println("Verr");
                        ver = true;
                        result = "";
                    }
                    if (in.equals("VERN")) {
                        System.out.println("VERN");
                        ver = false;
                        result = "";
                    }
                }

                boolean esx = in.equals("X");
                if (in.length() == 1) {
                    if (in.equals("X")) {
                        System.out.println("Termino la partida");
                        esPosible = false;
                        salir = true;
                    }

                    if (!pasar) {
                        if (in.length() == 1 && (!esx)) {
                            if ((in.equals("p"))) {
                                System.out.println("Necesita hacer un movimiento para poder pasar");

                            } else {
                                System.out.println("Valor no valido, ingrese denuevo");
                            }

                        }

                    }
                }

                if (pasar) {
                    if (in.length() == 1 && (!esx)) {
                        if (in.equals("p")) {
                            esPosible = false;

                        } else {
                            System.out.println("Valor no valido, ingrese denuevo");
                        }
                    }
                }

                if (in.length() == 3) {
                    System.out.println("Palabra incorrecta");
                }

                if (in.length() > 4) {
                    System.out.println("Palabra incorrecta");
                }
                int resultado = 0;
                if (!result.equals("")) {
                    resultado = Integer.parseInt(result);
                }
                int posicioni = 0;
                int posicionj = 0;
                int posicioniNueva = 0;
                int posicionjNueva = 0;
                if (in.contains("D")) {

                    int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                    posicioni = posiciones[0];
                    posicionj = posiciones[1];
                    posicioniNueva = posicioni - 1;
                    posicionjNueva = posicionj + 1;

                    if (posicionj != 8 && tablero[posicioniNueva][posicionjNueva] == 0) {
                        tablero[posicioniNueva][posicionjNueva] = tablero[posicioni][posicionj];
                        tablero[posicioni][posicionj] = 0;
                        setearPosiciones(ficha, resultado, posicioniNueva, posicionjNueva);
                        partida.getListaMovimientos().add(in);
                        partida.getColores().add(color);
                        imprimir(tablero, ver);
                        contador++;
                    } else {
                        System.out.println("La posicion a donde desea moverse ya esta ocupada");
                    }

                    esPosible = posiblesMovimientos(posicioniNueva, posicionjNueva, tablero).getEsPosible();
                    if (esPosible) {
                        contador++;
                    }

                    pasar = true;

                }

                if (in.contains("A")) {

                    int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                    posicioni = posiciones[0];
                    posicionj = posiciones[1];
                    if (posicioni != 0 && tablero[posicioni - 1][posicionj] == 0) {
                        tablero[posicioni - 1][posicionj] = tablero[posicioni][posicionj];
                        tablero[posicioni][posicionj] = 0;
                        setearPosiciones(ficha, resultado, posicioni - 1, posicionj);
                        partida.getListaMovimientos().add(in);
                        partida.getColores().add(color);
                        imprimir(tablero, ver);
                        esPosible = posiblesMovimientos(posicioni - 1, posicionj, tablero).getEsPosible();
                        if (esPosible) {
                            contador++;
                        }

                        contador++;
                        pasar = true;
                    } else {
                        System.out.println("Este movimiento no es posible, porque ya esta ocupado");
                    }
                }

                if (in.contains("I")) {
                    int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                    posicioni = posiciones[0];
                    posicionj = posiciones[1];
                    if (posicionj != 0 && tablero[posicioni - 1][posicionj - 1] == 0) {
                        tablero[posicioni - 1][posicionj - 1] = tablero[posicioni][posicionj];
                        tablero[posicioni][posicionj] = 0;
                        setearPosiciones(ficha, resultado, posicioni - 1, posicionj - 1);
                        partida.getListaMovimientos().add(in);
                        partida.getColores().add(color);
                        imprimir(tablero, ver);
                        esPosible = posiblesMovimientos(posicioni - 1, posicionj - 1, tablero).getEsPosible();
                        contador++;
                        if (esPosible) {
                            contador++;
                        }

                        pasar = true;
                    } else {
                        System.out.println("No se puede hacer el movimiento");
                    }

                }
            }
        } else {
            boolean turno = true;
            while (turno) {
                System.out.println("Jugador azul, eliga un movimiento");
                String in;
                Scanner intro = new Scanner(System.in);
                in = intro.nextLine();
                String result = in.replaceAll("[^0-9]+", "");
                if (in.length() == 4) {
                    if (in.equals("VERR")) {
                        ver = true;
                        result = "";
                    }
                    if (in.equals("VERN")) {
                        ver = false;
                        result = "";
                    }

                }
                boolean esx = in.equals("X");
                if (in.length() == 1) {
                    if (in.equals("X")) {
                        System.out.println("Termino la partida");
                        turno = false;
                        salir = true;
                    }

                    if (!pasar) {
                        if (in.length() == 1 && (!esx)) {
                            if ((in.equals("p"))) {
                                System.out.println("Necesita hacer un movimiento para poder pasar");

                            } else {
                                System.out.println("Valor no valido, ingrese denuevo");
                            }

                        }

                    }
                }

                if (pasar) {
                    if (in.length() == 1 && (!esx)) {
                        if (in.equals("p")) {
                            turno = false;

                        } else {
                            System.out.println("Valor no valido, ingrese denuevo");
                        }
                    }
                }
                if (in.length() == 3) {
                    System.out.println("Palabra incorrecta");
                }

                if (in.length() > 4) {
                    System.out.println("Palabra incorrecta");
                }
                int resultado = 0;
                if (!result.equals("")) {
                    resultado = Integer.parseInt(result);
                }

                int posicioni = 0;
                int posicionj = 0;
                int posicioniNueva = 0;
                int posicionjNueva = 0;
                if (in.contains("D")) {
                    int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                    posicioni = posiciones[0];
                    posicionj = posiciones[1];
                    posicioniNueva = posicioni + 1;
                    posicionjNueva = posicionj + 1;

                    if (posicionj != 8 && tablero[posicioniNueva][posicionjNueva] == 0) {
                        tablero[posicioniNueva][posicionjNueva] = tablero[posicioni][posicionj];
                        tablero[posicioni][posicionj] = 0;
                        setearPosiciones(ficha, resultado, posicioniNueva, posicionjNueva);
                        partida.getListaMovimientos().add(in);
                        partida.getColores().add(color);
                        imprimir(tablero, ver);
                        turno = posiblesMovimientos(posicioniNueva, posicionjNueva, tablero).getEsPosible();
                        contador++;
                        pasar = true;
                        if (turno) {
                            contador++;
                        }

                    } else {
                        System.out.println("El movimiento no es posible");
                    }

                }

                if (in.contains("A")) {
                    int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                    posicioni = posiciones[0];
                    posicionj = posiciones[1];
                    if (posicioni != 7 && tablero[posicioni + 1][posicionj] == 0) {
                        tablero[posicioni + 1][posicionj] = tablero[posicioni][posicionj];
                        tablero[posicioni][posicionj] = 0;
                        setearPosiciones(ficha, resultado, posicioni + 1, posicionj);
                        partida.getListaMovimientos().add(in);
                        partida.getColores().add(color);
                        imprimir(tablero, ver);
                        turno = posiblesMovimientos(posicioni + 1, posicionj, tablero).getEsPosible();
                        contador++;
                        if (turno) {
                            contador++;
                        }
                        pasar = true;
                    } else {
                        System.out.println("Este movimiento no es posible, porque ya esta ocupado");
                    }
                }

                if (in.contains("I")) {
                    int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                    posicioni = posiciones[0];
                    posicionj = posiciones[1];

                    if (posicionj != 0 && tablero[posicioni + 1][posicionj - 1] == 0) {
                        tablero[posicioni + 1][posicionj - 1] = tablero[posicioni][posicionj];

                        tablero[posicioni][posicionj] = 0;
                        setearPosiciones(ficha, resultado, posicioni + 1, posicionj - 1);
                        partida.getListaMovimientos().add(in);
                        partida.getColores().add(color);
                        imprimir(tablero, ver);
                        turno = posiblesMovimientos(posicioni + 1, posicionj - 1, tablero).getEsPosible();
                        contador++;
                        pasar = true;
                        if (turno) {
                            contador++;
                        }
                    } else {
                        System.out.println("No se puede hacer el movimiento");
                    }

                }
            }

        }
        Posibles unPosibles = new Posibles(salir, fichasPosibles, tablero, contador);
        unPosibles.setVer(ver);
        return unPosibles;

    }

    

    public static void imprimirTableroVERN(int[][] unTablero) {
        for (int i = 0; i < unTablero.length; i++) {
            System.out.println("+-+-+-+-+-+-+-+-+-+");
            for (int j = 0; j < unTablero[0].length; j++) {

                if (unTablero[i][j] != 0) {

                    System.out.print("|" + unTablero[i][j]);
                } else {
                    System.out.print("| ");
                }
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("+-+-+-+-+-+-+-+-+-+");
    }

    public static void imprimirTableroVERR(int[][] unTablero) {
        for (int i = 0; i < unTablero.length; i++) {
            for (int j = 0; j < unTablero[0].length; j++) {
                if (unTablero[i][j] != 0) {
                    System.out.print(unTablero[i][j]);
                } else {
                    System.out.print("-");

                }
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void imprimir(int[][] matriz, boolean unVer) {
        System.out.println("-----JUEGO SUMA-------");
        if (unVer) {
            imprimirTableroVERR(matriz);
        } else {
            imprimirTableroVERN(matriz);

        }

    }

    public static int[] recorrerMatrizValida(int[][] matriz, int[] posicionesinvalidas, int[] posicionesjinvalidas, int numero) {
        int posicioni = 0;
        int posicionj = 0;
        int[] resultado = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] == numero) {
                    boolean invalida = false;
                    for (int k = 0; k < posicionesinvalidas.length; k++) {
                        if ((i == posicionesinvalidas[k]) && (j == posicionesjinvalidas[k])) {
                            
                            invalida = true;
                        }
                    }
                    if (!invalida) {
                        posicioni = i;
                        posicionj = j;
                    }
                }
            }
        }

        resultado[0] = posicioni;
        resultado[1] = posicionj;
        return resultado;
    }

    public static int[] generarPosicionesAbajoFila() {
        int[] posiciones = new int[9];
        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = 7;
        }
        return posiciones;
    }

    public static int[] generarPosicionesAbajoColumnas() {
        int[] posiciones = new int[9];
        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = 8 - i;
        }
        return posiciones;
    }

    public static int[] generarPosicionesArribaFila() {
        int[] posiciones = new int[9];
        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = 0;
        }
        return posiciones;
    }

    public static int[] generarPosicionesArribaColumnas() {
        int[] posiciones = new int[9];
        for (int i = 0; i < posiciones.length; i++) {
            posiciones[i] = i;
        }
        return posiciones;
    }

    public static Jugador ganador(Jugador jugadoruno, Jugador jugadordos, int condicion, int[][] tablero) {
        Jugador elganador = new Jugador();
        elganador.setAlias("Ninguno");
        if (condicion == 1) {
            int puntosJugadorUno = 0;
            int puntosJugadorDos = 0;
            for (int i = 1; i < 9; i++) {
                int[] posicionesrojas = recorrerMatrizValida(tablero, jugadordos.getFichasJugador().getPosicionesi(), jugadordos.getFichasJugador().getPosicionesj(), i);
                int[] posicionesazules = recorrerMatrizValida(tablero, jugadoruno.getFichasJugador().getPosicionesi(), jugadoruno.getFichasJugador().getPosicionesj(), i);
                if (posicionesrojas[0] <= 3) {
                    puntosJugadorUno++;
                }

                if (posicionesazules[0] > 3) {
                    puntosJugadorDos++;
                }

            }
            if (puntosJugadorUno != puntosJugadorDos) {
                if (puntosJugadorUno > puntosJugadorDos) {
                    elganador = jugadoruno;
                } else {
                    elganador = jugadordos;
                }
            }
        }
        if (condicion == 2) {
            System.out.println("Condicion 2");
            for (int i = 1; i < 9; i++) {
                int[] posicionesrojas = recorrerMatrizValida(tablero, jugadordos.getFichasJugador().getPosicionesi(), jugadordos.getFichasJugador().getPosicionesj(), i);
                int[] posicionesazules = recorrerMatrizValida(tablero, jugadoruno.getFichasJugador().getPosicionesi(), jugadoruno.getFichasJugador().getPosicionesj(), i);
                if (posicionesrojas[0] <= 3) {
                    elganador = jugadoruno;
                } else {
                    if (posicionesazules[0] > 3) {
                        elganador = jugadordos;
                    }
                }
            }
        }
        if (condicion == 3) {
            System.out.println("Condicion 3");
            int rojaspasadas = 0;
            int azulespasadas = 0;
            for (int i = 1; i < 9; i++) {
                int[] posicionesrojas = recorrerMatrizValida(tablero, jugadordos.getFichasJugador().getPosicionesi(), jugadordos.getFichasJugador().getPosicionesj(), i);
                int[] posicionesazules = recorrerMatrizValida(tablero, jugadoruno.getFichasJugador().getPosicionesi(), jugadoruno.getFichasJugador().getPosicionesj(), i);
                if (posicionesrojas[0] <= 3) {
                    rojaspasadas++;
                }
                if (posicionesazules[0] > 3) {
                    azulespasadas++;
                }
            }
            if (rojaspasadas == 8) {
                elganador = jugadoruno;
            }
            if (azulespasadas == 8) {
                elganador = jugadordos;
            }
        }

        return elganador;
    }

    public static boolean verificarPaso(int mat[][], Jugador rojo, Jugador azul) {
        boolean nopaso = true;
        for (int i = 1; i < 9; i++) {
            int[] posicionesrojas = recorrerMatrizValida(mat, azul.getFichasJugador().getPosicionesi(), azul.getFichasJugador().getPosicionesj(), i);
            int[] posicionesazules = recorrerMatrizValida(mat, rojo.getFichasJugador().getPosicionesi(), rojo.getFichasJugador().getPosicionesj(), i);
            if (posicionesrojas[0] <= 3) {
                nopaso = false;
            }
            if (posicionesazules[0] > 3) {
                nopaso = false;
            }
        }
        return nopaso;
    }

}
