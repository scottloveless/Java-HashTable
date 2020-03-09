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
		
		for (int i = 95500; i < 96000; i ++) {
			if (isPrime(i)) {
				System.out.print(i + ", ");
				
			
			}
		}
		
	}

		
	// 	Twins: [95789, 95791][95801, 95803][95957, 95959][95987, 95989]
	// 	int temp = 0;
	// 	System.out.print("Twins: ");
	// 	for (int i = 95500; i <= 96000; i++) {
	// 		if (isPrimeClassic(i)) {
	// 			if (i - 2 == temp) {
	// 				System.out.print("(" + temp + ", " + i + ")");
	// 			}
	// 			temp = i;
	// 		}
	// 	}
	// 	System.out.println();
		
	// 	System.out.println(isPrime(95791));

	// }
	


	public static int getRandomIntInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public boolean isPrime0(int i) {
		if (i == 2 || i == 3)
			return true;
		int a = getRandomIntInRange(2, i - 1); // check 3 nims
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

	// public static boolean isPrimeClassic(int i) {
	// if (i <= 1)
	// return false;
	// if (i == 2 || i == 3)
	// return true;
	// for (int j = 2; j < (int) Math.sqrt(i); j++) {
	// if (i % j == 0)
	// return false;
	// }
	// return true;
	// }
	public static boolean isPrime(int p) {
		String binaryString = Integer.toBinaryString(p - 1);
		int result = 0;
		int cursor = 0;
		
		int r = getRandomIntInRange(2, p - 1);
		
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				result = r; // first 1
				cursor = i + 1;
				break;
			}
		}
		for (int i = cursor; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				result = (int) ((Math.pow(result, 2) * r) % p);
			} else {
				result = (int) (Math.pow(result, 2) % p);
			}
		}
		
		return result == 1;
	}
	
	/**
	 * Example: 6^28 mod 29
	 * Binary: 111000
	 * 
	 * 1st 1: 6
	 * 2nd 1: 6^2 * 6 mod 29 = 13
	 * 3rd 1: 13^2 * 6 mod 29 = 28
	 * 1st 0: 28^2 mod 29 = 1
	 * 2nd 0: 1^2 mod 29 = 1
	 */
	
}