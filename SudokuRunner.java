public class SudokuRunner
{
	public static void main(String [] args)
	{
		GameBoard b = new GameBoard();
		System.out.println(b);
		System.out.println(b.canPlace(0,0,3));
		System.out.println(b.canPlace(0,1,7));
		int[] a = b.mostConstrained();
		System.out.println(a[0]);
		System.out.println(a[1]);
	}
}