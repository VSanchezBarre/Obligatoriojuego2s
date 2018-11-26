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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edadRojo = new javax.swing.JTextField();
        labelAlias = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        botonEnter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nombreRojo = new javax.swing.JTextField();
        aliasRojo = new javax.swing.JTextField();
        labelNombre2 = new javax.swing.JLabel();
        labelAlias1 = new javax.swing.JLabel();
        aliasAzul = new javax.swing.JTextField();
        nombreAzul = new javax.swing.JTextField();
        labelEdad1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        titulo = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        labelNombre = new javax.swing.JLabel();
        edadAzul = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        edadRojo.setText("0");
        edadRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edadRojoActionPerformed(evt);
            }
        });

        labelAlias.setText("Alias");

        labelEdad.setText("Edad");

        botonEnter.setBackground(new java.awt.Color(102, 255, 102));
        botonEnter.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        botonEnter.setText("ENTER");
        botonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnterActionPerformed(evt);
            }
        });

        nombreRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreRojoActionPerformed(evt);
            }
        });

        aliasRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aliasRojoActionPerformed(evt);
            }
        });

        labelNombre2.setText("Nombre");

        labelAlias1.setText("Alias");

        nombreAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAzulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aliasRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre2)
                    .addComponent(labelAlias1))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aliasAzul)
                    .addComponent(nombreAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(aliasAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre2))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aliasRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAlias1))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        labelEdad1.setText("Edad");

        jTextPane2.setEditable(false);
        jTextPane2.setText("Jugador Azul");
        jScrollPane4.setViewportView(jTextPane2);

        titulo.setEditable(false);
        titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titulo.setText("Registrar jugadores");
        jScrollPane3.setViewportView(titulo);

        jTextPane1.setEditable(false);
        jTextPane1.setText("Jugador Rojo");
        jScrollPane2.setViewportView(jTextPane1);

        labelNombre.setText("Nombre");

        edadAzul.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272))))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre)
                    .addComponent(labelAlias)
                    .addComponent(labelEdad))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(edadRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEdad1)
                        .addGap(66, 66, 66)
                        .addComponent(edadAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(88, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(botonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(labelNombre)
                        .addGap(55, 55, 55)
                        .addComponent(labelAlias)
                        .addGap(48, 48, 48)
                        .addComponent(labelEdad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edadRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEdad1)
                                .addComponent(edadAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(botonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnterActionPerformed
//joptionpane
        String mensajeError = "Datos incorrectos, revise e ingrese denuevo(alias vacio o edad no numerica";
        String mensajeCorrecto = "Jugadores agregados con exito";
        JFrame frame = new JFrame("ERROR");
        boolean rojoNumerico = edadRojo.getText().chars().allMatch( Character::isDigit );
        boolean azulNumerico = edadAzul.getText().chars().allMatch( Character::isDigit );
        

        if (aliasRojo.getText().trim().equals("") || aliasAzul.getText().trim().equals("")|| !rojoNumerico|| !azulNumerico) {
            JOptionPane.showMessageDialog(frame, mensajeError, "Error alias", JOptionPane.ERROR_MESSAGE);

        } else {
            Jugador jugadorRojo = new Jugador();
            Jugador jugadorAzul = new Jugador();
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
    private javax.swing.JLabel labelNombre2;
    private javax.swing.JTextField nombreAzul;
    private javax.swing.JTextField nombreRojo;
    private javax.swing.JTextPane titulo;
    // End of variables declaration//GEN-END:variables
}
