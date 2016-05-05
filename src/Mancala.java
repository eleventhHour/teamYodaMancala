import java.util.Scanner;

public class Mancala {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MancalaGameModel m = new MancalaGameModel(4);
		boolean flag = true;
		boolean player1 = true;
		boolean player2 = false;
		boolean extraMove = false;
		boolean undoMove = false;
		boolean changeTurn = false;
		
		Scanner reader = new Scanner(System.in);
		m.printBoard();
		while(flag)
		{
			System.out.print(((player1)?"Player 1 turn: ":"Player 2 turn: "));
			int n = reader.nextInt();
			if (player1 && n<=6 && n>0)
			{
				
				m.makeMovement(n-1);
				changeTurn = true;
			}
			else if (player2 && n>=7)
			{
				
				m.makeMovement(n-1);
				changeTurn = true;
			}
			else if (n==0)
			{
				m.undo();
				
				undoMove = true;
				if (m.nextPlayer()==2)
				{
					player1 = true;
					player2 = false;
				}
				else
				{
					player1 = false;
					player2 = true;
				}
				changeTurn = false;
				
				
				System.out.println("----Undo the movement----");
				
			}
			else
			{
				System.out.println("Invalid input");
				changeTurn = false;
			}
			if (m.checkWin()!=0)
			{
				m.printBoard();
				if (m.checkWin()==1)
					System.out.println("Player 1 win");
				else
					System.out.println("Player 2 win");
				flag = false;
			}
			else
			{
				/*if (undoMove)
				{
					m.setExtraMovmeent(extraMove);
					undoMove = false;
				}
				else*/
					extraMove = m.getExtraMovement();
				if (extraMove)
				{
					System.out.println("You can make one extra movement");
					
				}
				else if (changeTurn)
				{
					player1 = !player1;
					player2 = !player2;
				}
				m.printBoard();
				
			}
		}
	}
	
	

}
