class LinkedSet<T>{
	private static class Node<T>{
		private T item;
		private Node<T> next;
		
		Node(T item, Node<T> next){
			this.item = item;
			this.next = next;
		}
	}
	
	private Node<T> head = null;
	
	public int size(){
		int count = 0;
		Node<T> iterator = head;
		while(iterator != null) {
			iterator = iterator.next;
			count++;
		}
		return count;
	}
	
	public boolean add(T t){
		if(contains(t)) return false;
		head = new Node<T>(t,head);
		return true;
	}

	public boolean contains(T t){
		Node<T> iterator = head;
		while(iterator!=null && !equals(iterator.item,t))
			iterator = iterator.next;
		return iterator!=null;
	}

	public boolean remove(T t){
		Node<T> iterator = head;
		Node<T> pred = null;
		while(iterator != null && !equals(t,iterator.item)){
			pred = iterator;
			iterator = iterator.next;
		}
		if(iterator == null) return false;
		if(iterator == head) head = head.next;
		else pred.next = iterator.next;
		return true;
	}
	
	private boolean equals(T t1, T t2){
		if(t1!=null) return t1.equals(t2);
		else return t2==null;
	}
	public static void main(String[] args) {

		  LinkedSet<Integer> test = new LinkedSet<Integer>();

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
