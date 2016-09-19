class QuickSort{

	static void sort(int[] b){
		quickSort(b,0,b.length);
	}
	
	static int median(int a, int b, int c){
		if(a>b){
			if(b>c)
				return b;
			if(a>c)
				return c;
			return a;
		} else {
			if(a>c)
				return a;
			if(b>c)
				return c;
			return b;
		}
	}

	static void quickSort(int[] b, int lo, int hi){
		if(hi-lo >= 2) {
			//int pivot = b[lo];
			
			int pivot = median(b[lo], b[hi-1], b[(lo+hi)/2]);

			int lowerBound=lo;
			int current=lo;
			int upperBound=hi;
			
			while(current!=upperBound){
				if(b[current]==pivot)
					current++;
				else if(b[current]<pivot){
					int temp = b[lowerBound];
					b[lowerBound]=b[current];
					b[current]=temp;
					lowerBound++;
					current++;
				} else {
					upperBound--;
					int temp =b[current];
					b[current]=b[upperBound];
					b[upperBound]=temp;
				}
			}
			quickSort(b,lo,lowerBound);
			quickSort(b,current,hi);
		}
	}
	public static void main(String[] args){
		int[] array = { 5,321,64,36,34,61,23,63,643,52164361,233};
		for(int i: array){
			System.out.print(i + " ");
		}
		System.out.println();
		quickSort(array, 0, array.length);
		for(int i: array){
			System.out.print(i + " ");
		}
	}
		
}
