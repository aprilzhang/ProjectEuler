import java.util.HashMap;
import java.util.Map;
/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder. 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author yzhang
 *
 */
public class Problem5 {
	public static void main(String[] args)
	{
		long currentTime = System.currentTimeMillis();
		System.out.println(evenlyDivisible(10));
		System.out.println(evenlyDivisible(20));
		System.out.println(System.currentTimeMillis()-currentTime);
		currentTime = System.currentTimeMillis();
		System.out.println(evenlyDivisible2(20));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
	
	public static int evenlyDivisible(int limit)
	{
		final Map<Integer,Integer> primeFactorsCount = new HashMap<>();
		for(int i = 1;i<=limit;i++)
		{
			int num =i;
			for(int factor =2;factor<=num;factor++)
			{
				int count = 0;
				while(num%factor==0)
				{
					count++;
					num/=factor;
				}
				if(count==0)
				{
					continue;
				}
				if(primeFactorsCount.containsKey(factor))
				{
					primeFactorsCount.put(factor, Math.max(primeFactorsCount.get(factor), count));
				}
				else
				{
					primeFactorsCount.put(factor,count); 
				}
			}
		}
		
		int result = 1;
		for(int factor:primeFactorsCount.keySet())
		{
			for(int i =0;i<primeFactorsCount.get(factor);i++)
			{
				result*=factor;
			}
		}
		return result;
	}
	
	
	//For special case 20
	public static int evenlyDivisible2(int limit)
	{
		//we know prime factors are 
		final int[] primeFactors = {2,3,5,7,11,13,17,19};
		
		int result = 1;
		int l = (int) Math.sqrt(limit);
		for(int factor:primeFactors)
		{
			int count = 1;
			if(factor<=l)
			{
				count = (int) Math.floor(Math.log(limit)/ Math.log(factor));
			}
			result *=Math.pow(factor,count);
		}
		return result;
	}
}
