package G31_CENG112_HW2;

import java.util.EmptyStackException;
import java.lang.*;
/**
 * This method implements IProduct and IStack interfaces, creates a stack to be used.
 * @param <T> The argument type.
 */
@SuppressWarnings("unused")
public class Warehouse<T> implements IProduct, IStack<T>{
	private T[] warehouse;
	private int topIndex;
	private boolean initialized = false;
	private static final int defaultCapacity = 50;
	private static final int maxCapacity = 10000;
	/**
	 * This method creates the stack with the default capacity.
	 */
	public Warehouse() {
		this(defaultCapacity);
	}
	/**
	 * This method creates the stack with the given capacity.
	 * @param initialCapacity The given capacity from the outside.
	 */
	public Warehouse(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		warehouse = tempStack;
		topIndex = -1;
		initialized = true;
	}
	/**
	 * This method checks the capacity if it is smaller than the maximum capacity limit. If it exceeds, throws an exception.
	 * @param initialCapacity The given capacity from the outside.
	 */
	private void checkCapacity(int initialCapacity) {
		if (initialCapacity > maxCapacity) {
			throw new IllegalArgumentException("Maximum capacity exceeded!");
		}
	}
	/**
	 * This method cannot be filled in this class so, we left it empty.
	 */
	public boolean isManufactured() {
		return false; 
	}
	/**
	 * This method checks the storing status. We couldn't managed how to fill and use this method.
	 * @return true or false according to the result. 
	 */
	public boolean isStored() {
		for (T item : warehouse) {
			if (item == "Cache") {
				return true;
			}
		}
		return false;
	}
	/**
	 * This method checks the solding status. We coukdn't managed how to fill and use this method.
	 * @return true or false according to the result.
	 */
	public boolean isSold() {
		if (pop() == warehouse[topIndex]) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method adds the given element to the stack, manages the topIndex again.
	 * @param newEntry The given entry from the outside.
	 */
	public void push(T newEntry) {
		checkInitialization();
		ensureCapacity();
		warehouse[topIndex + 1] = newEntry;
		topIndex++;
	}
	/**
	 * This method checks the capacity if it is enough or not. If it is not enough, it doubles the capacity.
	 */
	private void ensureCapacity() {
		if (topIndex == warehouse.length - 1) {
			int newLength = 2 * warehouse.length;
			checkCapacity(newLength);
			@SuppressWarnings("unchecked")
			T[] tempArr = (T[]) new String[newLength];
			for (int i = 0; i < newLength; i++) {
				if (i >= warehouse.length) {
					tempArr[i] = null;
				} else {
					tempArr[i] = warehouse[i];
				}
			}
			warehouse = tempArr;
		}
		
	}
	/**
	 * This method checks the initialization status. If it is not, method throws an exception.
	 */
	private void checkInitialization() {
		if (initialized == false) {
			throw new ExceptionInInitializerError();
		}
		
	}
	/**
	 * This method removes the top element from the stack.
	 * @return top The top element of the stack.
	 */
	public T pop() {
		int count = 0;
		for (int i = 0; i < warehouse.length; i++) {
			if (warehouse[i] != null) {
				count++;
			}
		}
		if (count == 0) {
			topIndex = 0;
		} else {
			topIndex = count - 1;
		}
		checkInitialization();
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			T top = warehouse[topIndex];
			warehouse[topIndex] = null;
			topIndex--;
			return top;
		}
	}
	/**
	 * This element observes the top element of the stack. It does not removes it.
	 * @return warehouse[topIndex] The top element of the stack.
	 */
	public T peek() {
		checkInitialization();
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return warehouse[topIndex];
		}
	}
	/**
	 * This element checks the emptiness.
	 * @return true or false according to the result.
	 */
	public boolean isEmpty() {
		int count = 0;
		for (int i = 0; i < warehouse.length; i++) {
			if (warehouse[i] == null) {
				count++;
				if (count == warehouse.length) {
					return true;
				}
			} else if (i == (warehouse.length - 1)) {
				return false;
			} 
		} return false;
	}
	/**
	 * This method clears the stack.
	 */
	public void clear() {
		warehouse = null;
		
	}
	/**
	 * This method gets the length of the stack.
	 * @return count The item count of the stack.
	 */
	public int getLength() {
		int count = 0;
		for (int i = 0; i < warehouse.length; i++) {
			if (warehouse[i] != null) {
				count++;
			}
		}
		return count;
	}

}