package Exemplo2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppGrafica extends JFrame {

    //CONSTRUTOR
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public AppGrafica(){
        setTitle("Aplicação Gráfica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        init();
    }

    public void init(){

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p1.setBorder(BorderFactory.createTitledBorder("Titulo"));
        p2.setBorder(BorderFactory.createEtchedBorder());
        p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p4.setBorder(BorderFactory.createRaisedBevelBorder());
        p5.setBorder(BorderFactory.createLoweredBevelBorder());
        p6.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,3,5,5));
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        add(p);

    }

    public static void main(String[] args) {
        AppGrafica app = new AppGrafica();
        app.setVisible(true);
    }

}
