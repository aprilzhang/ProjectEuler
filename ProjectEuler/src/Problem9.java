/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
	
	a2 + b2 = c2
	For example, 32 + 42 = 9 + 16 = 25 = 52.
	
	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.

 * @author yzhang
 *
 */
public class Problem9 {

	public static void main(String[] args)
	{
		System.out.println(pythagorean(12));
		System.out.println(pythagorean(1000));
	}
	private static int pythagorean(int sum)
	{
		//1000-500000/(1000-B)=A
		final int halfSquare = sum*sum/2;
		final int bLimit = sum-(int)Math.ceil(Math.sqrt(halfSquare));
		for(int b = bLimit;b<1000;b++)
		{
			if(halfSquare%(sum-b)==0)
			{
				final int a = sum-halfSquare/(sum-b);
				final int c = sum-a-b;
				return a*b*c;
			}
		}
		return 0;
	}
}
