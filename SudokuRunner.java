public class SudokuRunner
{
	public static void main(String [] args)
	{
		GameBoard b = new GameBoard();
		int[] x = b.mostConstrained();
		System.out.println(x[0]);
		System.out.println(x[1]);
		System.out.println(b);
	}
}