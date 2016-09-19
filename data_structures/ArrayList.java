import java.util.*;
class ArrayList<T> implements Iterable<T>{
	private T[] seq = (T[]) (new Object[10000]);
	private int size =0;

	public int size(){ return size; }
	
	public T get(int i){
		if(i<0||i>=size()) throw new IndexOutOfBoundsException();
		else return seq[i];
	}
	
	public T set(int i, T t){
		if(i<0||i>=size()) throw new IndexOutOfBoundsException();
		T temp = get(i);
		seq[i] = t;
		return temp;
	}

	public boolean add(T t){
		add(size, t);
		return true;
	}

	public void add(int i, T t){
		if(i<0||i>size) throw new IndexOutOfBoundsException();
		if(size==seq.length) resize();
		for(int k=size; k>i;k--)
			seq[k] = seq[k-1];
		seq[i] = t;
		size++;
	}
	
	private void resize(){
		T[] temp = (T[])(new Object[seq.length*2]);
		for(int i=0;i<seq.length;i++)
			temp[i] = seq[i];
		seq = temp;
	}
	public Iterator<T> iterator(){
		return new MyIterator<>(seq,size);
	}
	private static class MyIterator<T> implements Iterator<T>{
		private T[] seq;
		private int numItems;
		private int current=0;

		MyIterator(T[] seq, int numItems){
			this.seq = seq;
			this.numItems=numItems;
		}

		public boolean hasNext(){ return current<numItems;}
		
		public T next(){
			if(!hasNext()) throw new NoSuchElementException();
			T t = seq[current];
			current++;
			return t;
		}

		public void remove(){}
	}
}
