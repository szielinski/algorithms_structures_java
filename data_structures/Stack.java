class Stack<T>{
	private class Node<T> {
		private	T item;
		private Node<T> next = null;
		
		Node(T item, Node<T> next){
			this.item = item;
			this.next = next;
		}
	}
	private Node<T> head = null;
	
	boolean isEmpty(){ return head==null;}
	
	boolean push(T t){
		head = new Node<T>(t,head);
		return true;
	}

	T pop(){
		if(isEmpty()) return null;
		T t = head.item;
		head = head.next;
		return t;
	}
}
