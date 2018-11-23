package paqueteInterfaz;

import PackageJuego.Sistema;

public class MainVisual {

    public static void main(String args[]) {
        Sistema sistemaVisual = new Sistema();
        MenuPrincipal menu = new MenuPrincipal(sistemaVisual);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(0);
        menu.pack();
        menu.setLocationRelativeTo(null);
    }
}
