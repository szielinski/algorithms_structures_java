import java.util.*;

class SingleLinkedList<T> implements Iterable<T>{
	private static class Node<T>{
		private T item;
		private Node<T> next;
		
		Node(T item, Node<T> next){
			this.item = item;
			this.next = next;
		}
	}
	private Node<T> head = null;
	private Node<T> tail = null;
	private int numItems=0;
	
	public int size(){
		return numItems;
	}
	public T get(int i){
		if(i<0||i>=numItems) throw new IndexOutOfBoundsException();
		int counter = 0;
		Node<T> temp = head;
		while(counter != i){
			counter++;
			temp = temp.next;
		}
		return temp.item;
	}
	public T set(int i, T t){
		if(i<0||i>=numItems) throw new IndexOutOfBoundsException();
		Node<T> temp = head;
		int counter=0;
		while(counter<i){
			counter++;	
			temp = temp.next;
		}
		T object=temp.item;
		temp.item = t;
		return object;			
	}
	public boolean add(T t){
		Node<T> temp = new Node<T>(t, null);
		if(tail!=null) 
			tail.next = temp;
		else
			head = temp;
		tail = temp;
		numItems++;
		return true;
	}
	public void add(int i, T t){
		if(i<0||i>numItems) throw new IndexOutOfBoundsException();
		if(i==0){
			head = new Node<T>(t, head);
			if(tail==null)
				tail = head;
		} else {
			Node<T> temp = new Node<T>(t, null);
			int counter = 0;
			Node<T> iterator = head;	
			while(counter<i){
				counter++;
				iterator=iterator.next;
			}
			temp.next = iterator.next;	
			iterator.next = temp;
			if(iterator==tail) tail = temp;
		}
		numItems++;
	}
	public T remove(int i){
		if(i<0||i>=numItems) throw new IndexOutOfBoundsException();
		T item = null;
		if(i==0){
			item = head.item;
			if(head==tail)
				tail=null;
			head = head.next;
		}else{
			int counter = 0;
			Node<T> temp = head;
			while(counter<i-1){
				temp = temp.next;
				counter++;
			}
			Node<T> toRemove = temp.next;
			item = toRemove.item;
			temp.next = toRemove.next;
			if(toRemove==tail) tail = temp;	
		}
		numItems--;
		return item;
	}
	public Iterator<T> iterator(){
		return new MyIterator<>(head);
	}
	private static class MyIterator<T> implements Iterator<T>{
		private Node<T> head;
		MyIterator(Node<T> head){
			this.head = head;
		}
		public boolean hasNext(){
			return head.next != null;
		}
		public T next(){
			if(head == null) throw new NoSuchElementException();
			T t = head.item;
			head = head.next;
			return t;
		}
		public void remove(){}
	}
}
