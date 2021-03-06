import java.util.HashMap;
import java.util.Map;
/**
 * Highly divisible triangular number
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
 * @author yzhang
 *
 */
public class Problem12 {

	public static void main(String[] args)
	{
		long currentTime = System.currentTimeMillis();
		System.out.println(getHighlyDivisibleTriangularNumber(5));
		System.out.println(getHighlyDivisibleTriangularNumber(500));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
	
	private static long getHighlyDivisibleTriangularNumber(int numDivisor)
	{		
		final Map<Integer, Integer> counts = new HashMap<>();
		for(int i =2;;i++)
		{
			final int count;
			//because they are coprime
			if(i%2==0)
			{
				count = primeFactorOrder(i/2,counts)*primeFactorOrder(i+1,counts);
			}
			else
			{
				count = primeFactorOrder(i,counts)*primeFactorOrder((i+1)/2,counts);
			}
			if(count>=numDivisor)
			{
				return i*(i+1)/2;
			}
		}
	}
	
	private static int primeFactorOrder(int num,final Map<Integer, Integer> counts)
	{
		Integer divisorCount = counts.get(num);
		if(divisorCount!=null)
		{
			return divisorCount;
		}
		final Map<Integer, Integer> factorCount = new HashMap<>();
		int value = num;
		int factor =2;
		while(value!=1)
		{
			if(value%factor==0)
			{
				if(factorCount.containsKey(factor))
				{
					factorCount.put(factor,factorCount.get(factor)+1);
				}
				else
				{
					factorCount.put(factor,1);
				}
				value/=factor;
			}
			else
			{
				factor++;
			}
		}
		
		divisorCount = 1;
		for(int count:factorCount.values())
		{
			divisorCount*=(count+1);
		}
		//System.out.println("num = "+num+" "+divisorCount);
		counts.put(num, divisorCount);
		return divisorCount;
	}
}
