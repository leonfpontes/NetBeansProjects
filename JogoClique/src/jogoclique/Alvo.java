
package jogoclique;

import java.awt.Color;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Alvo extends JPanel {
    
    private List<AlvoListener> listeners = new LinkedList<>();
    
    private int numClicks;
    
    public Alvo (){
        setBounds(0, 0, 50, 50);
        setBackground(Color.yellow);
        addMouseListener(new MouseHandler());
        setDoubleBuffered(true);
    }
    
    public void addAlvoListener (AlvoListener listener){
        listeners.add(listener);
    }
    
    private class MouseHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent evt){
            numClicks++;
            for (AlvoListener l : listeners){
                l.alvoClicked(numClicks);
            }
        }
    }
}
