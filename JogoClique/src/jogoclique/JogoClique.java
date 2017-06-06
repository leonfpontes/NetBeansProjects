package jogoclique;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JogoClique extends JFrame {
    
    private Alvo a;
    
    public JogoClique(){
        a = new Alvo();
        a.addAlvoListener(new AlvoHandler());
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        JPanel p = new JPanel();
        p.setBackground(Color.red);
        p.setLayout(null);
        p.add(a);
        p.setDoubleBuffered(true);
        add(p);

        Thread thread = new Thread(new AlvoThread());
        thread.start();
    }

    public static void main(String[] args) {
        JogoClique app = new JogoClique();
        app.setVisible(true);
    }
    
    private class AlvoHandler implements AlvoListener{

        @Override
        public void alvoClicked(int numClicks) {
            System.out.println(String.valueOf(numClicks));
        }
        
    }
    
    private class AlvoThread implements Runnable{

        @Override
        public void run() {
            int x;
            int y;
            while (true){
                x = Math.abs(new Random(
                        System.currentTimeMillis()).nextInt()) % 500;
                y = Math.abs(new Random(
                        System.currentTimeMillis()).nextInt()) % 400;
                a.setBounds(x,y,50,50);
                repaint();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    }
    
}
