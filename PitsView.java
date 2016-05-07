import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class PitsView extends JComponent implements View{

	private int stones; //indicates how many stones in the pit
	private int xPos;	//x position, it relatives to the panel
	private int yPos;	//y position, it relatives to the panel
	private int index; //indicates the index of pits, such as pit A1, pit A2....
	private MancalaGameModel model; //model
	private Style style;
	public PitsView (int p, MancalaGameModel m){
		super();
		stones = p;
		xPos = 300;
		yPos = 300;
		model = m;
		
		//add action listener when mouse is clicked in the pit
		addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent me) {
				
				// if user click on an empty pit, do nothing
				if (model.getPit(getPitsIndex())==0) 
					return;
				
				// if it's player A's turn and user click Player A's pits, make movement
				else if (model.nextPlayer()==1&&getPitsIndex()<6){
					model.makeMovement(getPitsIndex());
				}
				
				// if it's player B's turn and user click Player B's pits, make movement
				else if (model.nextPlayer()==2&&getPitsIndex()>5){
					model.makeMovement(getPitsIndex());
				}
				
				//check every time after user make movement to see if the win condition has been reached
				int winner = model.checkWin();
				if (winner!=0)
				{
					int firstStore = model.getFirstStore();
					int secondStore = model.getSecondStore();
					JOptionPane pane = new JOptionPane(); //pop up window to show who is the winner and win by how many stones
					int exit = pane.showConfirmDialog(null, "The winner is: "+((winner==1)?"A":"B")+"\nPlayer A has: "+firstStore+"\nPlayer B has: "+secondStore, "Game End!", JOptionPane.CLOSED_OPTION);

					//it will end the program after user close the pop up window
					if (exit != 10000)
					{
						System.exit(0);
					}

				}
			} 
		}); 
	}

	public void setStyle(Style newStyle)
	{
		style = newStyle;
	}
	// update method inherited from View interface, it updates the number of stones in pits and repaint
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





	@Override
	public Dimension getPreferredSize() {
		return new Dimension(xPos, yPos);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		style.paintPits(g, xPos, yPos, stones);


	}

}
