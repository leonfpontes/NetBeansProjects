package Exemplo2;

import java.awt.FlowLayout;
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
    
    private void init(){
        JButton b = new JButton("Clique Aqui!");
        l = new JLabel("Contador: ");
        
        b.addActionListener(new ButtonAppListener(this));
        
        add(b);
        add(l);
    }

    public static void main(String[] args) {
        AppGrafica app = new AppGrafica();
        app.setVisible(true);
    }
    
    public void atualizar(){
        i++;
        l.setText("Clicou " + i);
    }

}
