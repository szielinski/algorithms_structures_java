class ArraySet<T>{
	private T[] seq = (T[])(new Object[10000]);
	private int numItems = 0;
	
	public int size(){ return(numItems);}
	
	public boolean add(T t){
		if(contains(t)) return false;
		if(numItems==seq.length) resize();
		seq[numItems] = t;
		numItems++;
		return true;
	}
	
	private void resize(){
		T[] temp = (T[])(new Object[seq.length*2]);
		for(int i=numItems;i>0;i--){
			temp[i] = seq[i-1];	
		}
		seq = temp;
	}

	public boolean remove(T t){
		int i=0;
		while(i<numItems && !equals(seq[i],t))
			i++;
		if(i==numItems) return false;
		else{
			numItems--;
			seq[i] = seq[numItems];
			return true;	
		}
	}

	public boolean contains(T t){
		for(int i=0; i<numItems;i++)
			if(equals(t,seq[i]))
				return true;
		return false;
	}
	
	private boolean equals(T t1, T t2){
		if(t1!=null) return t1.equals(t2);
		else return t2 == null;
	}
	public static void main(String[] args) {

		  ArraySet<Integer> test = new ArraySet<Integer>();

		  test.add(1);
		  test.add(2);
		  test.add(3);

		  for(int i = 0; i < 10; i ++) {
			   System.out.println("Testing i = " + i + " - " + test.contains(i));
		  }

		  System.out.println(); System.out.println(); System.out.println();

		  System.out.println(test.remove(1));

		  for(int i = 0; i < 10; i ++) {
			   System.out.println("Testing i = " + i + " - " + test.contains(i));
		  }
	 }
}
