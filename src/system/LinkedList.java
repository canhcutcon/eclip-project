package system;

import java.util.Iterator;


public class LinkedList<E> implements Iterable<E> {

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	protected static class Node<E> {
		protected E value; // dataa
		protected Node next; // pnext

		public String toString() {
			return value.toString();
		}
	}

	int length = 0; 
	Node<E>[] lastModifiedNode; // dslk
	Node<E> head; 
	Node<E> tail;

	protected Node<E> getNewNode() {
		Node<E> node = new Node<>();
		lastModifiedNode = new Node[] { node };
		return node;
	}
	boolean isEmtry() {
		return head == null;
	}
	
	int size() {
    	Node<E> tmp = head;
    	int result = 0;
    	while (tmp != null) {
    		result++;
    		tmp = tmp.next;
    	}
    	return result;
    }
	
	//Appending at the end
	public Node<E> addLast(E value) {
		Node node = getNewNode();
		node.value = value;
		if (tail != null)
			tail.next = node;
		tail = node;
		if (head == null) {
			head = node;
		}
		length++;
		return node;
	}
	
	// appendFist 
	public Node<E> addhead(E value) {
		Node node = getNewNode();
		node.value = value;
		node.next = head;
		head = node;
		if (length == 0)
			tail = node;
		length++;
		return node;
	}
	
// Insertion at an arbitrary position
	public Node<E> insert(int index, E value) {
		Node<E> node = getNewNode();
		if (index < 0 || index > length) {
			throw new IllegalArgumentException("Invalid index for insertion");
		} else if (index == length) {
			return addLast(value);
		} else if (index == 0) {
			return addhead(value);
		} else {
			Node<E> result = head;
			while (index > 1) {
				index--;
				result = result.next;
			}
			node.value = value;
			node.next = result.next;
			result.next = node;
			length++;
			return node;
		}
	}
	//Looking up an arbitrary element
	public E findAtIndex(int index) throws Exception {
		Node<E> result = head;
		while (index >= 0) {
			if (result == null) {
				throw new Exception("Error");
			} else if (index == 0) {
				return result.value;
			} else {
				index--;
				result = result.next;
			}
		}
		return null;
	}
	
	
	//Removing an element in the beginning
	public Node<E> removehead() throws Exception {
		if (length == 0) {
			throw new Exception("Error");		}
		Node<E> orighead = head;
		head = head.next;
		length--;
		if (length == 0) {
			tail = null;
		}
		return orighead;
	}

	//Removing an arbitrary element
	protected Node<E> removeAtIndex(int index) throws Exception {
		if (index >= length || index < 0) {
			throw new Exception("Error");
		}
		if (index == 0) {
			Node<E> nodeRemoved = head;
			removehead();
			return nodeRemoved;
		}
		Node justBeforeIt = head;
		while (--index > 0) {
			justBeforeIt = justBeforeIt.next;
		}
		Node<E> nodeRemoved = justBeforeIt.next;
		if (justBeforeIt.next == tail) {
			tail = justBeforeIt.next.next;
		}
		justBeforeIt.next = justBeforeIt.next.next;
		length--;
		return nodeRemoved;
	}
	public void removeAll() {
		head = tail = null;
	}
	// display list
	public void displayLinkedList()
	{
		Node<E> current = head;
		while(current != null)
		{
			System.out.println(current.toString());
			current = current.next;
		}
	}
	
	//sort
	public void swap(Node<E> i,Node<E> j){ 
        if(i.value==j.value) 
            return; 
        Node<E> temp = getNewNode();
		temp.value= i.value; 
        i.value= j.value; 
        j.value = temp.value; 
    }
	
	
}
