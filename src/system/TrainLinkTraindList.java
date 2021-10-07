package system;

import java.util.Iterator;

public class TrainLinkTraindList  {

	public static class Node {
		public Train value;
		public Node next;
		
		public String toString() {
			return value.toString();
		}
	}

	int length = 0;
	Node first = null;
	Node   last = null;

	// create new node
	protected Node getNewNode(Train value) {
		Node node = new Node();
		node.next = null;
		node.value = value;
		return node;
	}
	
	public boolean checkNode(Train value)
	{
		Node k = first;
		while(k != null)
		{
			
		}
		return true;
	}

	// Appending at the end
	public Node appendLast(Train value) {
		Node node = getNewNode(value);
		node.value = value;
		if (last != null)
			last.next = node;
		last = node;
		if (first == null) {
			first = node;
		}
		length++;
		return node;
	}

	// Insertion at the beginning
	public Node appendFirst(Train value) {
		Node node = getNewNode(value);
		node.value = value;
		node.next = first;
		first = node;
		if (length == 0)
			last = node;
		length++;
		return node;
	}

	// Insertion at an arbitrary position
	public Node insert(int index, Train value) {
		Node node = getNewNode(value);

		if (index < 0 || index > length) {
			throw new IllegalArgumentException("Invalid index for insertion");
		} else if (index == length) {
			return appendLast(value);
		} else if (index == 0) {
			return appendFirst(value);
		} else {
			Node   result = first;
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

	// Looking up an arbitrary element

	public Train findAtIndex(int index) throws Exception {
		Node   result = first;
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

	// Removing an element in the beginning
	public Node removeFirst() throws Exception {
		if (length == 0) {
			throw new Exception("Error");
		}
		Node   origFirst = first;
		first = first.next;
		length--;
		if (length == 0) {
			last = null;
		}
		return origFirst;
	}

	// Removing an arbitrary element
	protected Node removeAtIndex(int index) throws Exception {
		if (index >= length || index < 0) {
			throw new Exception("Error");
		}
		if (index == 0) {
			Node   nodeRemoved = first;
			removeFirst();
			return nodeRemoved;
		}
		Node justBeforeIt = first;
		while (--index > 0) {
			justBeforeIt = justBeforeIt.next;
		}
		Node   nodeRemoved = justBeforeIt.next;
		if (justBeforeIt.next == last) {
			last = justBeforeIt.next.next;
		}
		justBeforeIt.next = justBeforeIt.next.next;
		length--;
		return nodeRemoved;
	}
	
	//diplay linklist
	public void displayLinkList()
	{
		Node   k = first;
		while(k != null)
		{
			System.out.println(k.toString());
			k = k.next;
		}
	}

	public Iterator   iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
