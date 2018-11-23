//author Valentin Sanchez Ignacio Pigatto
package PackageJuego;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import paqueteInterfaz.MenuPrincipal;

public class JuegoMain {

    public static void main(String[] args) throws IOException {
        Sistema sistema = new Sistema();

        //Deserializacion de sistema anterior
        try {

            FileInputStream fileIn = new FileInputStream("/tmp/system.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sistema = (Sistema) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Clase sistema anterior no encontrada");
            c.printStackTrace();
            return;
        }

        //Grabacion de archivo
        String fileSeparator = System.getProperty("file.separator");

        //absolute file name with path
        String absoluteFilePath = fileSeparator + "Users" + fileSeparator + "ValentinAdmin" + fileSeparator + "Documents" + fileSeparator + "NetBeansProjects" + fileSeparator + "ObligatorioJuego" + fileSeparator + "file.txt";
        File file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println(absoluteFilePath + " File Created");
        } else {
            System.out.println("File " + absoluteFilePath + " already exists");
        }

        //file name only
        file = new File("file.txt");
        if (file.createNewFile()) {
            System.out.println("file.txt File Created in Project root directory");
        } else {
            System.out.println("File file.txt already exists in project root directory");
        }

        //Trabajo con sistema y lo modifico
        iniciarMenu(sistema);
        MenuPrincipal menu = new MenuPrincipal(sistema);

