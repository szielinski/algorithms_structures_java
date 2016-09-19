class InsertionSort{
	public static void insertionSort(int[] num){
		int current;
		int i;
		
		for(int sorted=1; sorted<num.length; sorted++){
			current = num[sorted];
			for(i=sorted-1; (i>=0) && (num[i] > current); i--){
				num[i+1]=num[i];
			}
			num[i+1] = current;
		}
	}
	public static void main(String[] args){
		int[] array = {1,62346,34263232,325,134,52164,34631,643213,213};
		for(int a: array)
			System.out.print(a+ " ");
		System.out.println();
		insertionSort(array);
		for(int a: array)
			System.out.print(a+ " ");
	}
}
