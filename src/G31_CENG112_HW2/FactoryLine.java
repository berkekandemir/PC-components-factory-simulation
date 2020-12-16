package G31_CENG112_HW2;
/**
 * This class implements IProduct and IQueue interfaces, creates the queue according to the circular array format.
 * @param <T> The argument type.
 */
@SuppressWarnings("unused")
public class FactoryLine<T> implements IProduct, IQueue<T> {
	private T[] factoryLine ;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int defaultCapacity = 50;
	private static final int maxCapacity = 10000;
	/**
	 * This method creates a queue with the default capacity.
	 */
	public FactoryLine() {
		this(defaultCapacity);
	}
	/**
	 * This method creates a queue with the given capacity. It points out the frontIndex and backIndex. 
	 * @param initialCapacity the given capacity from outside.
	 */
	public FactoryLine(int initialCapacity) {
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		factoryLine = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		initialized = true;
	}

	/**
	 * This method checks the capacity if it is smaller than the maximum capacity limit.
	 * @param initialCapacity the given capacity value from outside.
	 * @return it returns true or throws an exception.
	 */
	private boolean checkCapacity(int initialCapacity) {
		if (initialCapacity > maxCapacity) {
			throw new IllegalArgumentException("Maximum capacity exceeded!");
		} else {
			return true;
		}
	}
	/**
	 * This method checks the manufacturing status. We didn't use this method and we couldn't managed how to fill and use this method.
	 * @return it returns true or false.
	 */
	public boolean isManufactured() {
		T last = factoryLine[backIndex];
		enqueue(last);
		if (last == factoryLine[backIndex]) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * This method cannot be filled for this class so, we left it empty.
	 */
	public boolean isStored() {
		return false;
	}
	/**
	 * This method cannot be filled for this class so, we left it empty.
	 */
	public boolean isSold() {
		return false;
	}
	/**
	 * This method add elements to the queue from the back. Then manages the backIndex again. We have used circular array format for queue.
	 * @param newEntry the given element from the outside.
	 */
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1) % factoryLine.length;
		factoryLine[backIndex] = newEntry;
		
	}
	/**
	 * This method checks capacity if it is enough to add elements or not. If it is not enough, it doubles the size.
	 */
	private void ensureCapacity() {
		if (frontIndex == ((backIndex + 2) % factoryLine.length)) {
			T[] oldQueue = factoryLine;
			int oldSize = factoryLine.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			factoryLine = tempQueue;
			for (int i = 0; i < oldSize - 1; i++) {
				factoryLine[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
	/**
	 * This method checks the initialization. If the initialization is not successful, it throws an exception.
	 */
	private void checkInitialization() {
		if (initialized == false) {
			throw new ExceptionInInitializerError();
		}
		
	}
	/**
	 * This method removes the element from the frontIndex. Then manages frontIndex again. If the queue is empty, then throws an exception.
	 * @return front The front element is returned.
	 */
	public T dequeue() {
		checkInitialization();
		if (isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			T front = factoryLine[frontIndex];
			factoryLine[frontIndex] = null;
			frontIndex = (frontIndex + 1) % factoryLine.length;
			return front;
		}
	}
	/**
	 * This method gets the front element but, does not removes it from the queue. If the queue is empty, then throws an exception.
	 * @return factoryLine[frontIndex] The front element is returned.
	 */
	public T getFront() {
		checkInitialization();
		if (isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			return factoryLine[frontIndex];
		}
	}
	/**
	 * This method checks the emptiness.
	 * @return true or false according to the result.
	 */
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % factoryLine.length);
	}
	/**
	 * This method clears the queue.
	 */
	public void clear() {
		factoryLine = null;
	}
	/**
	 * This method gets the item count in the queue.
	 * @param item The given item name to be searched.
	 * @return count The number of the element.
	 */
	public int getCount(T item) {
		int count = 0;
		for (T i : factoryLine) {
			if (i == item) {
				count++;
			}
		} return count;
	}

}

