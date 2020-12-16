package G31_CENG112_HW2;
/**
 * This is the queue interface that has been implemented in the factoryLine class.
 * @param <T> The given argument type. 
 */
public interface IQueue<T> {
	public void enqueue(T newEntry);
	public T dequeue();
	public T getFront();
	public boolean isEmpty();
	public void clear();
}
