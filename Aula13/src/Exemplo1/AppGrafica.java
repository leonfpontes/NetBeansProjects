package Exemplo1;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class AppGrafica extends JFrame {

    //CONSTRUTOR
    public AppGrafica(){
        setTitle("Aplicação Gráfica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(800, 600);
        addWindowListener(new AppListener());
    }

    public static void main(String[] args) {
        AppGrafica app = new AppGrafica();
        app.setVisible(true);
    }

    private class AppListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("WindowOpened");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("windowClosing");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            System.out.println("windowClosed");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("windowIconified");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println("windowDeiconified");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("windowActivated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("windowDeactivated");
        }

    }

}
