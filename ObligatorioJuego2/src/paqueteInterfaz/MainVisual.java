package paqueteInterfaz;

import PackageJuego.Sistema;
import java.awt.Color;
import java.awt.Dimension;

public class MainVisual {

    public static void main(String args[]) {
        Sistema sistemaVisual = new Sistema();
        MenuPrincipal menu = new MenuPrincipal(sistemaVisual);
        menu.setSize(new Dimension(1335, 675));
        menu.setMaximumSize(new Dimension(1335, 675));
        menu.setMinimumSize(new Dimension(1335, 675));
        menu.setSize(1335, 675);
        menu.setDefaultCloseOperation(0);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setBackground(Color.blue);
        menu.setVisible(true);
    }
}
