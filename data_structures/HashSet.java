import java.util.*;

class HashSet<T> {
	private LinkedSet<T>[] hashTable;
	
	HashSet(){
		hashTable = (LinkedSet<T>[])(new LinkedSet[1000]);
		for(int i=0; i<hashTable.length; i++){
			hashTable[i] = new LinkedSet<T>();
		}
	}
		
	HashSet(int maxSize){
		hashTable = (LinkedSet<T>[])(new LinkedSet[maxSize]);
		for(int i=0; i<hashTable.length; i++){
			hashTable[i] = new LinkedSet<T>();
		}
	}

	private int hash(T t){
		return Math.abs(t.hashCode()%hashTable.length);
	}

	int size(){
		int numItems=0;
		for(LinkedSet<T> miniSet: hashTable)
			numItems = numItems+miniSet.size();
		return numItems;
	}
	
	boolean contains(T t){
		return hashTable[hash(t)].contains(t);
	}
	
	boolean add(T t){
		return hashTable[hash(t)].add(t);
	}
	
	boolean remove(T t){
		return hashTable[hash(t)].remove(t);
	}
}
