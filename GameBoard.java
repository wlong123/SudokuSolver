public class GameBoard
{
	private int[][] board;
	
	public GameBoard()
	{
		int i = 0
		board = new int[9][9];
		String s = ReadCSV.readCSV();
		for(int r = 0; r < s.size(); r++)
		{
			for(int c = 0; c < s[0].size(); c++)
			{
				while((s.charAt(i) == ',') || (s.charAt(i) == '\n')
				{
					i++;
				}
				if(s.charAt(i) == '-')
					board[r][c] = 0;
				else
					board[r][c] = (int)s.charAt(i) - 48;
			}
		}
	}
	
	public void place(int r, int c, int n)
	{
		board[r][c] = n;
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