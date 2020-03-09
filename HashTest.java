import java.util.Random;

/**
 * @author scottloveless
 */

 public class HashTest {
	public static void main(String[] args) {
		
		int inputType = Integer.parseInt(args[0]);
		if (inputType == 1) {
			// use Integer objects
		
		} else if (inputType == 2) {
			// use Long objects
		} else if (inputType ==3) {
			// use String objects
		} else {
			// error
		}

		float loadFactor = Float.parseFloat(args[1]);

		int debugLevel = Integer.parseInt(args[2]);
		if (debugLevel == 0) {
			// print summary of experiment on the console
		} else if (debugLevel == 1) {
			// print summary of experiment on the console and print the hash tables to two files - see sample files
		} else {
			// error
		}

		
		// Twins: [95789, 95791][95801, 95803][95957, 95959][95987, 95989]
		int temp = 0;
		System.out.print("Twins: ");
		for (int i = 95500; i <= 96000; i++) {
			if (isPrimeClassic(i)) {
				if (i - 2 == temp) {
					System.out.print("(" + temp + ", " + i + ")");
				}
				temp = i;
			}
		}
		System.out.println();
	}
	public int getRandomIntInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public boolean isPrime(int i) {
		if (i == 2 || i == 3)
		return true;
		int a = getRandomIntInRange(2, i - 1);
		int b = getRandomIntInRange(2, i - 1);
		while (b == a)
		b = getRandomIntInRange(2, i);
		System.out.println("i: " + i + ", a: " + a + ", b: " + b);
		if (Math.pow(a, (i - 1)) % i != 1 && Math.pow(b, (i - 1)) % i != 1) {
			return false;
		}
		System.out.println("PRIME: " + i);
		return true;
	}
	
	public static boolean isPrimeClassic(int i) {
		if (i <= 1)
		return false;
		if (i == 2 || i == 3)
		return true;
		for (int j = 2; j < (int) Math.sqrt(i); j++) {
			if (i % j == 0)
				return false;
		}
		return true;
	}

}