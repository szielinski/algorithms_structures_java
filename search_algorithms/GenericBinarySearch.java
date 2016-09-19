class GenericBinarySearch<T extends Comparable<T>>{
	private T array[];
		
	GenericBinarySearch(T[] array){
		this.array = array;
	}
	public int binarySearch(T key){
		int lo=0;
		int hi = array.length-1;
		
		while(lo<=hi){
			int mid = lo + (hi-lo)/2;
			int result = key.compareTo(array[mid]);

			if(result < 0) 
				hi = mid-1;
			else if(result > 0)
				lo = mid+1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args){
		String[] array = {"are", "hello", "how", "today", "world", "you"};
		for(String s:array)
			System.out.print(s+ " ");
		System.out.println();
		GenericBinarySearch a = new GenericBinarySearch(array);
		System.out.println(a.binarySearch("dad"));
		System.out.println(a.binarySearch("how"));
		System.out.println(a.binarySearch("today"));
		System.out.println(a.binarySearch("hello"));
		System.out.println(a.binarySearch("are"));
		System.out.println(a.binarySearch("you"));
	}
}	
