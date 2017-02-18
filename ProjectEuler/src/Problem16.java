import java.math.BigInteger;
/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?
 * @author yzhang
 *
 */
public class Problem16 {

	public static void main(String[] args)
	{
		System.out.println(sumOfDigit(15));
		System.out.println(sumOfDigit(1000));
	}
	
	private static int sumOfDigit(int power2)
	{
		final BigInteger ten = BigInteger.valueOf(10);
		BigInteger power = BigInteger.valueOf(2).pow(power2);
		int sum = 0;
		while(!power.equals(power.ZERO))
		{
			sum+=power.mod(ten).intValue();
			power = power.divide(ten);
		}
		return sum;
	}
}
