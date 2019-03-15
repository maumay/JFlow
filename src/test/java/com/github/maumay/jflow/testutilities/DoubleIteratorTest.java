package com.github.maumay.jflow.testutilities;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.github.maumay.jflow.impl.AbstractDoubleIterator;
import com.github.maumay.jflow.impl.AbstractIteratorSize;

/**
 * @author ThomasB
 * @since 27 Apr 2018
 */
public interface DoubleIteratorTest
{
	default void assertDoubleIteratorAsExpected(double[] expectedElements,
			AbstractIterableDoubles iteratorProvider)
	{
		assertSizeAsExpected(expectedElements, iteratorProvider.iter());
		assertSizeDecreasesAsExpected(iteratorProvider.iter());
		assertSkippingAsExpected(expectedElements, iteratorProvider.iter());
		assertNextElementChecksAsExpected(expectedElements, iteratorProvider.iter());
		assertStandardIterationAsExpected(expectedElements, iteratorProvider.iter());
		assertUncheckedIterationAsExpected(expectedElements, iteratorProvider.iter());
		assertAlternatingNextAndSkipCallsAsExpected(expectedElements, iteratorProvider.iter());
	}

	static void assertSizeAsExpected(double[] expectedElements, AbstractDoubleIterator iterator)
	{
		iterator.getSize().getExactSize().ifPresent(n -> {
			assertEquals(expectedElements.length, n);
		});
		iterator.getSize().getUpperBound().ifPresent(n -> {
			assertTrue(expectedElements.length <= n);
		});
		iterator.getSize().getLowerBound().ifPresent(n -> {
			assertTrue(n <= expectedElements.length);
		});
	}

	static void assertSizeDecreasesAsExpected(AbstractDoubleIterator iterator)
	{
		AbstractIteratorSize size = iterator.getSize();
		OptionalInt lower = size.getLowerBound(), exact = size.getExactSize(),
				upper = size.getUpperBound();

		int count = 0;
		while (iterator.hasNext()) {
			count++;
			iterator.nextDouble();
			assertEquals(size.getLowerBound(), Utils.subtractSize(lower, count));
			assertEquals(size.getUpperBound(), Utils.subtractSize(upper, count));
			assertEquals(size.getExactSize(), Utils.subtractSize(exact, count));
		}
	}

	static void assertSkippingAsExpected(double[] expectedElements, AbstractDoubleIterator iterator)
	{
		IntStream.range(0, expectedElements.length).forEach(i -> iterator.skip());
		assertThrows(NoSuchElementException.class, iterator::skip);
	}

	static void assertNextElementChecksAsExpected(double[] expectedElements,
			AbstractDoubleIterator iterator)
	{
		IntStream.range(0, expectedElements.length).forEach(i -> {
			assertTrue(iterator.hasNext());
			iterator.skip();
		});
		assertFalse(iterator.hasNext());
	}

	static void assertStandardIterationAsExpected(double[] expectedElements,
			AbstractDoubleIterator iterator)
	{
		List<Double> recoveredElements = new ArrayList<>();
		while (iterator.hasNext()) {
			recoveredElements.add(iterator.nextDouble());
		}
		assertThrows(NoSuchElementException.class, iterator::nextDouble);
		assertThrows(NoSuchElementException.class, iterator::skip);
		assertArrayEquals(expectedElements, convertFromBoxed(recoveredElements));
	}

	static void assertUncheckedIterationAsExpected(double[] expectedElements,
			AbstractDoubleIterator iterator)
	{
		List<Double> recoveredElements = new ArrayList<>();
		IntStream.range(0, expectedElements.length)
				.forEach(i -> recoveredElements.add(iterator.nextDouble()));

		assertThrows(NoSuchElementException.class, iterator::nextDouble);
		assertThrows(NoSuchElementException.class, iterator::skip);
		assertArrayEquals(expectedElements, convertFromBoxed(recoveredElements));
	}

	static void assertAlternatingNextAndSkipCallsAsExpected(double[] expectedElements,
			AbstractDoubleIterator iterator)
	{
		List<Double> expectedOutcome = new ArrayList<>(), recoveredElements = new ArrayList<>();

		IntStream.range(0, expectedElements.length).forEach(i -> {
			if (i % 2 == 0) {
				recoveredElements.add(iterator.nextDouble());
				expectedOutcome.add(expectedElements[i]);
			} else {
				iterator.skip();
			}
		});

		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, iterator::nextDouble);
		assertThrows(NoSuchElementException.class, iterator::skip);
		assertEquals(expectedOutcome, recoveredElements);
	}

	static double[] convertFromBoxed(List<Double> boxedDoubles)
	{
		return boxedDoubles.stream().mapToDouble(i -> i).toArray();
	}
}
