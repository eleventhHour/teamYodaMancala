import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class StoreView extends JComponent implements View{
	private int stones; //indicates how many stones in the pit
	private int xPos;	//x position, it relatives to the panel
	private int yPos;	//y position, it relatives to the panel
	private Style style; 
	private MancalaGameModel model;
	
	public StoreView(MancalaGameModel m)
	{
		model = m;
		xPos = 500;
		yPos = 400;
		stones = 0;
	}
	
	public void setStyle(Style newStyle)
	{
		style = newStyle;
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
		style.paintMancala(g, xPos, yPos, stones);
		
	}

}
