import java.util.Random;

/**
 * @author scottloveless
 */

 public class HashTable {
	
	// int[] primes = { 1,2,3 }; // highs of twin pairs - hardcoded array for efficiency
	// private int primesIndex = 0;
	private int size;
	
	private int elementCount;
	private float loadFactor;
	
	private HashObject[] table;
	
	public HashTable(int probeType) { // int i: pass in an indicator to select appropriate type of probing
		if (probeType == 0) {
			// use linear probing
		} else if (probeType == 1) {
			// use doble hashing
		}
		size = 95791; // use twin prime
		elementCount = 0;
	}
	

 }