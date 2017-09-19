package cubo;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Point3d;

public class Cubo extends JFrame{
    private Transform3D rotate1 = new Transform3D();
    private Transform3D rotate2 = new Transform3D();
    
    public Cubo(){
        super("Cubo");
        Canvas3D canvas3D = createCanvas3D();
        BranchGroup scene = createSceneGraph();
        connect(canvas3D, scene);
    }
    
    private Canvas3D createCanvas3D(){
        setSize(300, 300);
        getContentPane().setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        return canvas3D;
    }
    
    private BranchGroup createSceneGraph(){
        BranchGroup objRoot = new BranchGroup();
        TransformGroup objTransf = new TransformGroup();
        objTransf.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRoot.addChild(objTransf);
        Appearance app = new Appearance();
        objTransf.addChild(new ColorCube(0.4));
        Transform3D yAxis = new Transform3D();
        Alpha rotationAlpha = new Alpha(5, 4000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, 
                objTransf, yAxis,0.0f, (float) Math.PI*2.0f);
        BoundingSphere bounds = 
                new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        rotator.setSchedulingBounds(bounds);
        objRoot.addChild(rotator);
        objRoot.compile();
        
        return objRoot;
    }
    
    private Transform3D rotateCube(){
        rotate1.rotX(Math.PI/4.0d);
        rotate2.rotX(Math.PI/4.0d);
        rotate1.mul(rotate2);
        return rotate1;
    }
    
    private void connect(Canvas3D canvas3D, BranchGroup scene){
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.addBranchGraph(scene);
    }
    
    public static void main(String[] args) {
        //new Cubo().setVisible(true);
        Cubo cubo = new Cubo();
        cubo.setVisible(true);
    }
    
}
