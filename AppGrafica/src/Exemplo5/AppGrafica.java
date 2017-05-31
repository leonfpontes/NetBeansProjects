package Exemplo5;

import Exemplo3.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppGrafica extends JFrame {
    
    private JLabel l;
    int i = -1;
    
    //CONSTRUTOR
    public AppGrafica(){
        setTitle("Aplicação Gráfica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        init();
        pack();
        atualizar();
    }
    
    public void atualizar(){
        i++;
        l.setText("Clicou " + i);
    }
    
    private void init(){
        JButton b = new JButton("Clique Aqui!");
        l = new JLabel("Contador: ");
        
        b.addMouseListener(new ButtonAppListener());
        
        add(b);
        add(l);
    }

    public static void main(String[] args) {
        AppGrafica app = new AppGrafica();
        app.setVisible(true);
    }
    
    private class ButtonAppListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouseClicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("mousePressed");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("mouseReleased");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("mouseEntered");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("mouseExited");
        }

        
    }

}
