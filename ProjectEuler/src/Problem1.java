/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 *
 * @author yuezhang
 *
 */
public final class Problem1 {

	public static long multiples35(int limit) {
		long sum = 0;
		for (int i = 0; i < limit; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static long multiples352(int limit) {
		return sumDivisibleBy(3, limit) + sumDivisibleBy(5, limit)
				- sumDivisibleBy(15, limit);
	}

	public static long sumDivisibleBy(int n, int limit) {
		final int p = (limit - 1) / n;
		return n * p * (p + 1) / 2;
	}

	public static void main(String[] args) {
		System.out.println(multiples35(10));
		System.out.println(multiples35(1000));
		System.out.println(multiples352(10));
		System.out.println(multiples352(1000));
	}
}
