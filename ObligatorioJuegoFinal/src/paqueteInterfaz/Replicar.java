/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteInterfaz;

import PackageJuego.Ficha;
import PackageJuego.JuegoMain;
import PackageJuego.Jugador;
import PackageJuego.Partida;
import PackageJuego.Sistema;
import PackageJuego.Tablero1;
import static PackageJuego.Tablero1.generarPosicionesAbajoColumnas;
import static PackageJuego.Tablero1.generarPosicionesAbajoFila;
import static PackageJuego.Tablero1.generarPosicionesArribaColumnas;
import static PackageJuego.Tablero1.generarPosicionesArribaFila;
import static PackageJuego.Tablero1.imprimir;
import static PackageJuego.Tablero1.recorrerMatrizValida;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import static paqueteInterfaz.Tablero.buttonaInt;
import static paqueteInterfaz.Tablero.mostrarOptionpane;

public class Replicar extends javax.swing.JFrame {

    Sistema sistema;
    static Partida replica;
    ArrayList<String> movimientos;
    ArrayList<Integer> colores;
    private static JButton[][] botonesFinal;
    static Ficha fichaRoja;
    static Ficha fichaAzul;
    static int contador;

    public Replicar(Sistema sistema, Partida unaPartida) {
        this.sistema = sistema;
        replica = unaPartida;
        movimientos = unaPartida.getListaMovimientos();
        fichaRoja = new Ficha("rojo", generarPosicionesAbajoFila(), generarPosicionesAbajoColumnas(), unaPartida);
        fichaAzul = new Ficha("azul", generarPosicionesArribaFila(), generarPosicionesArribaColumnas(), unaPartida);
        int[] posicionesiValidasRojas = fichaRoja.getPosicionesi();
        int[] posicionesjValidasRojas = fichaRoja.getPosicionesj();
        int[] posicionesiValidasAzules = fichaAzul.getPosicionesi();
        int[] posicionesjValidasAzules = fichaAzul.getPosicionesj();
        colores = replica.getColores();
        replica.getJugadorUno().setFichasJugador(fichaRoja);
        replica.getJugadorDos().setFichasJugador(fichaAzul);
        initComponents();
        horaPartida.setText(unaPartida.getHora().toString());
        panelJuego.setLayout(new GridLayout(8, 9));
        botonesFinal = new JButton[8][9];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 8; j++) {
                int numero = 11;
                JButton jButton = new JButton();
                panelJuego.add(jButton);
                botonesFinal[i][j] = jButton;
                botonesFinal[i][j].setMargin(new Insets(-5, -5, -5, -5));
                boolean valida = false;
                boolean valida2 = false;
                for (int m = 1; m < fichaRoja.getPosicionesi().length; m++) {
                    if ((i == posicionesiValidasRojas[m]) && (j == posicionesjValidasRojas[m])) {
                        valida = true;
                        numero = m;
                    }
                    if ((i == posicionesiValidasAzules[m]) && (j == posicionesjValidasAzules[m])) {
                        valida2 = true;
                        numero = m;
                    }
                }
                if (valida) {
                    botonesFinal[i][j].setBackground(Color.red);
                    botonesFinal[i][j].setText(Integer.toString(numero));

                }
                if (valida2) {
                    botonesFinal[i][j].setBackground(Color.blue);
                    botonesFinal[i][j].setText(Integer.toString(numero));
                }
            }
        }
    }

    public static void movimientoParm(JButton[][] unTablero, Partida partida) {
        int[][] tablero = buttonaInt(unTablero);
        ArrayList<String> movimientos = partida.getListaMovimientos();
        ArrayList<Integer> colores = partida.getColores();
        Jugador jugadorUno = partida.getJugadorUno();
        Jugador jugadorDos = partida.getJugadorDos();
        jugadorUno.setFichasJugador(fichaRoja);
        jugadorDos.setFichasJugador(fichaAzul);
        int i = contador;
        String mov = movimientos.get(i);
        System.out.println("Movimiento:" + mov);
        int color = colores.get(i);
        System.out.println("Color:" + color);
        if (color == 0) {
            System.out.println("Entra en rojo");
            int[] fichasiinvalidas = jugadorDos.getFichasJugador().getPosicionesi();
            int[] fichasjinvalidas = jugadorDos.getFichasJugador().getPosicionesj();
            String result = mov.replaceAll("[^0-9]+", "");
            int resultado = Integer.parseInt(result);
            int posicioni = 0;
            int posicionj = 0;
            int posicioniNueva = 0;
            int posicionjNueva = 0;
            for (int l = 0; l < fichasiinvalidas.length; l++) {
                System.out.println("fichainvalida numero" + l);
                System.out.println("i" + fichasiinvalidas[l]);
                System.out.println("j" + fichasjinvalidas[l]);
            }
            if (mov.contains("D")) {
                int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                posicioni = posiciones[0];
                posicionj = posiciones[1];
                posicioniNueva = posicioni - 1;
                posicionjNueva = posicionj + 1;
                moverFichaRep(posicioni, posicionj, posicioniNueva, posicionjNueva,fichaRoja);
                jugadorUno.setFichasJugador(fichaRoja);
            }

            if (mov.contains("A")) {
                int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                posicioni = posiciones[0];
                posicionj = posiciones[1];
                posicioniNueva = posicioni - 1;
                posicionjNueva = posicionj;
                moverFichaRep(posicioni, posicionj, posicioniNueva, posicionjNueva,fichaRoja);
                jugadorUno.setFichasJugador(fichaRoja);

            }

            if (mov.contains("I")) {
                int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                posicioni = posiciones[0];
                posicionj = posiciones[1];
                posicioniNueva = posicioni - 1;
                posicionjNueva = posicionj - 1;
                moverFichaRep(posicioni, posicionj, posicioniNueva, posicionjNueva,fichaRoja);
                jugadorUno.setFichasJugador(fichaRoja);

            }
        } else {
            System.out.println("Entra en azul");
            int[] fichasiinvalidas = jugadorUno.getFichasJugador().getPosicionesi();
            int[] fichasjinvalidas = jugadorUno.getFichasJugador().getPosicionesj();
            String result = mov.replaceAll("[^0-9]+", "");
            int resultado = Integer.parseInt(result);
            int posicioni = 0;
            int posicionj = 0;
            int posicioniNueva = 0;
            int posicionjNueva = 0;
            String in;
            for (int l = 0; l < fichasiinvalidas.length; l++) {
                System.out.println("fichainvalida numero" + l);
                System.out.println("i" + fichasiinvalidas[l]);
                System.out.println("j" + fichasjinvalidas[l]);
            }
            if (mov.contains("D")) {
                int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                System.out.println("Posicioni" + posiciones[0]);
                System.out.println("Posicionj" + posiciones[1]);
                posicioni = posiciones[0];
                posicionj = posiciones[1];
                posicioniNueva = posicioni + 1;
                posicionjNueva = posicionj + 1;
                moverFichaRep(posicioni, posicionj, posicioniNueva, posicionjNueva,fichaAzul);
                jugadorDos.setFichasJugador(fichaAzul);
            }

            if (mov.contains("A")) {
                int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                posicioni = posiciones[0];
                posicionj = posiciones[1];
                System.out.println("Posicioni" + posicioni);
                System.out.println("Posicionj" + posicionj);
                posicioniNueva = posicioni + 1;
                posicionjNueva = posicionj;
                moverFichaRep(posicioni, posicionj, posicioniNueva, posicionjNueva,fichaAzul);
                jugadorDos.setFichasJugador(fichaAzul);
            }

            if (mov.contains("I")) {
                int[] posiciones = recorrerMatrizValida(tablero, fichasiinvalidas, fichasjinvalidas, resultado);
                System.out.println("Posicionj" + posiciones[1]);
                System.out.println("Posicioni" + posicioni);
                posicioni = posiciones[0];
                posicionj = posiciones[1];
                posicioniNueva = posicioni + 1;
                posicionjNueva = posicionj - 1;
                moverFichaRep(posicioni, posicionj, posicioniNueva, posicionjNueva,fichaAzul);
                jugadorDos.setFichasJugador(fichaAzul);
            }

        }

    }

    public static void moverFichaRep(int x, int y, int xNueva, int yNueva,Ficha fichas) {
        Color color = botonesFinal[x][y].getBackground();
        String textoFichaAnterior = botonesFinal[x][y].getText();
        botonesFinal[xNueva][yNueva].setBackground(color);
        botonesFinal[xNueva][yNueva].setText(textoFichaAnterior);
        botonesFinal[x][y].setBackground(null);
        botonesFinal[x][y].setText("");
        if (color.equals(Color.red)) {
            JuegoMain.setearPosiciones(fichas, Integer.parseInt(textoFichaAnterior), xNueva, yNueva);

        } else {
            JuegoMain.setearPosiciones(fichas, Integer.parseInt(textoFichaAnterior), xNueva, yNueva);
        }

    }

    public static boolean esRoja(int x, int y) {
        boolean esRoja = false;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 8; j++) {
                for (int m = 1; m < fichaRoja.getPosicionesi().length; m++) {
                    if ((x == fichaRoja.getPosicionesi()[m]) && (y == fichaRoja.getPosicionesj()[m])) {
                        esRoja = true;
                    }

                }

            }
        }
        return esRoja;
    }

    public static boolean esAzul(int x, int y) {
        boolean esAzul = false;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 8; j++) {
                for (int m = 1; m < fichaAzul.getPosicionesi().length; m++) {
                    if ((x == fichaAzul.getPosicionesi()[m]) && (y == fichaAzul.getPosicionesj()[m])) {
                        esAzul = true;
                    }

                }

            }
        }
        return esAzul;
    }

    public static String direccionMovimiento(int xAnterior, int yAnterior, int x, int y) {
        String direccion = "";
        boolean anteriorRoja = esRoja(x, y);
        boolean anteriorAzul = esAzul(x, y);
        if (anteriorRoja) {
            //rojo izquierda
            if (xAnterior == x + 1 && yAnterior == y + 1) {
                direccion = "I";
            }
            //rojo adelante
            if (xAnterior == x + 1 && yAnterior == y) {
                direccion = "A";
            }
            //rojo derecha
            if (xAnterior == x + 1 && yAnterior == y - 1) {
                direccion = "D";
            }
        }
        if (anteriorAzul) {
            //azul izquierda
            if (xAnterior == x - 1 && yAnterior == y + 1) {
                direccion = "I";
            }
            //azul adelante
            if (xAnterior == x - 1 && yAnterior == y) {
                direccion = "A";
            }
            //azul derecha
            if (xAnterior == x - 1 && yAnterior == y - 1) {
                direccion = "D";
            }

        }
        return direccion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        siguienteMov = new javax.swing.JButton();
        horaPartida = new javax.swing.JTextField();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelJuego.setLayout(null);

        siguienteMov.setText("Siguiente Movimiento");
        siguienteMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteMovActionPerformed(evt);
            }
        });

        horaPartida.setEditable(false);
        horaPartida.setText("horaPartida");

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(horaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(siguienteMov, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguienteMov)
                    .addComponent(horaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteMovActionPerformed
        // TODO add your handling code here:
        if (contador < replica.getListaMovimientos().size()) {
            System.out.println(replica.getListaMovimientos().size());
            movimientoParm(botonesFinal, replica);
            contador++;
        } else {
            mostrarOptionpane("Todas los movimientos mostrados", "Exito", 1);
        }
    }//GEN-LAST:event_siguienteMovActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField horaPartida;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JButton salir;
    private javax.swing.JButton siguienteMov;
    // End of variables declaration//GEN-END:variables
}
