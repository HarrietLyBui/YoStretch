/**
 * 
 */

/**
 * @author bui23l
 *
 */
public class LinkedList<T> {
	// new variable head of type LinkedListNode<T> is first equal to null
	private LinkedListNode<T> head = null;

	// constructor
	LinkedList() {

	}

	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst() {
		// return data of the first node
		return head.getData();

	}

	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode() {
		// return the first node
		return head;
	}

	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast() {
		// create a new Node
		LinkedListNode<T> newNode = new LinkedListNode();
		// set newNode to have data of head
		newNode = head;
		// if the list is not emplty
		if (!isEmpty()) {
			// while there is a next node
			while (newNode.getNext() != null) {
				// move the newNode along the list
				newNode = newNode.getNext();
			}
		}
		// return the last node
		return newNode.getData();

	}

	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode() {

		// create a new Node
		LinkedListNode<T> newNode = new LinkedListNode();
		// set newNode to have data of head
		newNode = head;
		// if the list is not empty
		if (!isEmpty()) {
			// while the next node is not empty
			while (newNode.getNext() != null) {
				// move newNode along the list until the last node
				newNode = newNode.getNext();
			}

		}
		// return the last node of the list
		return newNode;

	}

	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst(T data) {

		// create a new Node
		LinkedListNode<T> newNode = new LinkedListNode();
		// if the first node is null
		if (head == null) {
			// set data of the newNode
			newNode.setData(data);
			// make newNode the head node
			head = newNode;
		}
		// if the first node is not null
		else {
			newNode.setNext(head);

			// set newNode as the head node of the list
			head = newNode;
			// set data of the head node
			head.setData(data);
		}
	}

	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter(LinkedListNode<T> currentNode, T data) {

		// create a new node to hold the new data
		LinkedListNode<T> newNode = new LinkedListNode();
		// create a new node that holds the node after the new node is inserted
		LinkedListNode<T> afterCurrentNode = new LinkedListNode();
		// if there is a node after the currentNode
		if (currentNode.getNext() != null) {
			// set the afterCurrentNode to be the current node that is after the
			// currentNode
			afterCurrentNode = currentNode.getNext();
			// set the newNode to be the next node after the current node
			currentNode.setNext(newNode);
			// insert new data to the newNode
			newNode.setData(data);
			// make newNode points to the afterCurrentNode node in the list
			newNode.setNext(afterCurrentNode);
		}

	}

	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast(T data) {

		// create a new Node
		LinkedListNode<T> newNode = new LinkedListNode();

		// set data for the node at the tail
		newNode.setData(data);

		// add new Node to the tail of the list
		getLastNode().setNext(newNode);

	}

	/**
	 * Remove the first node
	 **/
	public void deleteFirst() {
		// make the head points to the second node of the old list
		head = head.getNext();
	}

	/**
	 * Remove the last node
	 **/
	public void deleteLast() {

		// create a new Node
		LinkedListNode<T> newNode = new LinkedListNode();
		// newNode is a new head
		newNode = head;
		// if the list is not emplty
		if (!isEmpty()) {
			// if the list's size is greater than 1
			if (size() > 1) {
				// if there is a node after the second node of the newNode
				if (newNode.getNext().getNext() != null) {
					// when there is still a node after the second node after
					// the newNode
					while (newNode.getNext().getNext() != null) {
						// move the newNode along the list
						newNode = newNode.getNext();

					}
					// set the last node to null
					newNode.setNext(null);

				}

				else if (newNode.getNext() != null) {
					// set the last node to null if there are two nodes in the
					// list

					newNode.setNext(null);

				}

			}
			// if the size of the list is 1
			else {

				// set the head node to null if there is only one node in the
				// list
				head = null;
			}

		}

	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 **/
	public void deleteNext(LinkedListNode<T> currentNode) {
		// create a new Node
		LinkedListNode<T> afterCurrentNode = new LinkedListNode();
		// if there is a node after node after the current node
		if (currentNode.getNext().getNext() != null) {
			// set afterCurrentNode to be that node after the node after the
			// current node
			afterCurrentNode = currentNode.getNext().getNext();
			// set pointer of the currentNode to the new node to delete the olde
			// node after the currentNode
			currentNode.setNext(afterCurrentNode);

		}

	}

	/**
	 * Return the number of nodes in this list.
	 **/
	public int size() {
		// variable size of type int equal to 0
		int size = 0;
		// create a new Node
		LinkedListNode<T> newNode = new LinkedListNode();
		// set newNode to be the head node
		newNode = head;
		// if the list is empty
		if (head == null) {
			// the size is 0
			size = 0;
		}
		// if the list is not empty
		else {
			// if there is a node that not empty
			while (newNode != null) {
				// increase size by 1
				size++;
				// move newNode along the list
				newNode = newNode.getNext();
			}

		}

		// return size of the list
		return size;

	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 **/

	public boolean isEmpty() {
		// if the list is empty
		if (head == null)
			// return true
			return true;
		// if the list is not empty
		else

			// return false
			return false;
	}

	/**
	 * Return a String representation of the list.
	 **/

	public String toString() {

		// create a new Node

		LinkedListNode<T> newNode = new LinkedListNode();
		// set newNode to be a new head
		newNode = head;
		// variable display of type String is first empty
		String display = "";
		// if the list is not empty
		if (!isEmpty()) {

			// set display to display data of the node
			display = newNode.toString();
			// when there is still a next node
			while (newNode.getNext() != null) {
				// move newNode along the list
				newNode = newNode.getNext();
				// concatenate display to display the list
				display += "-> " + newNode.toString();

			}

		}
		// return display
		return display;

	}

}
