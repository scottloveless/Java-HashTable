import javax.print.attribute.standard.MediaSize.Other;

/**
 * @author scottloveless
 */
 
 public class HashObject<K> extends Object {
	private K key;
	private int duplicateCount;
	private int probeCount;
	
	public HashObject(K k) {
		key = k;
		duplicateCount = 0;
		probeCount = 0;
	}
	
	public void setK(K k) {
		key = k;
	}
	
	public K getKey() {
		return key;
	}
	
	public void incrementDuplicateCount() {
		duplicateCount++;
	}
	
	public int getDuplicateCount() {
		return duplicateCount;
	}
	
	public void incrementProbeCount() {
		probeCount++;
	}
	
	public int getProbeCount() {
		return probeCount;
	}
	
	@Override
	public boolean equals(Object other) {		
		if (this.hashCode() == other.hashCode()) {
			return true;
		}
			// if (other instanceof HashObject<?>) {
		// if ( ((HashObject<?>)other).key.equals(this.key) )
		else 
			return false;
	}
	
	@Override
	public String toString() {
		String s = key + " " + duplicateCount + " " + probeCount;
		return s;
	}
	

 }