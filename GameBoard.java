public class GameBoard
{
	private int[][] board;
	
	public GameBoard()
	{
		int i = 0;
		board = new int[9][9];
		String s = ReadCSV.readCSV();
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board.length; c++)
			{
				while((s.charAt(i) == ',') || (s.charAt(i) == '\n'))
				{
					i++;
				}
				if(s.charAt(i) == '-')
					board[r][c] = 0;
				else
					board[r][c] = (int)s.charAt(i) - 48;
				i++;
			}
		}
	}
	
	public void place(int r, int c, int n)
	{
		board[r][c] = n;
	}
	
	public int get(int r, int c)
	{
		return board[r][c];
	}
	
	public void remove(int r, int c)
	{
		board[r][c] = 0;
	}
	
	public boolean canPlace(int r, int c, int n)
	{
		if(board[r][c] != 0)
			return false;
		for(int row = 0; row < board.length; row++)
		{
			if(board[row][c] == n)
				return false;
		}
		for(int col = 0; col < board.length; col++)
		{
			if(board[r][col] == n)
				return false;
		}
		int row = 0;
		int col = 0;
		if(r > 2)
			row += 3;
		if(r > 5)
			row += 3;
		if(c > 2)
			col += 3;
		if(c > 5)
			col += 3;
		for(int i = row; i < row + 3; i++)
		{
			for(int j = col; j < col + 3; j++)
			{
				if(board[i][j] == n)
					return false;
			}
		}
		return true;
	}
	
	public int[] mostConstrained()
	{
		int lowest = 123456;
		int[] mostConstrained = new int[2];
		int[] options = {1,2,3,4,5,6,7,8,9};
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board.length; c++)
			{
				if(board[r][c] == 0)
				{
					int count = 0;
					for(int i = 0; i < options.length; i++)
					{
						if(canPlace(r,c,options[i]))
							count++;
					}
					if(count < lowest)
					{
						lowest = count;
						mostConstrained[0] = r;
						mostConstrained[1] = c;
					}
				}
			}
		}
		return mostConstrained;
	}
	
	public boolean solved()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				if(board[row][col] == 0)
					return false;
			}
		}
		return true;
	}
	
	public String toString()
	{
		String s = "";
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[0].length; c++)
			{
				s += "|" + board[r][c];
			}				
			s += "|" + "\n" + "-------------" + "\n";
		}
		return s;
	}
	
	
}