import java.util.Random;

/**
 * @author scottloveless
 */

 public class HashTable {
	private int probeType;
	private HashObject<?>[] table;
	private int size;
	private int elementCount;
	private int totalDuplicates;
	private float loadFactor;
	
	public HashTable(int probeType, int tableSize) {
		this.probeType = probeType;
		this.table = new HashObject<?>[tableSize];
		size = tableSize;
		elementCount = 0;
		totalDuplicates = 0;
		updateLoadFactor();
	}
	
	public int getSize() {
		return size;
	}
	
	public int getElementCount() {
		return elementCount;
	}
	
	public int getTotalDuplicates() {
		return totalDuplicates;
	}
	
	private void incrementElementCount() {
		elementCount++;
		updateLoadFactor();
	}
	
	private void updateLoadFactor() {
		loadFactor = ((float)elementCount / (float)size);
	}
	
	public float getLoadFactor() {
		return loadFactor;
	}
	
	public void insert(HashObject<?> o) {
		o.incrementProbeCount();
		int i = 0;
		int tmp;
		
		if (probeType == 0) {// use linear probing
			tmp = o.getKey().hashCode() % size;
		}
		else {
			tmp = (o.getKey().hashCode() % size) + (i * (o.getKey().hashCode() % (size - 2)));
			}
		if (tmp < 0)
			tmp += size;
		int key = tmp;
			
		do {
			if (table[key] == null) { // slot is empty
				table[key] = o;
				incrementElementCount();
				// System.out.print("*\n");
				break;
				
			}
			if ((table[key].getKey()).equals(o.getKey())) {
				table[key].incrementDuplicateCount();
				totalDuplicates++;
				// System.out.println("**\n");
				break;
			}
			if (probeType == 0)
				key = (key + 1) % size;
			if (probeType == 1)
				key = (key % size) + (i * (key % (size - 2)));
		} while (key != tmp);
	}


	
	
	
	

 }