class BetterHash{
private int hash(T t){
	int val = t.hashCode();
	int hashVal = 0;
	while(val!=0){
		hashVal = hashVal+val%hashTable.length;
		val=val/hashTable.length;
	}
	return Math.abs(hashVal%hashTable.length);
}
//for strings
public int hashCode(){
	int hashVal = 0;
	for(int i=0; i<length();i++)
		hashVal = hashVal*31+charAr(i);
	return hashVal;
}
