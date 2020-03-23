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

		
		if (args.length == 3) {
			int debugLevel = Integer.parseInt(args[2]);
			if (debugLevel == 0) {
				// print summary of experiment on the console
			} else if (debugLevel == 1) {
				// print summary of experiment on the console and print the hash tables to two files - see sample files
			} else {
				// error
			}
		}
		
		for (int i = 95500; i < 96000; i ++) {
			if (isPrimeOlderTwin(i, 3)) {
				System.out.print(i + ", ");
				
			
			}
		}
	}

	// 	Twins: [95789, 95791][95801, 95803][95957, 95959][95987, 95989]

	public static int getRandomIntInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static boolean isPrime(int p, int numTimesToCheck) {
		String binaryString = Integer.toBinaryString(p - 1);
		
		for (int numChecks = 0; numChecks < numTimesToCheck; numChecks++) {
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
			if (result != 1) // not prime
				return false;
		}
		return true; // passed for all numTimesToCheck times
		
	}
	
	public static boolean isPrimeOlderTwin(int p, int numTimesToCheck) {
		if (isPrime(p, numTimesToCheck) && isPrime(p - 2, numTimesToCheck))
			return true;
		else
			return false;
	}
	
}