class LinearSearch{
	final static int FALSE = -1;
	static int linearSearch(int[] a, int val){
		for(int i=0;i<a.length;i++){
			if(a[i]==val)
				return i;
		}
		return FALSE;
	}
}
