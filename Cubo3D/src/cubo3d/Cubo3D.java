package cubo3d;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;
import java.applet.Applet;
import java.awt.BorderLayout;
import com.sun.j3d.utils.universe.*;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.*;

public class Cubo3D extends Applet {

    public Cubo3D () {
        setLayout(new BorderLayout());
        GraphicsConfiguration config =
           SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config); // passo 1
        add("Center", canvas3D);
        BranchGroup s = ConstroiContentBranch(); // passo 5
        s.compile(); // passo 6
        // A instanciação de um objeto SimpleUniverse corresponde
        // aos passos 2, 3, e 4 da "receita"
        SimpleUniverse su = new SimpleUniverse(canvas3D);
        // Desloca o ViewPlatform para trás para que os
        // objetos da cena possam ser vistos.
        su.getViewingPlatform().setNominalViewingTransform();
        // Anexa o content graph ao nó Locale : passo 7
        su.addBranchGraph(s);
    }
    
    public BranchGroup ConstroiContentBranch() {
        // Especifica-se aqui os conteúdos gráficos a serem renderizados
        BranchGroup objRoot = new BranchGroup();
        // O trecho de código a seguir especifica duas transformações
        // 3D, uma para rotacionar o cubo no eixo x e a outra no eixo y
        // e por fim combina as duas transformações
        Transform3D rotate1 = new Transform3D();
        Transform3D rotate2 = new Transform3D();
        rotate1.rotX(Math.PI/4.0d);
        rotate2.rotY(Math.PI/5.0d);
        rotate1.mul(rotate2);
        TransformGroup objRotate = new TransformGroup(rotate1);
        objRoot.addChild(objRotate);
        objRotate.addChild(new ColorCube(0.4));
        return objRoot;
    }
//
    
    
    public static void main(String[] args) {
        Frame frame = new MainFrame (new Cubo3D(), 256, 256);
        frame.setVisible(true);
    }
    
}
