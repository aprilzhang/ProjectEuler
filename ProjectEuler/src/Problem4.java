/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 ¡Á 99. 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
	
	public static void main(String[] args)
	{
		long currentTime = System.currentTimeMillis();
		System.out.println(largestPalindromeProduct(10));
		System.out.println(largestPalindromeProduct(100));
		System.out.println(largestPalindromeProduct(1000));
		System.out.println(System.currentTimeMillis()-currentTime);
		currentTime = System.currentTimeMillis();
		System.out.println(largestPalindromeProduct2(1000));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
	
	private static int largestPalindromeProduct(int limit)
	{
		final int limitSquare = limit*limit;
		for(int i =limitSquare-1;i>=limitSquare/100;i--)
		{
			if(isPalindromic(i))
			{
				for(int factor = (int) Math.ceil(i/(double)limit);factor<limit;factor++)
				{
					if(i%factor==0)
					{
						return i;
					}
				}
			}
		}
		return 0;
	}
	
	private static boolean isPalindromic(int x)
	{
		int reverse = 0;
		int num = x;
		while(num!=0)
		{
			final int mod = num%10;
			reverse = 10*reverse+mod;
			num = (num-mod)/10;
		}
		return x==reverse;
	}
	
	/**
	 * Only work for 1000
	 * Consider the digits
	 *of P ¨C let them be x, y and z. P must be at least 6 digits long since the
	 *palindrome 111111 = 143¡Á777 ¨C the product of two 3-digit integers. Since P is
	 *palindromic:
	 *P=100000x+10000y+1000z+100z+10y+x
	 *P=100001x+10010y+1100z
	 *P=11(9091x+910y+100z)
	 *Since 11 is prime, at least one of the integers a or b must have a factor of 11.
	 *So if a is not divisible by 11 then we know b must be. Using this information
	 *we can determine what values of b we check depending on a:
	 * @param limit
	 * @return
	 */
	private static int largestPalindromeProduct2(int limit)
	{
		int largestPalindrome = 0;
		for (int a = limit-1; a>=limit/10;a--)
		{
			int b;
			int db;
			if(a%11==0)
			{
				b= 999;
				db = 1;
			}
			else
			{
				b = 990;//The largest number less than or equal 999 and divisible by 11
				db = 11;
			}
			while (b>=a)
			{
				final int product = a*b;
				if(product<=largestPalindrome)
				{
					break;
				}
				if(isPalindromic(product))
				{
					largestPalindrome = product;
				}
				b = b-db;
			}
		}
		return largestPalindrome;
	}
}
