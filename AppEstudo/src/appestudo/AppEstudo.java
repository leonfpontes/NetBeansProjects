package appestudo;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppEstudo extends JFrame{

    private JPanel p1;
    
    public AppEstudo(){
        
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        p1 = new JPanel();
        p1.setSize(200, 200);
        p1.setBackground(Color.blue);
        
        add(p1);
    }
    
    public static void main(String[] args) {
        AppEstudo app = new AppEstudo();
        app.setVisible(true);
    }
    
}
