package appestudo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppEstudo extends JFrame{

    private JPanel p1;

    public AppEstudo(){

        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.red);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        p1 = new JPanel();
        p1.setBounds(new Rectangle(100, 100));
        p1.setBackground(Color.blue);
        
        JButton button = new JButton("Alguma coisa");
        p1.add(button);

        add(p1);
    }

    public static void main(String[] args) {
        AppEstudo app = new AppEstudo();
        app.setVisible(true);
    }

}
