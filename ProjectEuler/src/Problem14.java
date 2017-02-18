import java.util.HashMap;
import java.util.Map;
/**
 * The following iterative sequence is defined for the set of positive integers:

n ¡ú n/2 (n is even)
n ¡ú 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 ¡ú 40 ¡ú 20 ¡ú 10 ¡ú 5 ¡ú 16 ¡ú 8 ¡ú 4 ¡ú 2 ¡ú 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 * @author yzhang
 *
 */
public class Problem14 {
	public static void main(String[] args)
	{
		long currentTime = System.currentTimeMillis();
		System.out.println(longestCollatzSquence(6));
		System.out.println(longestCollatzSquence(1000000));
		System.out.println(System.currentTimeMillis()-currentTime);
	}
	
	private static int longestCollatzSquence(int limit)
	{
		final Map<Long,Integer> counts = new HashMap<>();
		counts.put(1l, 1);
		int longest = 1;
		int longestStart = 1;
		for(int i =2;i<limit;i++)
		{
			int count = countSequence(counts,i);
			if(longest<count)
			{
				longest = count;
				longestStart = i;
				System.out.println("longestStart = "+i);
			}
		}
		return longestStart;
	}
	
	private static int countSequence(final Map<Long,Integer> known, long num)
	{
		int newCount = 0;
		long currentNum = num;
		while(!known.containsKey(currentNum))
		{
			if(currentNum%2==1)
			{
				currentNum = 3*currentNum+1;
			}
			else
			{
				currentNum = currentNum/2;
			}
			newCount++;
		}
		final int count = newCount+known.get(currentNum);
		known.put(num, count);
		System.out.println("num = "+num+" count = "+count);
		return count;
	}
}
