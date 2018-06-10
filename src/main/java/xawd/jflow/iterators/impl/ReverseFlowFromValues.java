/**
 *
 */
package xawd.jflow.iterators.impl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import xawd.jflow.iterators.AbstractDoubleFlow;
import xawd.jflow.iterators.AbstractFlow;
import xawd.jflow.iterators.AbstractIntFlow;
import xawd.jflow.iterators.AbstractLongFlow;

/**
 * @author t
 *
 */
public final class ReverseFlowFromValues
{
	private ReverseFlowFromValues() {}

	public static class OfObject<E> extends AbstractFlow<E>
	{
		private final Object[] source;
		private int count;

		public OfObject(final List<? extends E> source)
		{
			count = source.size() - 1;
			this.source = source.toArray();
		}

		@SafeVarargs
		public OfObject(E... source)
		{
			count = source.length - 1;
			this.source = Arrays.copyOf((Object[]) source, source.length);
		}

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next()
		{
			try {
				return (E) source[count--];
			}
			catch (final IndexOutOfBoundsException ex) {
				throw new NoSuchElementException("The source was potentially mutated after binding occured.");
			}
		}

		@Override
		public void skip()
		{
			if (count-- < 0) {
				throw new NoSuchElementException();
			}
		}
	}

	public static class OfLong extends AbstractLongFlow
	{
		private final long[] source;
		private int count;

		public OfLong(final long[] source)
		{
			this.source = source;
			count = source.length - 1;
		}

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@Override
		public long nextLong()
		{
			try {
				return source[count--];
			}
			catch (final IndexOutOfBoundsException ex) {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void skip()
		{
			if (count-- < 0) {
				throw new NoSuchElementException();
			}
		}
	}

	public static class OfDouble extends AbstractDoubleFlow
	{
		private final double[] source;
		private int count;

		public OfDouble(final double[] source)
		{
			this.source = source;
			count = source.length - 1;
		}

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@Override
		public double nextDouble()
		{
			try {
				return source[count--];
			}
			catch (final IndexOutOfBoundsException ex) {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void skip()
		{
			if (count-- < 0) {
				throw new NoSuchElementException();
			}
		}
	}

	public static class OfInt extends AbstractIntFlow
	{
		private final int[] source;
		private int count;

		public OfInt(final int[] source)
		{
			this.source = source;
			count = source.length - 1;
		}

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@Override
		public int nextInt()
		{
			try {
				return source[count--];
			}
			catch (final IndexOutOfBoundsException ex) {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void skip()
		{
			if (count-- < 0) {
				throw new NoSuchElementException();
			}
		}
	}
}
