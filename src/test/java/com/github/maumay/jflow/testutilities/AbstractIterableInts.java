package com.github.maumay.jflow.testutilities;

import com.github.maumay.jflow.impl.AbstractIntIterator;
import com.github.maumay.jflow.iterables.IntIterable;

/**
 * @author ThomasB
 * @since 27 Apr 2018
 */
public abstract class AbstractIterableInts implements IntIterable
{
	@Override
	public abstract AbstractIntIterator iter();
}
