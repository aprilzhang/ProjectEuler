/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all the primes below two million.
 * @author yzhang
 *
 */
public class Problem10 {
	public static void main(String[] args)
	{
		long currentTime = System.currentTimeMillis();
		System.out.println(sumOfPrime(10));
		System.out.println(sumOfPrime(2000000));
		System.out.println(System.currentTimeMillis()-currentTime);
		currentTime = System.currentTimeMillis();
		System.out.println(sumOfPrime2(10));
		System.out.println(sumOfPrime2(2000000));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
	
	private static long sumOfPrime(int limit)
	{
		final boolean[] notPrime = new boolean[limit];
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2;i<=Math.sqrt(limit);i++)
		{
			if(!notPrime[i])
			{
				for(int j = i*i;j<limit;j+=i)
				{
					notPrime[j] = true;
				}
			}
		}
		long sum = 0;
		for(int i =0;i<limit;i++)
		{
			if(!notPrime[i])
			{
				sum+=i;
			}
		}
		return sum;
	}
	
	
	private static long sumOfPrime2(int limit)
	{
		final int notPrimeBound = (limit-1)/2;
		//2*i+1: 1,3,5,7,9...
		final boolean[] notPrime = new boolean[notPrimeBound];
		final int crossLimit = ((int)Math.sqrt(limit)-1)/2;
		for(int i = 1;i<=crossLimit;i++)
		{
			if(!notPrime[i])// 2*i+1 is prime, mark multiples
			{
				for(int j = 2*i*(i+1);j<notPrimeBound;j+=2*i+1)
				{
					notPrime[j] = true;
				}
			}
		}
		long sum = 2; //2 is prime
		for(int i =1;i<notPrimeBound;i++)
		{
			if(!notPrime[i])
			{
				sum+=(2*i+1);
			}
		}
		return sum;
	}
}
