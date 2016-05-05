import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class StoreView extends JComponent implements View{
	private int xPos;
	private int yPos;
	private int index;
	private int stones;
	private MancalaGameModel model;
	
	public StoreView(MancalaGameModel m)
	{
		model = m;
		xPos = 500;
		yPos = 400;
		stones = 0;
	}
	
	public void setXpos(int xP)
	{
		xPos = xP;
	}
	
	public void setYpos(int yP)
	{
		yPos = yP;
	}
	
	public int getXpos()
	{
		return xPos;
	}
	
	public int getYpos()
	{
		return yPos;
	}
	
	@Override
	public void update(int i) {
		// TODO Auto-generated method stub
		stones = i;
		repaint();
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(xPos, yPos);
    }
	
	@Override
	public void paintComponent(Graphics g)
	{
		 super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(new Ellipse2D.Double(0,yPos/8, xPos, yPos));
		g2.setColor(Color.BLUE);
		
		g2.translate(xPos/3, 0);
		for (int i=0; i<stones&&i<3; i++)
		{
			g2.fill(new Ellipse2D.Double(0,yPos*1/5, 12, 12));
			g2.translate(xPos/7, 0);
		}
		g2.translate(-xPos/3-3*xPos/7,0);
		
		
		g2.translate(xPos/20, 0);
		for (int i=3; i<stones&&i<8; i++)
		{
			g2.translate(xPos/7, 0);
			g2.fill(new Ellipse2D.Double(0,yPos*3/10, 12, 12));
		}
		g2.translate(-5*xPos/7, 0);
		
		for (int i=8; i<stones&&i<13;i++)
		{
			g2.translate(xPos/7, 0);
			g2.fill(new Ellipse2D.Double(0,yPos*4/10, 12, 12));
		}
		g2.translate(-5*xPos/7, 0);
		
		for (int i=13; i<stones&&i<18;i++)
		{
			g2.translate(xPos/7, 0);
			g2.fill(new Ellipse2D.Double(0,yPos*5/10, 12, 12));
		}
		g2.translate(-5*xPos/7, 0);
		
		for (int i=18; i<stones&&i<23;i++)
		{
			g2.translate(xPos/7, 0);
			g2.fill(new Ellipse2D.Double(0,yPos*6/10, 12, 12));
		}
		g2.translate(-5*xPos/7, 0);
		
		for (int i=23; i<stones&&i<28;i++)
		{
			g2.translate(xPos/7, 0);
			g2.fill(new Ellipse2D.Double(0,yPos*7/10, 12, 12));
		}
		g2.translate(-5*xPos/7, 0);
		for (int i=28; i<stones&&i<33;i++)
		{
			g2.translate(xPos/7, 0);
			g2.fill(new Ellipse2D.Double(0,yPos*8/10, 12, 12));
		}
		g2.translate(-5*xPos/7, 0);
		g2.translate(xPos/3, 0);
		for (int i=33; i<stones&&i<36; i++)
		{
			
			g2.fill(new Ellipse2D.Double(0,yPos*9/10, 12, 12));
			g2.translate(xPos/7, 0);
			
		}
	}

}
