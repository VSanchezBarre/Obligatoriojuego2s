package paqueteInterfaz;

import PackageJuego.Sistema;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainVisual {

    public static void main(String args[]) {
        Sistema sistemaVisual = new Sistema();
        String filename = "sistema.ser";

        // Deserialization 
        try {
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object 
            sistemaVisual = (Sistema) in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized ");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        MenuPrincipal menu = new MenuPrincipal(sistemaVisual);
        menu.setSize(new Dimension(750, 500));
        menu.setMaximumSize(new Dimension(750, 500));
        menu.setMinimumSize(new Dimension(750, 500));
        menu.setSize(750, 500);
        menu.setDefaultCloseOperation(0);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.getContentPane().setBackground(Color.cyan);
        menu.setVisible(true);
    }
}
