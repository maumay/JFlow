/**
 *
 */
package xawd.jflow.iterators.examples;

import java.util.ArrayList;
import java.util.Collection;

import xawd.jflow.iterators.Flow;
import xawd.jflow.iterators.impl.FlowFromValues;
import xawd.jflow.iterators.impl.ReverseFlowFromValues;

/**
 * @author t
 */
public class ArrayListFlow<E> extends ArrayList<E> implements ListFlow<E> {
	/**
	 *
	 */
	private static final long serialVersionUID = -7069256425982985037L;

	public ArrayListFlow() {
	}

	public ArrayListFlow(int initialCapacity)
	{
		super(initialCapacity);
	}

	public ArrayListFlow(Collection<? extends E> source)
	{
		super(source);
	}

	@Override
	public Flow<E> iter() {
		return new FlowFromValues.OfObject<>(this);
	}

	@Override
	public Flow<E> rIter() {
		return new ReverseFlowFromValues.OfObject<>(this);
	}
}