        //Serializo el sistema modificado
        try {
            FileOutputStream fileOut
                    = new FileOutputStream("/tmp/system.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sistema);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/system.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    private static void iniciarMenu(Sistema sistema) {
        Scanner scan = new Scanner(System.in);
        int opcionElegida = 0;
        while (opcionElegida != 5) {
            imprimirMenu();
            opcionElegida = pedirUnIntValidado(1, 5, "Eliga una Opción de el 1 al 5 :",
                    "Ingrese nuevamente! (1-5) :");
            switch (opcionElegida) {
                case 1: //BIEN
                    System.out.println("\n- Registrar un nuevo jugador -\n");
                    sistema.altaJugador(sistema);
                    break;
                case 2://BIEN
                    System.out.println("\n- Jugar-\n");
                    if (sistema.getListaJugadores().size() >= 2) {
                        sistema.jugar(sistema, 8, 9);
                    } else {
                        System.out.println("No hay suficientes jugadores! Deben haber almenos 2");
                    }
                    break;
                case 3://BIEN
                    System.out.println("\n- Historial -\n");
                    sistema.historial(sistema);
                    break;
                case 4://BIEN
                    System.out.println("\n- Ranking -\n");
                    sistema.imprimirRanking(sistema);
                    break;
                case 5://BIEN
                    System.out.println("\n- Cerrar aplicacion -\n");
                    break;

            }//Fin del Switch
        }//Fin del While
    }//Fin metodo InicioMenu

    private static void imprimirMenu() {
        java.lang.System.out.println("\n  *****************************");
        java.lang.System.out.println("  *      MENU PRINCIPAL       *");
        java.lang.System.out.println("  *****************************");
        java.lang.System.out.println("\nMenú de Opciones :\n");
        java.lang.System.out.println("1 - Nuevo registro de jugador.");
        java.lang.System.out.println("2 - Jugar");
        java.lang.System.out.println("3 - Historial");
        java.lang.System.out.println("4 - Ranking");
        java.lang.System.out.println("5 - Cerrar aplicacion \n");
    }

    public static int pedirUnIntValidado(int desde, int hasta, String textoInstruccion, String textoError) {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        int dato = 0;
        while (!done) {
            try {
                System.out.println(textoInstruccion);
                dato = scan.nextInt();

                while (!validarPorRango(dato, desde, hasta)) {
                    System.out.println(textoError);
                    dato = scan.nextInt();
                }
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese solo Números!");
                scan.nextLine();
            }
        }
        return dato;
    }

  

    public static boolean validarPorRango(int dato, int desde, int hasta) {
        return desde <= dato && dato <= hasta;
    }//Fin metodo validarPorRango

    public static void setearPosiciones(Ficha ficha, int numficha, int posicioninueva, int posicionjnueva) {
        int[] nuevasposicionesi = ficha.getPosicionesi();
        int[] nuevasposicionesj = ficha.getPosicionesj();
        nuevasposicionesi[numficha] = posicioninueva;
        nuevasposicionesj[numficha] = posicionjnueva;
        ficha.setPosicionesi(nuevasposicionesi);
        ficha.setPosicionesj(nuevasposicionesj);
    }

    public static Posibles posiblesMovimientos(int unNroFila, int unNroColumna, int[][] matriz) {
        Posibles instancia;
        ArrayList<Integer> fichasPosibles = new ArrayList<>();
        boolean esPosible = true;
        int filas = 8;
        int columnas = 9;
        int cont = 1;
        int sumaDiagonalD = 0;
        int sumaDiagonalI = 0;
        int sumaHorizontal = 0;
        int sumaVertical = 0;
        if (unNroFila < filas && unNroColumna < columnas) {
            int elem = matriz[unNroFila][unNroColumna];
            int x = 0;
            if (columnas > filas) {
                x = columnas;
            } else {
                x = filas;
            }

            while (cont < 10) {
                if (unNroFila + cont < filas && unNroColumna + cont < columnas) {
                    sumaDiagonalD = sumaDiagonalD + matriz[unNroFila + cont][unNroColumna + cont];
                }
                if (unNroFila + cont < filas && unNroColumna - cont >= 0) {
                    sumaDiagonalI = sumaDiagonalI + matriz[unNroFila + cont][unNroColumna - cont];
                }
                if (unNroColumna + cont < columnas && unNroFila - cont >= 0) {
                    sumaDiagonalI = sumaDiagonalI + matriz[unNroFila - cont][unNroColumna + cont];
                }
                if (unNroColumna - cont >= 0 && unNroFila - cont >= 0) {
                    sumaDiagonalD = sumaDiagonalD + matriz[unNroFila - cont][unNroColumna - cont];
                }
                cont++;
            }

            for (int n = 0; n < 9; n++) {
                sumaHorizontal = sumaHorizontal + matriz[unNroFila][n];
            }

            for (int p = 0; p < 8; p++) {
                sumaVertical = sumaVertical + matriz[p][unNroColumna];
            }

            sumaDiagonalI = sumaDiagonalI + elem;
            sumaDiagonalD = sumaDiagonalD + elem;
            if (sumaDiagonalD != elem && sumaDiagonalD > 0 && sumaDiagonalD < 9) {
                System.out.println("Puede mover " + sumaDiagonalD);
                fichasPosibles.add(sumaDiagonalD);
            }

            if (sumaDiagonalI != elem && sumaDiagonalI > 0 && sumaDiagonalI < 9) {
                System.out.println("Puede mover " + sumaDiagonalI);
                fichasPosibles.add(sumaDiagonalI);

            }

            if (sumaHorizontal != elem && sumaHorizontal > 0 && sumaHorizontal < 9) {
                System.out.println("Puede mover " + sumaHorizontal);
                fichasPosibles.add(sumaHorizontal);

            }
            if (sumaVertical != elem && sumaVertical > 0 && sumaVertical < 9) {
                System.out.println("Puede mover " + sumaVertical);
                fichasPosibles.add(sumaVertical);
            }
            if ((sumaVertical == elem || sumaVertical == 0 || sumaVertical > 8) && (sumaHorizontal == elem || sumaHorizontal == 0 || sumaHorizontal > 8)
                    && (sumaDiagonalD == elem || sumaDiagonalD == 0 || sumaDiagonalD > 8) && (sumaDiagonalI == elem || sumaDiagonalI == 0 || sumaDiagonalI > 8)) {
                System.out.println("No puede realizar movimientos, siguiente turno");
                esPosible = false;
            }
        }
        instancia = new Posibles(esPosible, fichasPosibles, new int[8][9], 0);

        return instancia;
    }

  
   
    
    public static void enterContinuar() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

    
}
