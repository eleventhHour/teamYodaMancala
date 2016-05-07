/**
 * Mancala : PitsModel
 * Class that models (MVC) the pits
 * @author Peter Yulong Chen, Paul Diaz, Branden Anderson, Brandon Trinh
 */
public class PitsModel {
    int[] pits;             //represents the number of pits in Mancala
    int firstStore;         //first store
    int secondStore;        //second store
    int player;             //1 for player 1, 2 for player 2
    boolean move;           //
    /**
     * Constructor for PitsModel
     * @param stones is the number of stones the user selected
     */
    public PitsModel(int stones){
	pits = new int[12];             //we have 12 pits total
	for (int i = 0; i < 12; i++){
            pits[i]  = stones;
        }
	firstStore = 0;
	secondStore = 0;
	player = 0;
	move = false;
    }
    /**
     * Method that sets if user has an extra turn or not
     * @param m is true if the player has the turn, false otherwise
     */
    public void setExtraMove(boolean m){
	move = m;
    }
    /**
     * Method that returns if user has its turn or not
     * @return true if player has the turn, false otherwise
     */
    public boolean getExtraMove(){
	return move;
    }
    /**
     * Method that sets the player
     * @param p is the player number
     */
    public void setPlayer(int p){
	player = p;
    }
    /**
     * Method that gets the player number
     * @return 1 if it is player 1, 2 otherwise
     */
    public int getPlayer(){
	return player;
    }
    /**
     * Method that add pits in Mancala
     * @param index is the index of pit
     * @param n is the number of stones that will be placed in that pit
     */
    public void addPits(int index, int n){
	pits[index] = pits[index]+n;
    }
    /**
     * Method that sets the number of stones in a pit number index
     * @param index is the number/position of the pit
     * @param n is the number of stones that is supposed to be in the pit
     */
    public void setPits(int index, int n){
	pits[index] = n;
    }
    /**
     * Method that returns the number of stones the pit number index
     * @param index is the index/position of the pit
     * @return the number of stones in the pit
     */
    public int getPits(int index){
	return pits[index];
    }
    /**
     * Method that adds more stones in the first store
     * @param n is the number of stones to be added in the first store
     */
    public void addFirstStore(int n){
	firstStore = firstStore + n;
    }
    /**
     * Method that returns the number of stones in the first store
     * @return the number of stones in the first store
     */
    public int getFirstStore(){
	return firstStore;
    }
   /**
     * Method that adds more stones in the second store
     * @param n is the number of stones to be added in the second store
     */
    public void addSecondStore(int n){
	secondStore = secondStore + n;
    }
    /**
     * Method that returns the number of stones in the second store
     * @return the number of stones in the second store
     */
    public int getSecondStore(){
	return secondStore;
    }	
}
