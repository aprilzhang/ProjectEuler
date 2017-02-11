import java.util.ArrayList;
import java.util.List;
/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13. 
 * What is the 10 001st prime number?
 * @author yzhang
 *
 */
public class Problem7 {

	public static void main(String[] args)
	{
		long currentTime = System.currentTimeMillis();
		System.out.println(nthPrime(6));
		System.out.println(nthPrime(10001));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
	
	private static long nthPrime(int nth)
	{
		final List<Long> primeFactors = new ArrayList<>();
		primeFactors.add(2l);
		long num = 3;
		while(primeFactors.size()< nth)
		{
			if(isPrime(primeFactors,num))
			{
				primeFactors.add(num);
			}
			num+=2;
		}
		return primeFactors.get(nth-1);
	}
	
	private static boolean isPrime(List<Long> primeFactors, long num)
	{
		for(long factor :primeFactors)
		{
			if(num%factor==0)
			{
				return false;
			}
		}
		return true;
	}
}
