import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class PitsView extends JComponent implements View{
		
		private int stones;
		private double width;
		private double height;
		private int xPos;
		private int yPos;
		private int index;
		private MancalaGameModel model;
		public PitsView (int p, MancalaGameModel m){
			super();
			stones = p;
			width = 1;
			height = 1;
			xPos = 300;
			yPos = 300;
			model = m;
		      addMouseListener(new MouseAdapter() { 
		          public void mousePressed(MouseEvent me) {
		        	  if (model.getPit(getPitsIndex())==0)
		        		  return;
		        	  else if (model.nextPlayer()==1&&getPitsIndex()<6){
		        	  model.makeMovement(getPitsIndex());
		        	  model.printBoard();
		        	 
		        	  }
		        	  else if (model.nextPlayer()==2&&getPitsIndex()>5){
			        	  model.makeMovement(getPitsIndex());
			        	  model.printBoard();
			        	  }
		        	  int winner = model.checkWin();
		        	  if (winner!=0)
		        	  {
		        		  int firstStore = model.getFirstStore();
		        		  int secondStore = model.getSecondStore();
		        		  JOptionPane pane = new JOptionPane();
		        		  int exit = pane.showConfirmDialog(null, "The winner is: "+winner+"\nPlayer 1 has: "+firstStore+"\nPlayer 2 has: "+secondStore, "Game End!", JOptionPane.CLOSED_OPTION);
		        		 
		        		  
		        		  if (exit != 10000)
		        		    {
		        		        System.exit(0);
		        		    }
		        		    
		        	  }
		          } 
		        }); 
		}
		public void update(int s)
		{
			stones = s;
			repaint();
		}
		public int getPitsIndex()
		{
			return index;
		}
		public void setIndex(int i)
		{ 
			index = i;
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
		
		
		public double getW()
		{
			return width;
		}
		public double getH()
		{
			return height;
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
			g2.setColor(Color.RED);
			g2.fill(new Ellipse2D.Double(0,0, xPos, yPos));
			g2.setColor(Color.BLUE);
			
				for (int i=0; i<stones&&i<3; i++)
				{
					g2.translate(xPos/5, 0);
					g2.fill(new Ellipse2D.Double(0,yPos*1/5, 12, 12));
				}
				g2.translate(-3*xPos/5,0);
				for (int i=3; i<stones&&i<7; i++)
				{
					g2.translate(xPos/6, 0);
					g2.fill(new Ellipse2D.Double(0,yPos*2/5, 12, 12));
				}
				g2.translate(-4*xPos/6, 0);
				for (int i=7; i<stones&&i<11;i++)
				{
					g2.translate(xPos/6, 0);
					g2.fill(new Ellipse2D.Double(0,yPos*3/5, 12, 12));
				}
				g2.translate(-4*xPos/6, 0);
				for (int i=11; i<stones&&i<14;i++)
				{
					g2.translate(xPos/5, 0);
					g2.fill(new Ellipse2D.Double(0,yPos*4/5, 12, 12));
				}
		
			//g2.translate(10, 0);
			//g2.draw(new Ellipse2D.Double(0,10, 10, 10));
			//g2.translate(10, 0);
			//g2.draw(new Ellipse2D.Double(3,10, 10, 10));
			//g2.translate(10, 0);
			//g2.draw(new Ellipse2D.Double(6,10, 10, 10));
			
		}
		
}
