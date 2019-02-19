# Asteriods-
AsteroidField.java

import blobzx.*;
import java.util.Random;

public class AsteroidField implements BlobGUI {

    public static void main(String[] args) {
        new AsteroidField();
      
    }
  
    private final SandBox sandBox;
  
    public AsteroidField() {
        // Build sandbox
        sandBox = new SandBox();
        sandBox.setSandBoxMode(SandBoxMode.FLOW);
        sandBox.setFrameRate(15);
        sandBox.init(this);
    }

    @Override
    public void generate() {
        // Randomly generate 20 astroids with random x/y deltas and rot speeds
        Random ran = new Random();
        for(int i = 0; i < 20; i++) {
            int x = (ran.nextInt(3) + 1) * (ran.nextBoolean() ? -1: 1);
            int y = (ran.nextInt(3) + 1) * (ran.nextBoolean() ? -1: 1);
            double r = ran.nextBoolean() ? -.1: .1;
          
            sandBox.addBlob(new Astroid(x,y,r));
        }
    }
  
}


Astroid.java


import java.util.Random;

public class Astroid extends blobzx.PolyBlob {

    public Astroid(int x, int y, double r) {
        super(-100, -100, r);
        this.setDelta(x, y);
      
        // Randomly generate Vertices and Max Radius
        Random ran = new Random();
        int rad = ran.nextInt(11);
        int ver = ran.nextInt(5) + 5;
        int[] xArr = new int[ver];
        int[] yArr = new int[ver];
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
      
        this.setPolygon(xArr, yArr);      
    }
  
  
}
