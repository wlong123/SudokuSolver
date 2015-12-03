public class Solver<E>
{
	public static void main(String [] args)
	{
		Stack<GameBoard> stack = new LinkedList<GameBoard>();
		GameBoard board = new GameBoard();
		stack.push(board);
		boolean solved = false;	
		while(solved == false)
		{
			if(stack.isEmpty())
				System.out.println("board is unsolvable");
			GameBoard curr = stack.pop();
			if(curr.solved())
			{
				System.out.println(curr);
				solved = true;
			}
			int[] mostConstrained = curr.mostConstrained();
			for(int i = 1; i < 10; i++)
			{
				if(curr.canPlace(mostConstrained[0], mostConstrained[1], i))
				{
					GameBoard temp = curr;
					temp.place(mostConstrained[0],mostConstrained[1], i);
					stack.push(temp);
				}
			}
		}
	}
}