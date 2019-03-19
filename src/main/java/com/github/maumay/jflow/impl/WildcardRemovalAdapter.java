/**
 * 
 */
package com.github.maumay.jflow.impl;

import com.github.maumay.jflow.impl.AbstractIteratorAdapter.OfObject;

/**
 * @author thomasb
 *
 */
public final class WildcardRemovalAdapter<E>
		extends OfObject<AbstractRichIterator<? extends E>, E>
{
	public WildcardRemovalAdapter(AbstractRichIterator<? extends E> source)
	{
		super(source.getSize().copy(), source);
	}

	@Override
	public boolean hasNext()
	{
		return getSource().hasNext();
	}

	@Override
	public E nextImpl()
	{
		return getSource().nextImpl();
	}

	@Override
	public void skipImpl()
	{
		getSource().skipImpl();
	}
}