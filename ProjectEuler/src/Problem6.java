/**
 * The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author yzhang
 *
 */
public class Problem6 {

	public static void main(String[] args)
	{
		System.out.println(sumOfSquareDiff(10));
		System.out.println(sumOfSquareDiff(100));
	}
	
	public static int sumOfSquareDiff(int limit)
	{
		int sumOfSquare = limit*(limit+1)*(2*limit+1)/6;
		int sum = limit*(limit+1)/2;
		return sum*sum-sumOfSquare;
	}
}
