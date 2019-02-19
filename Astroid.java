import java.util.Random;
import blobz.*;
import java.awt.Point;

public class Astroid extends blobz.PolyBlob {
    public Astroid(int x, int y, double r) {
        super(-100, -100, r);
        this.setDelta(x, y);
      
        // Randomly generate Vertices and Max Radius
        Random ran = new Random();
        int rad = ran.nextInt(11);
        int ver = ran.nextInt(5) + 5;
        int[] xArr = new int[ver];
        int[] yArr = new int[ver];
        Point[] pArr = new Point[ver];
        double arc = 360/ver;
      
        for(int i = 0; i < ver; i++) {
            // Get angle for point
            double ang = (arc * i) + (ran.nextDouble() * arc );
            // Get radious for angle
            double arcRad = (ran.nextInt(rad + 1) + 5);
            ang = Math.toRadians(ang);
            xArr[i] = (int)Math.round(Math.cos(ang) * arcRad);
            yArr[i] = (int)Math.round(Math.sin(ang) * arcRad);
        }

        
        for(int i = 0; i < ver; i++) {
            pArr[i] = new Point(xArr[i], yArr[i]);
        }
        
      
        this.setPolygon(pArr);      
    }
}
