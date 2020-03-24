import java.util.Random;

/**
 * @author scottloveless
 */

 public class HashTest {
	public static void main(String[] args) {
		
		int minTableSize = 95500;
		int maxTableSize = 96000;
		int tableSize = getFirstPrimeOlderTwinInRange(minTableSize, maxTableSize);
		
		int inputType = Integer.parseInt(args[0]);
		float loadFactor = Float.parseFloat(args[1]);
		int debugLevel = 0;
		if (args.length == 3) {
			debugLevel = Integer.parseInt(args[2]);
		}
		
		System.out.println("A good table size is found: " + tableSize);
		
		HashTable linearProbe = new HashTable(0, tableSize);
		HashTable doubleHashing = new HashTable(1, tableSize);
				
		if (inputType == 1) {
			System.out.println("Data source type: random number\n");
			Random r = new Random();
			while (linearProbe.getLoadFactor() < loadFactor) {
				Integer i = new Integer(r.nextInt(100000));
				HashObject<?> o = new HashObject<Integer>(i);
				
				linearProbe.insert(o);
				doubleHashing.insert(o);
				
			}
			
		} if (inputType == 2) {
			System.out.println("Data source type: current time\n");
			
			
		} if (inputType == 3) {
			System.out.println("Data source type: word-list\n");
		}
		
		if (debugLevel == 1) {
			// also print the hash tables into files
		}
		int linearTotalProbes = linearProbe.getElementCount() + linearProbe.getTotalDuplicates();
		System.out.println("Using Linear Hashing....");
		System.out.println("Input " + linearTotalProbes + " elements, of which " + linearProbe.getTotalDuplicates() + " duplicates");
		System.out.println("load factor = " + loadFactor + ", Avg. no. of probes " + ((float) linearTotalProbes / (float) linearProbe.getElementCount()) + "\n");
		
		int doubleTotalProbes = doubleHashing.getElementCount() + doubleHashing.getTotalDuplicates();
		System.out.println("Using Double Hashing....");
		System.out.println("Input " + doubleTotalProbes + " elements, of which " + doubleHashing.getTotalDuplicates() + " duplicates");
		System.out.println("load factor = " + loadFactor + ", Avg. no. of probes " + ((float) doubleTotalProbes / (float) doubleHashing.getElementCount()) + "\n");
		
	}

	public static int getRandomIntInRange(int min, int max) {
		if (min >= max) {
			System.out.println("max: " + max + ", min: " + min);
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
		if (p < 6) { // safeguard in case input is < 6
			if (p == 5)
				return true;
			else
				return false;
		}
		if (isPrime(p, numTimesToCheck) && isPrime(p - 2, numTimesToCheck))
			return true;
		else
			return false;
	}
	
	public static int getFirstPrimeOlderTwinInRange(int min, int max) {
		for (int i = min; i <= max; i ++) {
			if (isPrimeOlderTwin(i, 3))
				return i;
		}
		return 0;
	}

	
}