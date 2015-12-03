/**
	GameBoard Class for Sudoku
	@version 12/3/15
	@author Will Long
*/
public class GameBoard
{
	/**2d array that contains the numbers in the board*/
	private int[][] board;
	
	/**
	default constructor. copies in data from "Sheet1.CSV" and creates a new game board with the data from the CSV file
	*/
	public GameBoard()
	{
		int i = 0;
		board = new int[9][9];
		String s = ReadCSV.readCSV();  //data in CSV file is turned into a string
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board.length; c++)
			{
				while((s.charAt(i) == ',') || (s.charAt(i) == '\n'))  //passes over enters and commas
				{
					i++;
				}
				if(s.charAt(i) == '-')  //dashes represent 0
					board[r][c] = 0;
				else
					board[r][c] = (int)s.charAt(i) - 48;  //int value of the character which is a number 
				i++;
			}
		}
	}
	
	/**
	copy constructor for game board
	*/
	public GameBoard(GameBoard b)
	{
		board = new int[9][9];
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[0].length; c++)
			{
				board[r][c] = b.get(r,c);
			}
		}
	}
	
	/**
	places an inputted number at inputted spot in the game board
	@param r row of the number to be placed
	@param c column of the number to be placed
	@param n number to be placed 
	*/
	public void place(int r, int c, int n)
	{
		board[r][c] = n;
	}
	
	/**
	returns a value in the game board
	@param r row of the value that is going to be returned
	@param c column of the value that is going to be returned
	@return int value of board at the inputted row and column
	*/
	public int get(int r, int c)
	{
		return board[r][c];
	}
	
	/**
	removes a value in the board by setting it to 0
	@param r row of the value that is going to be removed
	@param c column of the value that is going to be removed
	*/
	public void remove(int r, int c)
	{
		board[r][c] = 0;
	}
	
	/**
	checks whether an inputted number can be placed at an inputted spot on the board
	@param r row of the spot that is going to be checked
	@param c column of the spot that is going to be checked
	@param n number that is going to be checked
	@return boolean returns true if n can be placed at the spot, false if not
	*/
	public boolean canPlace(int r, int c, int n)
	{
		if(board[r][c] != 0)  //don't want to replace a spot at the board that isn't 0
			return false;
		for(int row = 0; row < board.length; row++)  //checks rows
		{
			if(board[row][c] == n)
				return false;
		}
		for(int col = 0; col < board.length; col++)  //checks columns
		{
			if(board[r][col] == n)
				return false;
		}
		//finds starts of the 3x3 box of n
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
	
	/**
	finds the most constrained spot on the board. returns the row and column of the most constrained spot
	@return int[] int array containing the row and column of the most constrined spot
	*/
	public int[] mostConstrained()
	{
		int lowest = 123456; //initialized with very high number
		int[] mostConstrained = new int[2];
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board.length; c++)
			{
				if(board[r][c] == 0) //only checks spots on board that are 0
				{
					int count = 0;  //counts the number of numbers that can be placed at s spot
					for(int i = 1; i < 10; i++) //goes through numbers 1-9 and checks if the numbers can be placed at the spot
					{
						if(canPlace(r,c,i))
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
	
	/**
	determines whether or not the board is solved
	@return boolean returns true if the board is solved, false if not
	*/
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
	
	/**
	returns string representation of the board
	@return String returns string representation of the board
	*/
	public String toString()
	{
		String s = "";
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[0].length; c++)
			{
				s += "|" + board[r][c];
			}				
			s += "|" + "\n" + "-------------------" + "\n";
		}
		return s;
	}
	
	
}