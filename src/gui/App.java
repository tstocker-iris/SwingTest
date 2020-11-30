package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private JPanel mainPanel;
    private JButton btnHelloWorld;

    public App() {
        btnHelloWorld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "HelloWorld");
            }
        });
    }

    public static void main(String[] args) {
        // On créer une fenêtre
        JFrame frame = new JFrame("App");
        // On définit le contenu de notre fenêtre avec le contenu du notre panneau
        frame.setContentPane(new App().mainPanel);
        // On définit l'action lors du clic sur la croix de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // On définit la taille de notre fenêtre par défaut
        frame.pack();
        // On affiche la fenêtre
        frame.setVisible(true);
    }
}
