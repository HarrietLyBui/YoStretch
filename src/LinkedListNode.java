/**
 * 
 */

/**
 * @author bui23l
 *
 */
public class LinkedListNode<T> {
	// variable data of type T hold data of the node
	private T data;
	// variable setting the pointer to the next node
	private LinkedListNode<T> next;

	// constructor
	LinkedListNode() {

	}

	/**
	 * Set the data stored at this node.
	 **/
	public void setData(T data) {
		// make the input data of this node
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 **/
	public T getData() {
		// return data
		return data;
	}

	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext(LinkedListNode<T> node) {
		// set input to be the next node of this node
		this.next = node;

	}

	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext() {
		// return next
		return next;

	}

	/**
	 * Returns a String representation of this node.
	 **/
	public String toString() {
		// variable display of type String
		String display;
		// convert data to String and pass it to display
		display = (String) getData();
		// return display
		return display;

	}

}
