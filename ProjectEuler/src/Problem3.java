/**
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime
 * factor of the number 600851475143 ?
 *
 * @author yuezhang
 *
 */
public class Problem3 {

	public static long lpf(long input) {
		long factor = 2;
		while (input != 1) {
			if (input % factor == 0) {
				input /= factor;
			}
			factor++;
		}
		return factor - 1;
	}

	public static long lpf2(long input) {
		if (input % 2 == 0) {
			while (input % 2 == 0) {
				input /= 2;
			}
		}
		long factor = 2;
		final double maxFactor = Math.sqrt(input);
		while (input != 1 && factor < maxFactor) {
			factor++;
			if (input % factor == 0) {
				input /= factor;
			}
		}
		return input != 1 ? input : factor;
	}

	public static void main(String[] args) {
		System.out.println(lpf(29));
		System.out.println(lpf(13195));
		System.out.println(lpf(600851475143l));
		System.out.println(lpf2(29));
		System.out.println(lpf2(13195));
		System.out.println(lpf2(600851475143l));
	}
}
