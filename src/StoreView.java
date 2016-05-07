/**
 * Mancala : StoreView
 * @author Peter Yulong Chen, Paul Diaz, Branden Anderson, Brandon Trinh
 */
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

/**
 * Class the represents the stores view
 * extends JComponent and implements interface View
 */
public class StoreView extends JComponent implements View{
    private int xPos;
    private int yPos;
    private int stones;
    private Style style;
    private MancalaGameModel model;
    /**
     * Constructor for StoreView
     * @param m is the model (MVC) for the game
     */
    public StoreView(MancalaGameModel m){
	model = m;
	xPos = 500;
	yPos = 400;
	stones = 0;
    }
    /**
     * Method that sets the style chosen by the player
     * @param newStyle is the style chosen for the game
     */
    public void setStyle(Style newStyle){
	style = newStyle;
    }
    /**
     * Method that sets the position of xP
     * @param xP is the of xPos in x direction
     */
    public void setXpos(int xP){
	xPos = xP;
    }
    /**
     * Method that sets the position of yP
     * @param yP is the of yPos in y direction
     */
    public void setYpos(int yP){
	yPos = yP;
    }
    /**
     * Method that returns the position of xPos
     * @return the position of xPos
     */
    public int getXpos(){
	return xPos;
    }
    /**
     * Method that returns the position of yPos
     * @return the position of yPos
     */
    public int getYpos(){
	return yPos;
    }
    /**
     * Method that updates the view of store
     * @param i is the number of stones in the store
     */
    @Override
    public void update(int i) {
	stones = i;
	repaint();
    }
    /**
     * Method that returns the dimension of a store
     * @return the dimension of the store
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(xPos, yPos);
    }
    /**
     * Method that paints the the store: done by whichever style the player has chosen
     * @param g is the graphics responsible for painting the store
     */
    @Override
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	style.paintMancala(g, xPos, yPos, stones);	
    }
}
