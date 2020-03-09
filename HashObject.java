/**
 * @author scottloveless
 */
 
 public class HashObject<K> {
	private K key;
	private int duplicateCount;
	private int probeCount;
	
	public HashObject(K k) {
		K key = k;
		duplicateCount = 0;
		probeCount = 0;
	}
	
	public void setK(K k) {
		key = k;
	}
	
	public K getKey() {
		return key;
	}
	
	public void increaseDuplicateCount() {
		duplicateCount++;
	}
	
	public int getDuplicateCount() {
		return duplicateCount;
	}
	
	public void increaseProbeCount() {
		probeCount++;
	}
	
	public int getProbeCount() {
		return probeCount;
	}
	
	@Override
	public  boolean equals(Object other) {
		if (other instanceof K) {
			K o = (K) other;
		}
			return true;
		
			
			
		return false;
		
	}
	
	@Override
	public String toString() {
		String s = key + " " + duplicateCount + " " + probeCount;
		return s;
	}
	

 }