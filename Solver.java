public class Solver<E>
{
	public static void main(String [] args)
	{
		Stack<GameBoard> stack = new Linked:ist<GameBoard>();
		GameBoard board = new GameBoard();
		int[] options = {1,2,3,4,5,6,7,8,9};
		stack.push(board);
		boolean solved = false;
		while(solved == false)
		{
			GameBoard curr = stack.pop();
			if(curr.solved())
				solved = true;
			int[] mostConstrained = curr.mostConstrained();
			for(int i = 0; i < options.length; i++)
			{
				if(curr.canPlace(mostConstrained[0], mostConstrained[1], options[i]))
				{
					GameBoard temp = new GameBoard();
					temp.place(mostConstrained[0],mostConstrained[1], options[i]);
					stack.push(temp);
				}
			}
		}
		System.out.println(stack.peek());
	}
}