package pakiet;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
    private static void createAndShowGUI() {
        JFrame f = new JFrame("Krzywe Bezier");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
}

class MyPanel extends JPanel {
    
    @Override
    public Dimension getPreferredSize() {
    	setValues();
        return new Dimension(500,500);
    }
    //tablice i zmienne na wspolrzedne
    double x[][] = new double[11][4];
    double y[][] = new double[11][4];
    double x2[][] = new double[5][4];
    double y2[][] = new double[5][4];
    double putx;
    double puty;
    double putx2;
    double puty2;
    
    //ustawianie wspolrzednych
    public void setValues()
    {
	//litera A
    	x[0][0] = 173;
    	  y[0][0] = 89; 
    	x[0][1] = 150;
    	  y[0][1] = 72;
    	x[0][2] = 88;
    	  y[0][2] = 346;
    	x[0][3] = 92;
    	  y[0][3] = 363;
    	
    	
    	x[1][0] = 92;
    	  y[1][0] = 363;
    	x[1][1] = 95;
    	  y[1][1] = 378;
    	x[1][2] = 123;
    	  y[1][2] = 429;
    	x[1][3] = 155;
    	  y[1][3] = 400;
    	  
    	x[2][0] = 155;
    	  y[2][0] = 400;
    	x[2][1] = 166;
    	  y[2][1] = 390;
    	x[2][2] = 166;
    	  y[2][2] = 360;
    	x[2][3] = 173;
    	  y[2][3] = 347;
    	
    	x[3][0] = 173;
    	  y[3][0] = 347;
    	x[3][1] = 190;
    	  y[3][1] = 316;
    	x[3][2] = 218;
    	  y[3][2] = 329;
    	x[3][3] = 228;
    	  y[3][3] = 341;
    	  
    	 x[4][0] = 228;
    	  y[4][0] = 341;
    	x[4][1] = 242;
    	  y[4][1] = 358;
    	x[4][2] = 233;
    	  y[4][2] = 393;
    	x[4][3] = 253;
    	  y[4][3] = 404;
    	  
    	 x[5][0] = 253;
    	  y[5][0] = 404;
    	x[5][1] = 266;
    	  y[5][1] = 411;
    	x[5][2] = 298;
    	  y[5][2] = 393;
    	x[5][3] = 304;
    	  y[5][3] = 379;
    	  
    	 x[6][0] = 304;
    	  y[6][0] = 379;
    	x[6][1] = 340;
    	  y[6][1] = 301;
    	x[6][2] = 181;
    	  y[6][2] = 74;
    	x[6][3] = 179;
    	  y[6][3] = 89;
    	  
    	 x[7][0] = 179;
    	  y[7][0] = 89;
    	x[7][1] = 175;
    	  y[7][1] = 118;
    	x[7][2] = 186;
    	  y[7][2] = 187;
    	x[7][3] = 188;
    	  y[7][3] = 177;
    	  
         x[8][0] = 188;
    	  y[8][0] = 177;
    	x[8][1] = 191;
    	  y[8][1] = 162;
    	x[8][2] = 229;
    	  y[8][2] = 255;
    	x[8][3] = 226;
    	  y[8][3] = 273;
    	  
    	 x[9][0] = 226;
    	  y[9][0] = 273;
    	x[9][1] = 222;
    	  y[9][1] = 296;
    	x[9][2] = 180;
    	  y[9][2] = 300;
    	x[9][3] = 171;
    	  y[9][3] = 275;
    	  
    	 x[10][0] = 171;
    	  y[10][0] = 275;
    	x[10][1] = 164;
    	  y[10][1] = 255;
    	x[10][2] = 184;
    	  y[10][2] = 157;
    	x[10][3] = 188;
    	  y[10][3] = 172;
    	  
    /////////////////////////////////////////////	 
    //litera B  
    	x2[0][0] = 285;
    	  y2[0][0] = 185; 
    	x2[0][1] = 254;
    	  y2[0][1] = 247;
    	x2[0][2] = 193;
    	  y2[0][2] = 190;
    	x2[0][3] = 264;
    	  y2[0][3] = 144;
    	
    	
    	x2[1][0] = 264;
    	  y2[1][0] = 144;
    	x2[1][1] = 320;
    	  y2[1][1] = 108;
    	x2[1][2] = 392;
    	  y2[1][2] = 200;
    	x2[1][3] = 295;
    	  y2[1][3] = 236;
    	  
    	x2[2][0] = 295;
    	  y2[2][0] = 236;
    	x2[2][1] = 288;
    	  y2[2][1] = 238;
    	x2[2][2] = 407;
    	  y2[2][2] = 250;
    	x2[2][3] = 329;
    	  y2[2][3] = 326;
    	
    	x2[3][0] = 329;
    	  y2[3][0] = 326;
    	x2[3][1] = 268;
    	  y2[3][1] = 385;
    	x2[3][2] = 231;
    	  y2[3][2] = 334;
    	x2[3][3] = 239;
    	  y2[3][3] = 294;
    	  
    	x2[4][0] = 239;
    	  y2[4][0] = 294;
    	x2[4][1] = 242;
    	  y2[4][1] = 281;
    	x2[4][2] = 249;
    	  y2[4][2] = 175;
    	x2[4][3] = 282;
    	  y2[4][3] = 185;
    	
    	
    	
    }
    //rysowanie krzywych
    public void paintComponent(Graphics g) {
        super.paintComponent(g);         
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(Color.black);
        for(int i=0; i<11; i++)
        {
        	for(double t = 0.0; t<=1.0; t=t+0.001)
            {
            	putx = Math.pow(1-t, 3)*x[i][0] + 3*t*Math.pow(1-t, 2)*x[i][1] + 3*t*t*Math.pow(1-t, 1)*x[i][2] + Math.pow(t, 3) * x[i][3];
            	puty = Math.pow(1-t, 3)*y[i][0] + 3*t*Math.pow(1-t, 2)*y[i][1] + 3*t*t*Math.pow(1-t, 1)*y[i][2] + Math.pow(t, 3) * y[i][3];
            	g2d.drawLine((int)putx, (int)puty, (int)putx, (int)puty);
            }
        }
        for(int i=0; i<5; i++)
        {
        	for(double t = 0.0; t<=1.0; t=t+0.001)
            {
            	putx2 = Math.pow(1-t, 3)*x2[i][0] + 3*t*Math.pow(1-t, 2)*x2[i][1] + 3*t*t*Math.pow(1-t, 1)*x2[i][2] + Math.pow(t, 3) * x2[i][3];
            	puty2 = Math.pow(1-t, 3)*y2[i][0] + 3*t*Math.pow(1-t, 2)*y2[i][1] + 3*t*t*Math.pow(1-t, 1)*y2[i][2] + Math.pow(t, 3) * y2[i][3];
            	g2d.drawLine((int)putx2 + 70, (int)puty2 + 50, (int)putx2 + 70, (int)puty2 + 50);
            }
        }
 
        g2d.dispose();
    }  

}


