import java.util.*;
class TreeSet<T extends Comparable<T>> implements Iterable<T>{
	private static class Node<T>{
		private T item;
		private Node<T> left, right;
		
		Node(T item, Node<T> left, Node<T> right){
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
	private Node<T> root = null;
	private int numItems = 0;
	
	public int size(){ return numItems; }
	
	boolean contains(T t){
		return contains(root,t);
	}
	
	private boolean contains(Node<T> p, T t){
		if(p==null) return false;
		else if((p.item).equals(t)) return true;
		else if((p.item).compareTo(t)>0) return contains(p.left, t);
		else return contains(p.right,t);
	}
	
	public boolean add(T t){
		int numItems0 = numItems;
		root = add(root,t);
		return numItems0<numItems;
	}

	//add t (if not present) to binary search tree rooted at p & return root of new tree (which is usually p)
	private Node<T> add(Node<T> p, T t){
		if(p==null){
			numItems++;
			return new Node<T>(t,null,null);
		}
		else if((p.item).compareTo(t)>0){
			p.left = add(p.left,t); //note possible new p.left
			return p;	
		}
		else if(t.compareTo(p.item)>0){
			p.right = add(p.right,t);
			return p;
		}
		else
			return p; //t is present in the node, so no change
	}

	public boolean remove(T t){
		int numItems0 = numItems;
		root = remove(root, t);
		return (numItems<numItems0);
	}

	//remove t (if present) from binary search tree rooted at p & return root of new tree	
	private Node<T> remove(Node<T> p, T t) {
		if(p==null)
			return p;
		else if((p.item).compareTo(t)>0){
			p.left = remove(p.left, t);
			return p;
		} else if ((p.item).compareTo(t)<0){
			p.right = remove(p.right, t);
			return p;
		} else { //t in node p: remove node p & merge its two subtrees
			numItems--;
			return mergeTrees(p.left, p.right);
		}
	}
	/* Merge binary search trees rooted at p and q and return new root. Input trees are disjoint, and values
	   and values in tree p are less than values in tree q. */	
	private Node<T> mergeTrees(Node<T> p, Node<T> q){
		if(q==null) // trivial case: tree q is empty
			return p;
		else if(q.left==null){ //easy case: q has empty left subtree
			q.left = p;
			return q;	
		} else { //general case: tree q has non-empty left subtree. Locate leftmost node in tree q
			Node<T> ptr = q.left;
			Node<T> ptrParent = q;	//always ptrParent.left = ptr
			while(ptr.left!=null){
				ptrParent = ptr; 
				ptr = ptr.left;
			}
			//ptr is leftmost node in tree q (i.e. with least value)		
			ptrParent.left = ptr.right; //detach node ptr from tree q
			ptr.left = p; //node ptr becomes new root
			ptr.right = q;
			return ptr;
		}
	}
	//toList creates a sorted lis of items in the set
	private ArrayList<T> toList(){
		ArrayList<T> items = new ArrayList<T>();
		inOrder(root, items);
		return items;
	}
	private void inOrder(Node<T> p, ArrayList<T> items){
		if(p!=null){
			inOrder(p.left, items);
			items.add(p.item);
			inOrder(p.right,items);
		}
	}

	public String toString(){
		return toList().toString();
	}

	//iteration over TreeSet<T>
	public Iterator<T> iterator(){
		return toList().iterator();
	}
}
	
	
