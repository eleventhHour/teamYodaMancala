import java.util.ArrayList;

public class MancalaGameModel {

	PitsModel pits; // it holds all the current pits and store information
	PitsModel savedPits; // it holds all the previous pits and store information
	private boolean [] previousExtraMovement; // it will indicate if the previous movement has extra turn
	private int stones; // indicates how many stones in the pits
	private ArrayList<View> views; // it hold all the views information, in our project, it has 12 PitsView and 2 StoreView
	private boolean eMove;	//flag for extra movement
	private int turns;	//indicates the total turns
	private int blockUndo; //indicates if player click undo button in same turn
	private int count;	//it counts how many times the undo button has been clicked, one player can only use undo method 3 times in one turn
	
	//the parameter is the initial stones in each pits
	public MancalaGameModel(int n)
	{
		turns=-1;
		eMove = false;
		stones = n;
		pits = new PitsModel(n);
		savedPits = new PitsModel(n);
		previousExtraMovement = new boolean[] {false, false};
		views = new ArrayList<View>();
		blockUndo = 0;
		count = 0;
	}

	public int getStones()
	{
		return stones;
	}
	public int getPit(int index)
	{
		return pits.getPits(index);
	}

	public void makeMovement(int c)
	{

		turns++;
		int player = 0;
		if (0<=c && c<=5)
			player = 1;
		else
			player = 2;
		pits.setPlayer(player);
		saveMovement(savedPits, pits); // save the previous movement
		if(turns==0)
			savedPits.setPlayer(0);
		pits.setExtraMove(false);
		int temp = pits.getPits(c);
		pits.setPits(c, 0);
		int index = c;

		while(temp >0)
		{

			if (index==5 && temp>0 && player==1)	//check if the stone need to be added in store
			{
				pits.addFirstStore(1);
				temp--;
				if (temp==0 && player==1)
					setExtraMovement(true);
			}
			else if (index==11 && temp >0 && player==2) //check if the stone need to be added in store
			{
				pits.addSecondStore(1);
				temp--;
				if (temp==0 && player==2)
					setExtraMovement(true);

			}

			if (temp>0) 
			{
				if (index == 11)
					index = -1;
				index++;
				pits.addPits(index, 1);
				temp--;
			}

		}

		if (pits.getPits(index)==1) //if the last stone lands in empty pit, take all the stones in opposite pit, and move them to store
		{
			if (index<=5 && player == 1)
			{
				pits.setPits(index, 0);
				int stones = pits.getPits(11-index);
				pits.setPits(11-index,0);
				pits.addFirstStore(stones+1);
			}
			if (index >=6 && player == 2)
			{
				pits.setPits(index, 0);
				int stones = pits.getPits(11-index);
				pits.setPits(11-index,0);
				pits.addSecondStore(stones+1);
			}
		}

		//save the extra movement information for savedPits.
		recordExtraMovement();
		eMove = getExtraMovement();
		
		//it calls update method to update all the views
		update();

	}
	
	
	public void recordExtraMovement()
	{
		previousExtraMovement[0] = previousExtraMovement[1];
		previousExtraMovement[1] = pits.getExtraMove();
	}
	public boolean getExtraMovement()
	{
		boolean e = pits.getExtraMove();
		pits.setExtraMove(false);
		return e;
	}

	public void setExtraMovement(boolean m)
	{
		pits.setExtraMove(m);
	}
	
	//print the board in console
	public void printBoard()
	{
		System.out.print("\n     ");
		for(int i=11; i>5;i--)
		{
			System.out.print(pits.getPits(i) + " ");

		}
		System.out.println("     ");
		System.out.print("  " + pits.getSecondStore() + "  ");
		for(int i=0; i<6; i++)
		{
			System.out.print(pits.getPits(i) + " ");
		}
		System.out.println("  " + pits.getFirstStore() + "  ");
	}

	//check if any player has win the game
	public int checkWin()
	{
		int winner = 0;
		boolean player1 = true;
		boolean player2 = true;
		for (int i=0; i<6;i++)
		{
			if (pits.getPits(i)!=0)
			{
				player1 = false;
				continue;
			}
		}
		for (int i=6; i<12;i++)
		{

			if (pits.getPits(i)!=0)
			{
				player2 = false;
				continue;
			}
		}

		if (player1 || player2)
		{
			for (int i=0; i<6; i++)
			{
				pits.addFirstStore(pits.getPits(i));
				pits.setPits(i, 0);
			}
			for (int i=6; i<12; i++)
			{
				pits.addSecondStore(pits.getPits(i));
				pits.setPits(i, 0);
			}
			update();
			if (pits.getFirstStore()>pits.getSecondStore())
				winner = 1;
			else
				winner = 2;

		}

		return winner;
	}

	
	//undo the movement
	public void undo()
	{
		if (blockUndo==turns){
			count++;
		}
		else
		{
			blockUndo = turns;
			count = 0;
		}
		//only can undo 3 times
		if (count<3){
			turns--;
			saveMovement(pits, savedPits); // get the saved pits information and load it to current pits
			pits.setExtraMove(previousExtraMovement[0]); 
			previousExtraMovement[1] = previousExtraMovement[0];
			previousExtraMovement[0] = false;
			eMove = getExtraMovement();
			if(pits.getPlayer()==1&&!eMove)
				pits.setPlayer(2);
			else if (pits.getPlayer()==2&&!eMove)
				pits.setPlayer(1);
			update();
		}
	}

	
	
	public void saveMovement(PitsModel p, PitsModel s)
	{
		for (int i=0; i<p.pits.length;i++)
		{
			p.pits[i] = s.pits[i];
		}
		p.firstStore = s.firstStore;
		p.secondStore = s.secondStore;
		p.player = s.player;
		p.move = s.move;
	}

	//get which player's turn is next
	public int nextPlayer()
	{

		if (pits.getPlayer()==0)
			return 1;
		if(pits.getPlayer()==1&&!eMove)
			return 2;
		else if (pits.getPlayer()==1&&eMove)
			return 1;
		if(pits.getPlayer()==2&&!eMove)
			return 1;
		else if (pits.getPlayer()==2&&eMove)
			return 2;

		return 0;

	}
	
	//add the view
	public void addView(View v)
	{
		views.add(v);
	}

	
	//update all the views based on the model 
	public void update()
	{
		for (int i=0; i<12;i++)
		{
			views.get(i).update(pits.getPits(i));
		}
		views.get(12).update(pits.getFirstStore());
		views.get(13).update(pits.getSecondStore());
	}
	
	
	public int getFirstStore()
	{
		return pits.getFirstStore();
	}
	public int getSecondStore()
	{
		return pits.getSecondStore();
	}


}
