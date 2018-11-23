package paqueteInterfaz;

import PackageJuego.Jugador;
import PackageJuego.Sistema;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class Registrar extends javax.swing.JFrame {
    Sistema sistema;
    ArrayList<Jugador> listaJugadores;
    ArrayList<String> listaAlias;
    Jugador jugadorRojo, jugadorAzul;
  

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Registrar(Sistema sistema) {
        this.sistema = sistema;
        this.listaJugadores = sistema.getListaJugadores();
        this.listaAlias = crearListaAlias(sistema);
        if (!listaJugadores.isEmpty()) {
            this.jugadorRojo = listaJugadores.get(0);
            this.jugadorAzul = listaJugadores.get(1);
        } else {
            this.jugadorRojo = new Jugador();
            this.jugadorAzul = new Jugador();
        }
        initComponents();
    }

    public ArrayList<String> crearListaAlias(Sistema sistema) {
        ArrayList<String> listaAlias = new ArrayList<>();
        for (int i = 0; i < listaJugadores.size(); i++) {
            String alias = listaJugadores.get(i).getAlias();
            listaAlias.add(alias);
        }

        return listaAlias;
    }

    public Registrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aliasRojo = new javax.swing.JTextField();
        edadRojo = new javax.swing.JTextField();
        labelAlias = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        botonEnter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        nombreRojo = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        titulo = new javax.swing.JTextPane();
        labelNombre1 = new javax.swing.JLabel();
        labelAlias1 = new javax.swing.JLabel();
        nombreAzul = new javax.swing.JTextField();
        aliasAzul = new javax.swing.JTextField();
        labelEdad1 = new javax.swing.JLabel();
        edadAzul = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        labelNombre2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aliasRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aliasRojoActionPerformed(evt);
            }
        });

        edadRojo.setText("0");
        edadRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edadRojoActionPerformed(evt);
            }
        });

        labelAlias.setText("Alias");

        labelEdad.setText("Edad");

        botonEnter.setText("ENTER");
        botonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnterActionPerformed(evt);
            }
        });

        jTextPane1.setText("Jugador Rojo");
        jScrollPane2.setViewportView(jTextPane1);

        nombreRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreRojoActionPerformed(evt);
            }
        });

        labelNombre.setText("Nombre");

        titulo.setText("Registrar jugadores");
        jScrollPane3.setViewportView(titulo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(18, 18, 18)
                        .addComponent(nombreRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre)))
        );

        labelNombre1.setText("Nombre");

        labelAlias1.setText("Alias");

        nombreAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAzulActionPerformed(evt);
            }
        });

        labelEdad1.setText("Edad");

        edadAzul.setText("0");

        jTextPane2.setText("Jugador Azul");
        jScrollPane4.setViewportView(jTextPane2);

        labelNombre2.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelEdad)
                            .addComponent(labelAlias)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(botonEnter)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aliasRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAlias1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNombre1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aliasAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNombre2)
                                .addGap(18, 18, 18)
                                .addComponent(nombreAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edadRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEdad1)
                        .addGap(33, 33, 33)
                        .addComponent(edadAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre1)
                            .addComponent(labelNombre2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aliasAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAlias1)
                    .addComponent(aliasRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAlias))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edadAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEdad1)
                    .addComponent(edadRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(botonEnter)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnterActionPerformed
//joptionpane
        String mensajeError = "El alias no puede quedar vacio";
        String mensajeCorrecto = "Jugadores agregados con exito";
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        if (aliasRojo.getText().trim().equals("") || aliasAzul.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(frame, mensajeError, "Error alias", JOptionPane.ERROR_MESSAGE);

        } else {
            jugadorRojo.setNombre(nombreRojo.getText());
            jugadorRojo.setAlias(aliasRojo.getText());
            jugadorRojo.setEdad(Integer.parseInt(edadRojo.getText()));
            jugadorAzul.setNombre(nombreAzul.getText());
            jugadorAzul.setAlias(aliasAzul.getText());
            jugadorAzul.setEdad(Integer.parseInt(edadAzul.getText()));
            sistema.agregarJugador(jugadorRojo);
            sistema.agregarJugador(jugadorAzul);
            JOptionPane.showMessageDialog(frame, mensajeCorrecto, "Exito!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_botonEnterActionPerformed

    private void nombreAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreAzulActionPerformed

    private void nombreRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreRojoActionPerformed

    }//GEN-LAST:event_nombreRojoActionPerformed

    private void aliasRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aliasRojoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aliasRojoActionPerformed

    private void edadRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edadRojoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edadRojoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
    
            }
        }
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aliasAzul;
    private javax.swing.JTextField aliasRojo;
    private javax.swing.JButton botonEnter;
    private javax.swing.JTextField edadAzul;
    private javax.swing.JTextField edadRojo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel labelAlias;
    private javax.swing.JLabel labelAlias1;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelEdad1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelNombre2;
    private javax.swing.JTextField nombreAzul;
    private javax.swing.JTextField nombreRojo;
    private javax.swing.JTextPane titulo;
    // End of variables declaration//GEN-END:variables
}
