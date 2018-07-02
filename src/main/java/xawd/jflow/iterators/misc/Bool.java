/**
 *
 */
package xawd.jflow.iterators.misc;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Wrapped truth values, useful for chaining boolean operations.
 *
 * @author ThomasB
 */
public enum Bool
{
	TRUE(true), FALSE(false);

	private final boolean primitiveVal;

	private Bool(boolean asBoolean)
	{
		this.primitiveVal = asBoolean;
	}

	/**
	 * Provides a wrapper for the Java ternary conditional operator.
	 *
	 * @param valueIfTrue
	 *            The value to return if this Bool wraps true.
	 * @param valueIfFalse
	 *            The value to return if this Bool wraps false.
	 * @return The first parameter if this Bool wraps true, the second if false.
	 */
	public <T> T choose(T valueIfTrue, T valueIfFalse)
	{
		return primitiveVal ? valueIfTrue : valueIfFalse;
	}

	/**
	 * Provides a wrapper for the Java ternary conditional operator.
	 *
	 * @param valueIfTrue
	 *            The value to return if this Bool wraps true.
	 * @param valueIfFalse
	 *            The value to return if this Bool wraps false.
	 * @return The first parameter if this Bool wraps true, the second if false.
	 */
	public double choose(double valueIfTrue, double valueIfFalse)
	{
		return primitiveVal ? valueIfTrue : valueIfFalse;
	}

	/**
	 * Provides a wrapper for the Java ternary conditional operator.
	 *
	 * @param valueIfTrue
	 *            The value to return if this Bool wraps true.
	 * @param valueIfFalse
	 *            The value to return if this Bool wraps false.
	 * @return The first parameter if this Bool wraps true, the second if false.
	 */
	public int choose(int valueIfTrue, int valueIfFalse)
	{
		return primitiveVal ? valueIfTrue : valueIfFalse;
	}

	/**
	 * Provides a wrapper for the Java ternary conditional operator.
	 *
	 * @param valueIfTrue
	 *            The value to return if this Bool wraps true.
	 * @param valueIfFalse
	 *            The value to return if this Bool wraps false.
	 * @return The first parameter if this Bool wraps true, the second if false.
	 */
	public long choose(long valueIfTrue, long valueIfFalse)
	{
		return primitiveVal ? valueIfTrue : valueIfFalse;
	}

	/**
	 * Applies a boolean OR operation with another wrapped truth value.
	 *
	 * @param other
	 *            A wrapped truth value.
	 *
	 * @return true if either wrapped boolean is true, false otherwise.
	 */
	public Bool or(Bool other)
	{
		return primitiveVal || other.primitiveVal ? TRUE : FALSE;
	}

	/**
	 * Applies a boolean XOR operation with another wrapped truth value.
	 *
	 * @param other
	 *            A wrapped truth value.
	 *
	 * @return true if exactly one wrapped boolean is true, false otherwise.
	 */
	public Bool xor(Bool other)
	{
		return primitiveVal ^ other.primitiveVal ? TRUE : FALSE;
	}

	/**
	 * Applies a boolean AND operation with another wrapped truth value.
	 *
	 * @param other
	 *            A wrapped truth value.
	 *
	 * @return true if both wrapped booleans are true, false otherwise.
	 */
	public Bool and(Bool other)
	{
		return primitiveVal && other.primitiveVal ? TRUE : FALSE;
	}

	/**
	 * Get the wrapped primitive boolean.
	 *
	 * @return The primitive boolean wrapped by this Bool.
	 */
	public boolean get()
	{
		return primitiveVal;
	}

	/**
	 * If the wrapped value is false then a Throwable is generated by the parameter
	 * supplier and then thrown.
	 *
	 * @param <X>
	 *            Some subclass of Throwable.
	 * @param exceptionSupplier
	 *            A supplier of some Throwable instance.
	 * @throws X
	 *             Some subclass of Throwable.
	 */
	public <X extends Throwable> void throwIfFalse(Supplier<X> exceptionSupplier) throws X
	{
		if (!primitiveVal) {
			throw exceptionSupplier.get();
		}
	}

	/**
	 * If the wrapped value is true then a Throwable is generated by the parameter
	 * supplier and then thrown.
	 *
	 * @param <X>
	 *            Some subclass of Throwable.
	 * @param exceptionSupplier
	 *            A supplier of some Throwable instance.
	 * @throws X
	 *             Some subclass of Throwable.
	 */
	public <X extends Throwable> void throwIfTrue(Supplier<X> exceptionSupplier) throws X
	{
		if (primitiveVal) {
			throw exceptionSupplier.get();
		}
	}

	/**
	 * If the wrapped value is false then the parameter procedure is executed.
	 *
	 * @param procedure
	 *            The {@link Runnable} instance which could be executed.
	 */
	public void runIfFalse(Runnable procedure)
	{
		if (!primitiveVal) {
			procedure.run();
		}
	}

	/**
	 * If the wrapped value is true then the parameter procedure is executed.
	 *
	 * @param procedure
	 *            The {@link Runnable} instance which could be executed.
	 */
	public void runIfTrue(Runnable procedure)
	{
		if (primitiveVal) {
			procedure.run();
		}
	}

	/**
	 * If the wrapped value is false then the parameter supplier function is called
	 * and the value returned wrapped in an optional.
	 *
	 * @param <T>
	 *            The element type to be computed and returned.
	 * @param supplier
	 *            The function which could be called.
	 *
	 * @return the result of calling the parameter function if the wrapped value is
	 *         false, nothing otherwise.
	 */
	public <T> Optional<T> computeIfFalse(Supplier<T> supplier)
	{
		if (!primitiveVal) {
			return Optional.of(supplier.get());
		} else {
			return Optional.empty();
		}
	}

	/**
	 * If the wrapped value is true then the parameter supplier function is called
	 * and the value returned wrapped in an optional.
	 *
	 * @param <T>
	 *            The element type to be computed and returned.
	 * @param supplier
	 *            The function which could be called.
	 *
	 * @return the result of calling the parameter function if the wrapped value is
	 *         true, nothing otherwise.
	 */
	public <T> Optional<T> computeIfTrue(Supplier<T> supplier)
	{
		if (primitiveVal) {
			return Optional.of(supplier.get());
		} else {
			return Optional.empty();
		}
	}
}
