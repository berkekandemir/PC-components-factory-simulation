package G31_CENG112_HW2;
/**
 * This is the stack interface that has been implemented in the warehouse class.
 * @param <T> The given argument type.
 */
public interface IStack<T> {
	public void push(T newEntry);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public void clear();
}
