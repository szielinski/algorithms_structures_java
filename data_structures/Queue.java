class Queue<T>{
	private T[] seq = (T[])(new Object[10000]);
	private int size = 0;
	private int head = 0;
	private int tail = 0;

	boolean isEmpty(){ return size==0; }
	
	boolean enq(T t) {
		if(size<seq.length){
			seq[tail] = t;
			tail = (tail+1)%seq.length;
			size++;
			return true;
		}
		return false;
	}
	T deq(){
		if(isEmpty()) return null;
		T temp = seq[head];
		head = (head+1)%seq.length;
		size--;
		return temp;
	}
}
