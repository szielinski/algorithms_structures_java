class ArrayStack<T> {
	private T[] seq = (T[]) (new Object[10000]);
	private int size = 0;
		
	boolean isEmpty(){ return size == 0; }
	
	boolean push(T t){
		if(size<seq.length){
			seq[size++] = t;
			return true;
		}
		return false;
	}
	
	T pop(){
		if(isEmpty()) return null;
		
		return seq[--size];
	}
}
