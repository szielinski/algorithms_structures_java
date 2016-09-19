import java.util.*;

class DoublyLinkedList<T> implements Iterable<T>{
	private static class Node<T>{
		private T item;
		private Node<T> next = null;
		private Node<T> prev = null;
		
		Node(T item, Node<T> prev, Node<T> next){
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}
	private Node<T> head = null;
	private Node<T> tail = null;
	private int numItems = 0;
		
	public int size(){ return numItems; }
	
	public T get(int i){
		if(i<0||i>=size()) throw new IndexOutOfBoundsException();
		int counter = 0;
		Node<T> iterator = head;
		while(counter<i){
			head = head.next;
			counter++;
		}
		return head.item;
	}
	
	public T set(int i, T t){
		if(i<0||i>=size()) throw new IndexOutOfBoundsException();
		int counter = 0;
		Node<T> iterator = head;
		while(counter<i){
			head = head.next;
			counter++;
		}
		T temp = iterator.item;
		iterator.item = t;
		return temp;
	}
	
	public boolean add(T t){
		if(head==null){
			head = new Node<T>(t, null, null);
			tail = head;
		} else {
			tail.next = new Node<T>(t, tail, null);
			tail = tail.next;
		}
		numItems++;
		return true;
	}
	
	public void add(int i, T t){
		if(i<0||i>size()) throw new IndexOutOfBoundsException();
		if(i==0){
			head = new Node<T>(t, null, head);
			if(tail==null) tail = head;
			else
				head.next.prev = head;
		}else{
			Node<T> iterator = head;
			int counter = 0;
			while(counter<i-1){
				iterator = iterator.next;
				counter++;
			}
			iterator.next = new Node<T>(t, iterator, iterator.next);
			if(tail == iterator) tail = iterator.next;
			else iterator.next.next.prev = iterator.next;
		}
		numItems++;	
	}

	public T removeLast(){
		if(size() == 0) throw new NoSuchElementException();
		T t = tail.item;
		tail = tail.prev;
		numItems--;
		if(tail==null) head=null;
		else tail.next = null;
		return t;
	}

	public T remove(int i){
		if(i<0 || i>= size()) throw new IndexOutOfBoundsException();
		T item = null;
		if(i==0){
			item = head.item;
			head = head.next;
			if(head==null) tail = null;
			else head.prev = null;
		}else{
			int counter = 0;
			Node<T> iterator = head;
			while(counter<i){
				counter++;
				iterator = iterator.next;
			}
			item = iterator.item;
			iterator.prev.next = iterator.next;
			if(iterator==tail) tail = iterator.prev;
			else iterator.next.prev = iterator.prev;
		}
		numItems--;
		return item;
	}

	public Iterator<T> iterator(){
		return new MyIterator<T>(head);
	}

	private static class MyIterator<T> implements Iterator<T>{
		private Node<T> current;
		MyIterator(Node<T> head){
			current = head;
		}	
		public boolean hasNext(){ return current!=null; }
		
		public T next(){
			if(current==null) throw new NoSuchElementException();
			T t = current.item;
			current = current.next;
			return t;
		}

		public void remove(){}
	}
	
}
