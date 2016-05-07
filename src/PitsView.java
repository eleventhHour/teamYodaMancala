/**
 * Mancala : PitsView
 * @author Peter Yulong Chen, Paul Diaz, Branden Anderson, Brandon Trinh
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Class that represents the view of pits
 * extends JComponent and implements View interface
 * Checks which player has won the game
 */
public class PitsView extends JComponent implements View{
    private int stones;             //indicates how many stones in the pit
    private int xPos;               //x position, it relatives to the panel
    private int yPos;               //y position, it relatives to the panel
    private int index;              //indicates the index of pits, such as pit A1, pit A2....
    private MancalaGameModel model;//model
    private Style style;
    /**
     * Constructor that creates the view for the pits
     * @param p is the number of stones
     * @param m is the model (MVC) for the game
     */
    public PitsView (int p, MancalaGameModel m){
        super();
	stones = p;
	xPos = 300;
	yPos = 300;
	model = m;
        addMouseListener(new MouseAdapter() {               //make the pits listeners
            @Override
            public void mousePressed(MouseEvent me) {
		if (model.getPit(getPitsIndex())==0)
		    return;
		else if (model.nextPlayer()==1&&getPitsIndex()<6){
		    model.makeMovement(getPitsIndex());
                    model.printBoard();
		}else if (model.nextPlayer()==2&&getPitsIndex()>5){
                    model.makeMovement(getPitsIndex());
                    model.printBoard();
                }
		int winner = model.checkWin();
                //Here checks which player has won the game
		if (winner!=0){
		    int firstStore = model.getFirstStore();
		    int secondStore = model.getSecondStore();
                    JOptionPane pane = new JOptionPane();
		    int exit = pane.showConfirmDialog(null, "The winner is: "+((winner==1)?"Player A":"Player B")+"\nPlayer A has: "+firstStore + " stones"+"\nPlayer B has: "+secondStore + " stones", "Game End!", JOptionPane.CLOSED_OPTION);
		        		 
		    if (exit != 10000){
                        System.exit(0);
		    }
		}
            } 
        }); 
    }
    /**
     * Method that sets the style chosen by the user
     * @param newStyle is the style the user chosen
     */
    public void setStyle(Style newStyle){
	style = newStyle;
    }
    /**
     * Method that updates the pits
     * @param s is the new number of stones in the pit
     */
    @Override
    public void update(int s){
        stones = s;
	repaint();
    }
    /**
     * Method that returns the index of a pit
     * @return the number/position of pit
     */
    public int getPitsIndex(){
	return index;
    }
    /**
     * Method the sets the index of a pit
     * @param i is the new index
     */
    public void setIndex(int i){ 
	index = i;
    }
    /**
     * Method that sets the position of xPos
     * @param xP is the new position of xPos
     */
    public void setXpos(int xP){
	xPos = xP;
    }
    /**
     * Method that sets the position of yPos
     * @param yP is the new position of yPos
     */
    public void setYpos(int yP){
        yPos = yP;
    }
    /**
     * Method that returns the position of xPos
     * @return the number where the xPos is located
     */
    public int getXpos(){
	return xPos;
    }
    /**
     * Method that returns the position of yPos
     * @return the number where the yPos is located
     */
    public int getYpos(){
	return yPos;
    }
    /**
     * Method that returns the preferred dimension of a pit
     * @return the dimension of a pit
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(xPos, yPos);
    }
    /**
     * Method paints the pits
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        style.paintPits(g, xPos, yPos, stones);
    }	
}
