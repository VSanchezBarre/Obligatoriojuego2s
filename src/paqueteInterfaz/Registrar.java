package paqueteInterfaz;

import PackageJuego.Jugador;
import PackageJuego.Sistema;
import java.util.ArrayList;
import javax.swing.JList;

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
        this.jlistJugadores = new JList(listaAlias.toArray());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jlistJugadores = new javax.swing.JList<>();
        aliasRojo = new javax.swing.JTextField();
        edadRojo = new javax.swing.JTextField();
        labelAlias = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        botonEnter = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        titulo = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tituloLista = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        nombreRojo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        labelNombre1 = new javax.swing.JLabel();
        labelAlias1 = new javax.swing.JLabel();
        nombreAzul = new javax.swing.JTextField();
        aliasAzul = new javax.swing.JTextField();
        labelEdad1 = new javax.swing.JLabel();
        edadAzul = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlistJugadores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlistJugadores);

        aliasRojo.setText("Alias");

        edadRojo.setText("Edad");

        labelAlias.setText("Alias");

        labelEdad.setText("Edad");

        botonEnter.setText("ENTER");
        botonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnterActionPerformed(evt);
            }
        });

        titulo.setText("Registrar jugadores");
        jScrollPane3.setViewportView(titulo);

        tituloLista.setText("Lista de jugadores");
        jScrollPane5.setViewportView(tituloLista);

        labelNombre.setText("Nombre");

        nombreRojo.setText("Nombre");
        nombreRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreRojoActionPerformed(evt);
            }
        });

        jTextPane1.setText("Jugador Rojo");
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelNombre)
                .addGap(18, 18, 18)
                .addComponent(nombreRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(nombreRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        labelNombre1.setText("Nombre");

        labelAlias1.setText("Alias");

        nombreAzul.setText("Nombre");
        nombreAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreAzulActionPerformed(evt);
            }
        });

        aliasAzul.setText("Alias");

        labelEdad1.setText("Edad");

        edadAzul.setText("Edad");

        jTextPane2.setText("Jugador Azul");
        jScrollPane4.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(botonEnter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAlias)
                            .addComponent(labelEdad))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edadRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aliasRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEdad1)
                                    .addComponent(labelAlias1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(labelNombre1)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aliasAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edadAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(242, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aliasRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAlias)
                            .addComponent(labelAlias1)
                            .addComponent(aliasAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNombre1)
                                .addComponent(nombreAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEdad)
                            .addComponent(edadRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEdad1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(edadAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEnter)
                .addGap(169, 169, 169))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnterActionPerformed
//joptionpane
    if(!aliasRojo.getText().trim().equals("")){
        
    }
        jugadorRojo.setNombre(nombreRojo.getText());
        jugadorRojo.setAlias(aliasRojo.getText());
        jugadorRojo.setEdad(Integer.parseInt(edadRojo.getText()));
        jugadorAzul.setNombre(nombreAzul.getText());
        jugadorAzul.setAlias(aliasAzul.getText());
        jugadorAzul.setEdad(Integer.parseInt(edadAzul.getText()));
        listaJugadores.add(jugadorRojo);
        listaJugadores.add(jugadorAzul);
    }//GEN-LAST:event_botonEnterActionPerformed

    private void nombreAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreAzulActionPerformed

    private void nombreRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreRojoActionPerformed

    }//GEN-LAST:event_nombreRojoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aliasAzul;
    private javax.swing.JTextField aliasRojo;
    private javax.swing.JButton botonEnter;
    private javax.swing.JTextField edadAzul;
    private javax.swing.JTextField edadRojo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JList<String> jlistJugadores;
    private javax.swing.JLabel labelAlias;
    private javax.swing.JLabel labelAlias1;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelEdad1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JTextField nombreAzul;
    private javax.swing.JTextField nombreRojo;
    private javax.swing.JTextPane titulo;
    private javax.swing.JTextPane tituloLista;
    // End of variables declaration//GEN-END:variables
}
