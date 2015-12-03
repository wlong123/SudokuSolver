/**
	Solver Class for a Sudoku Board
	@version 12/3/15
	@author Will Long
*/
public class Solver<E>
{
	/**
	main method for solver. solves a sudoku puzzle
	*/
	public static void main(String [] args)
	{
		Stack<GameBoard> stack = new LinkedList<GameBoard>(); //intializes stack
		GameBoard board = new GameBoard(); //creates the game board
		stack.push(board);
		boolean solved = false;	
		while(solved == false)
		{
			if(stack.isEmpty()) //if stack is empty the board is unsolvable
				System.out.println("board is unsolvable");
			GameBoard curr = stack.pop(); 
			if(curr.solved()) 
			{
				System.out.println(curr);
				solved = true;
				return;
			}
			int[] mostConstrained = curr.mostConstrained(); //array containing the row and column of the most constrined spot on the board
			for(int i = 1; i < 10; i++) //checks what numbers can be placed at the most constrained spot
			{
				if(curr.canPlace(mostConstrained[0], mostConstrained[1], i))
				{
					GameBoard temp = new GameBoard(curr); //calls the copy constructor and creates a copy of current game board
					temp.place(mostConstrained[0],mostConstrained[1], i); 
					stack.push(temp);
				}
			}
		}
	}
}