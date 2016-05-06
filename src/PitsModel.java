import java.util.ArrayList;

public class PitsModel {
	int[] pits;
	int firstStore;
	int secondStore;
	int player;
	boolean move;
	public PitsModel(int stones)
	{
		pits = new int[12];
		for (int i=0; i<12; i++)
		{
			pits[i]  = stones;
		}
		firstStore = 0;
		secondStore = 0;
		player = 0;
		move = false;
	}
	public void setExtraMove(boolean m)
	{
		move = m;
	}
	public boolean getExtraMove()
	{
		return move;
	}
	
	public void setPlayer(int p)
	{
		player = p;
	}
	
	public int getPlayer()
	{
		return player;
	}
	public void addPits(int index, int n)
	{
		pits[index] = pits[index]+n;
	}
	public void setPits(int index, int n)
	{
		pits[index] = n;
	}
	
	public int getPits(int index)
	{
		return pits[index];
	}
	
	
	public void addFirstStore(int n)
	{
		firstStore = firstStore + n;
	}
	
	public int getFirstStore()
	{
		return firstStore;
	}
	
	
	public void addSecondStore(int n)
	{
		secondStore = secondStore + n;
	}
	
	public int getSecondStore()
	{
		return secondStore;
	}
	

	
	
}
