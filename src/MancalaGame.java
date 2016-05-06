import java.util.ArrayList;

public class MancalaGame {

	PitsModel pits;
	private boolean undoMove;
	PitsModel savedPits;
	private boolean [] previousExtraMovement;
	private int stones;
	private ArrayList<View> views;
	private boolean eMove;

	public MancalaGame(int n)
	{
		eMove = false;
		stones = n;
		pits = new PitsModel(n);
		undoMove = true;
		savedPits = new PitsModel(n);
		previousExtraMovement = new boolean[] {false, false};
		views = new ArrayList<View>();
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

		int player = 0;
		if (0<=c && c<=5)
			player = 1;
		else
			player = 2;
		pits.setPlayer(player);
		saveMovement(savedPits, pits);
		pits.setExtraMove(false);
		int temp = pits.getPits(c);
		pits.setPits(c, 0);
		int index = c;

		while(temp >0)
		{

			if (index==5 && temp>0 && player==1)
			{
				pits.addFirstStore(1);
				temp--;
				if (temp==0 && player==1)
					setExtraMovement(true);
			}
			else if (index==11 && temp >0 && player==2)
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

		if (pits.getPits(index)==1)
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

		recordExtraMovement();
		eMove = getExtraMovement();
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

	public void printSavedBoard()
	{
		System.out.print("\n     ");
		for(int i=11; i>5;i--)
		{
			System.out.print(savedPits.getPits(i) + " ");

		}
		System.out.println("     ");
		System.out.print("  " + savedPits.getSecondStore() + "  ");
		for(int i=0; i<6; i++)
		{
			System.out.print(savedPits.getPits(i) + " ");
		}
		System.out.println("  " + savedPits.getFirstStore() + "  ");
	}
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
			}
			for (int i=6; i<12; i++)
			{
				pits.addSecondStore(pits.getPits(i));
			}

			if (pits.getFirstStore()>pits.getSecondStore())
				winner = 1;
			else
				winner = 2;

		}

		return winner;
	}

	public boolean undo()
	{

		saveMovement(pits, savedPits);

		pits.setExtraMove(previousExtraMovement[0]); 
		previousExtraMovement[1] = previousExtraMovement[0];
		previousExtraMovement[0] = false;
		return true;
	}

	public void saveMovement(PitsModel p, PitsModel s)
	{
		/*p.pits = s.pits;
		p.firstStore = s.firstStore;
		p.secondStore = s.secondStore;*/

		for (int i=0; i<p.pits.length;i++)
		{
			p.pits[i] = s.pits[i];
		}
		p.firstStore = s.firstStore;
		p.secondStore = s.secondStore;
		p.player = s.player;
		p.move = s.move;
	}

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
	public void addView(View v)
	{
		views.add(v);
	}
	
	public void update()
	{
		for (int i=0; i<views.size();i++)
		{
			views.get(i).update(pits.getPits(i));
		}
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
