package primitives;

import javax.swing.*;
import java.awt.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Primitives extends JFrame {

    /////////////////////////////////////////////////////////////////
    // Atributo da classe Primitives
    //
    private SimpleUniverse universe = null;

    /////////////////////////////////////////////////////////////////
    // Construtor da classe HelloUniversePrimitives
    //
    public Primitives() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        GraphicsConfiguration config =
           SimpleUniverse.getPreferredConfiguration();

        Canvas3D canvas = new Canvas3D(config);
        container.add("Center", canvas);

        // Cria um sub-grafo de conteudo
        BranchGroup scene = criaGrafoDeCena();
        universe = new SimpleUniverse(canvas);

        // O código abaixo faz com que a ViewPlatform seja movida
        // um pouco para trás, para que os objetos possam ser
        // visualizados
        universe.getViewingPlatform().setNominalViewingTransform();

	// Anexa o sub-grafo no universo virtual
        universe.addBranchGraph(scene);

        setSize(600,600);
        setVisible(true);
    }
    
    /////////////////////////////////////////////////////////////////
    // Método responsável pela criação do grafo de cena (ou sub-grafo)
    //    
    public BranchGroup criaGrafoDeCena() {

        // Cria o nodo raiz  
        BranchGroup objRaiz = new BranchGroup();

        // Cria o nodo TransformGroup e permite que ele possa
        // ser alterado em tempo de execução (TRANSFORM_WRITE).
        // Depois, adiciona-o na raiz do grafo de cena.
        TransformGroup objTrans = new TransformGroup();
        objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRaiz.addChild(objTrans);

	 // Cria um "bounds" 
	 BoundingSphere bounds =
	      new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);

        Appearance app = new Appearance();
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(new Color3f(0.0f, 1.0f, 0.0f));
        app.setColoringAttributes(ca);

        com.sun.j3d.utils.geometry.Box cubo = 
           new com.sun.j3d.utils.geometry.Box(0.4f, 0.4f, 0.4f, app); 

        cubo.setAppearance(app);

        objTrans.addChild(cubo);

        // Cria um novo objeto Behaviour que irá executar as 
        // operações desejadas no "transform" especificado  
        // e adiciona-o no grafo.
        Transform3D trans = new Transform3D();
        trans.rotZ(Math.toRadians(60));

        Alpha rotacaoAlpha = new Alpha(-1, 7000);

        RotationInterpolator rotator =
               new RotationInterpolator(rotacaoAlpha, objTrans, trans,
                                         0.0f, (float) Math.PI*2.0f);
        rotator.setSchedulingBounds(bounds);

        objRaiz.addChild(rotator);

        // Para o Java 3D realizar otimizações no grafo de cena
        objRaiz.compile();

        return objRaiz;
    }

    /////////////////////////////////////////////////////////////////
    // Método principal que permite executar a aplicação
    //
    public static void main(String[] args)
    {
        Primitives h = new Primitives();
    }
}