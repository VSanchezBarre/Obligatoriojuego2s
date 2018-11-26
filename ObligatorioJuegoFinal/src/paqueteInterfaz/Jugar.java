package paqueteInterfaz;

import PackageJuego.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Jugar extends javax.swing.JFrame {

    private static Sistema sistema;
    private static ArrayList<Jugador> listaJugadores;
    private static ArrayList<String> listaAlias;
    private static Ficha fichasRojas;
    private static Ficha fichasAzules;
    

    public Jugar(Sistema sistema) {
        JFrame frame = new JFrame("No hay jugadores registrados");
        String mensajeError = "No hay jugadores registrados!";
        if (!sistema.getListaJugadores().isEmpty()) {
            initComponents();
            this.sistema = sistema;
            this.listaJugadores = sistema.getListaJugadores();
            this.listaAlias = crearListaAlias(sistema);
            fichasRojas = sistema.getListaFichas().get(0);
            fichasAzules = sistema.getListaFichas().get(1);
            DefaultListModel<String> model = new DefaultListModel<String>();
            for (String s : listaAlias) {
                model.addElement(s);
            }
            //this.jlistJugadores = new JList<String>(model);
            this.jlistJugadores.setModel(model);

        } else {
            JOptionPane.showMessageDialog(frame, mensajeError, "No hay jugadores registrados", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ArrayList<String> crearListaAlias(Sistema sistema) {
        ArrayList<String> listaAlias = new ArrayList<>();
        for (int i = 0; i < listaJugadores.size(); i++) {
            String alias = listaJugadores.get(i).getAlias();
            listaAlias.add(alias);
        }

        return listaAlias;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        titulo = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistJugadores = new javax.swing.JList<>();
        textoJrojo = new javax.swing.JTextField();
        textoJazul = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        labelRoja = new javax.swing.JTextPane();
        botonEnter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        labelAzul1 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        condicionVictoria = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(51, 255, 255));
        titulo.setFont(new java.awt.Font("Rubik", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 153));
        titulo.setText("Juego ");
        jScrollPane1.setViewportView(titulo);

        jlistJugadores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "item 1", "item 2", "item 3", "item 4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlistJugadores);

        textoJrojo.setText("alias");

        textoJazul.setText("alias");

        labelRoja.setEditable(false);
        labelRoja.setBackground(new java.awt.Color(255, 51, 51));
        labelRoja.setText("Seleccione al jugador rojo");
        jScrollPane4.setViewportView(labelRoja);

        botonEnter.setBackground(new java.awt.Color(102, 255, 102));
        botonEnter.setForeground(new java.awt.Color(204, 255, 102));
        botonEnter.setText("ENTER");
        botonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnterActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugadores Registrados");

        labelAzul1.setEditable(false);
        labelAzul1.setBackground(new java.awt.Color(51, 102, 255));
        labelAzul1.setText("Seleccione al jugador azul");
        jScrollPane5.setViewportView(labelAzul1);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Condicion victoria");

        condicionVictoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                condicionVictoriaActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("Cantidad de movimientos");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setText("Alcanzar el lado contrario con una ficha");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("1");

        jLabel4.setText("2");

        jTextField3.setEditable(false);
        jTextField3.setText("Todas las fichas alcanzen el lado contrario");

        jLabel5.setText("3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoJazul, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoJrojo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(condicionVictoria, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonEnter)
                        .addGap(357, 357, 357))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(312, 312, 312))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoJrojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoJazul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(condicionVictoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(botonEnter))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnterActionPerformed
        String mensajeError = "Error en los alias ingresados!";
        String mensajeCorrecto = "Comienza la partida!";
        JFrame frame = new JFrame("Error jugador no esta en la lista");
        String textoAzul = textoJazul.getText();
        String textoRojo = textoJrojo.getText();

        if (listaAlias.contains(textoAzul) && listaAlias.contains(textoRojo) && !textoAzul.equals(textoRojo) && Integer.parseInt(condicionVictoria.getText())>4 ) {
            Tablero tablero = new Tablero(sistema,sistema.traerJugador(textoRojo),sistema.traerJugador(textoAzul),Integer.parseInt(condicionVictoria.getText()));
            sistema.traerJugador(textoRojo).setFichasJugador(fichasRojas);
            sistema.traerJugador(textoAzul).setFichasJugador(fichasAzules);
            tablero.setMaximumSize(new Dimension(1335, 675));
            tablero.setMinimumSize(new Dimension(1335, 675));
            tablero.pack();
            tablero.setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(frame, mensajeCorrecto, "Exito!", JOptionPane.INFORMATION_MESSAGE);
            tablero.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(frame, mensajeError, "Error alias no existen", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_botonEnterActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void condicionVictoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_condicionVictoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_condicionVictoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnter;
    private javax.swing.JTextField condicionVictoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> jlistJugadores;
    private javax.swing.JTextPane labelAzul1;
    private javax.swing.JTextPane labelRoja;
    private javax.swing.JTextField textoJazul;
    private javax.swing.JTextField textoJrojo;
    private javax.swing.JTextPane titulo;
    // End of variables declaration//GEN-END:variables
}
