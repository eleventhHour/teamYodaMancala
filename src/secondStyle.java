/**
 * Mancala : SecondStyle
 * Second Concrete class for interface Style for the Strategy Pattern 
 * @author Peter Yulong Chen, Paul Diaz, Branden Anderson, Brandon Trinh
 */
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.*;
import java.awt.Graphics;

/**
 * Second concrete strategy that implements Style interface
 */
public class SecondStyle implements Style{
    /**
     * Method that paints the all the pits
     * @param g is the graphics that is responsible for painting the pits
     * @param xPos is the position xPos in x direction
     * @param yPos is the position of yPos in y direction
     * @param stones is the number of stones in the pit
     */
    @Override
    public void paintPits(Graphics g, int xPos, int yPos, int stones) {
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(new Color(100,30,255));
	g2.fill(new RoundRectangle2D.Double(0,0, xPos, yPos,30, 30));
	g2.setColor(Color.YELLOW);
		
	for (int i=0; i<stones&&i<3; i++){
            g2.translate(xPos/5, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*1/5, 12, 12));
	}
	g2.translate(-3*xPos/5,0);
	for (int i=3; i<stones&&i<7; i++){
            g2.translate(xPos/6, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*2/5, 12, 12));
	}
	g2.translate(-4*xPos/6, 0);
	for (int i=7; i<stones&&i<11;i++){
            g2.translate(xPos/6, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*3/5, 12, 12));
	}
	g2.translate(-4*xPos/6, 0);
	for (int i=11; i<stones&&i<14;i++){
            g2.translate(xPos/5, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*4/5, 12, 12));
        }	
    }
    /**
     * Method that paints rectangle round as pits
     * @param g is the graphics that is responsible for painting the pits
     * @param xPos is the position of xPos in x direction
     * @param yPos is the position of yPos in y direction
     * @param stones is the number of stones in the pits
     */
    @Override
    public void paintMancala(Graphics g, int xPos, int yPos, int stones) {
	// TODO Auto-generated method stub
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(new Color(200,30,100));
	g2.fill(new RoundRectangle2D.Double(0,yPos/8, xPos, yPos, 30, 30));
	g2.setColor(Color.BLACK);
		
	g2.translate(xPos/3, 0);
	for (int i=0; i<stones&&i<3; i++){
            g2.fill(new Ellipse2D.Double(0,yPos*1/5, 12, 12));
            g2.translate(xPos/7, 0);
	}
	g2.translate(-xPos/3-3*xPos/7,0);
		
	g2.translate(xPos/20, 0);
	for (int i=3; i<stones&&i<8; i++){
            g2.translate(xPos/7, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*3/10, 12, 12));
	}
	g2.translate(-5*xPos/7, 0);
		
	for (int i=8; i<stones&&i<13;i++){
            g2.translate(xPos/7, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*4/10, 12, 12));
	}
	g2.translate(-5*xPos/7, 0);
		
	for (int i=13; i<stones&&i<18;i++){
            g2.translate(xPos/7, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*5/10, 12, 12));
	}
	g2.translate(-5*xPos/7, 0);
		
	for (int i=18; i<stones&&i<23;i++){
            g2.translate(xPos/7, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*6/10, 12, 12));
	}
	g2.translate(-5*xPos/7, 0);
		
	for (int i=23; i<stones&&i<28;i++){
            g2.translate(xPos/7, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*7/10, 12, 12));
	}
	g2.translate(-5*xPos/7, 0);
	for (int i=28; i<stones&&i<33;i++){
            g2.translate(xPos/7, 0);
            g2.fill(new Ellipse2D.Double(0,yPos*8/10, 12, 12));
	}
	g2.translate(-5*xPos/7, 0);
	g2.translate(xPos/3, 0);
	for (int i=33; i<stones&&i<36; i++){
            g2.fill(new Ellipse2D.Double(0,yPos*9/10, 12, 12));
            g2.translate(xPos/7, 0);
	}
    }
}
