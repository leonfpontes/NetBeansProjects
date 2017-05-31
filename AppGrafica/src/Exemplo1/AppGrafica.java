package Exemplo1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppGrafica extends JFrame implements ActionListener {
    
    private JLabel l;
    int i = -1;
    
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
        
        b.addActionListener(this);
        
        add(b);
        add(l);
    }

    public static void main(String[] args) {
        AppGrafica app = new AppGrafica();
        app.setVisible(true);
    }
    
    private void atualizar(){
        i++;
        l.setText("Clicou " + i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        atualizar();
    }
    
}
