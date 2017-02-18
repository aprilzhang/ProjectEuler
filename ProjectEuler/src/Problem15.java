import java.math.BigInteger;
/**
 * Lattice paths
Problem 15
Starting in the top left corner of a 2¡Á2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20¡Á20 grid?

 * @author yzhang
 *
 */
public class Problem15 {

	public static void main(String[] args)
	{
		System.out.println(paths(2));
		System.out.println(paths(3));
		System.out.println(paths(20));
	}
	
	private static BigInteger paths(int n)
	{
		BigInteger nFacotial =BigInteger.valueOf(1);
		for(int i = 1;i<=n;i++)
		{
			nFacotial =nFacotial.multiply(BigInteger.valueOf(i));
		}
		//(2n)
		// (n)
		BigInteger twoNFactorial = new BigInteger("1");
		for(int i = n+1;i<=2*n;i++)
		{
			twoNFactorial =twoNFactorial.multiply(BigInteger.valueOf(i));
		}
		
		return twoNFactorial.divide(nFacotial);
	}
}
