package xawd.jchain.chains.utilities;

import static org.junit.Assert.assertTrue;
import static xawd.jchain.chains.utilities.CollectionUtil.str;
import static xawd.jchain.chains.utilities.CombineUtil.combine;
import static xawd.jchain.chains.utilities.CombineUtil.join;

import org.junit.Test;

/**
 * @author ThomasB
 * @since 14 Feb 2018
 */
public class CombineUtilTest extends TestDataProvider
{
	@Test
	public void joinTest()
	{
		final int[] expectedResult = {ONE, TWO, THREE, ONE, TWO, THREE};

		assertTrue(str(join(XS_INT_ARR, XS_INT_ARR)), areEqual(expectedResult, join(XS_INT_ARR, XS_INT_ARR)));
		assertTrue(str(join(XS_INT_IMARR, XS_INT_IMARR)), areEqual(expectedResult, join(XS_INT_IMARR, XS_INT_IMARR)));
		assertTrue(str(join(XS_INT_GEN, XS_INT_GEN)), areEqual(expectedResult, join(XS_INT_GEN, XS_INT_GEN)));

		assertTrue(str(join(XS_DOUBLE_ARR, XS_DOUBLE_ARR)), areEqual(expectedResult, join(XS_DOUBLE_ARR, XS_DOUBLE_ARR)));
		assertTrue(str(join(XS_DOUBLE_IMARR, XS_DOUBLE_IMARR)), areEqual(expectedResult, join(XS_DOUBLE_IMARR, XS_DOUBLE_IMARR)));
		assertTrue(str(join(XS_DOUBLE_GEN, XS_DOUBLE_GEN)), areEqual(expectedResult, join(XS_DOUBLE_GEN, XS_DOUBLE_GEN)));

		assertTrue(str(join(XS_LONG_ARR, XS_LONG_ARR)), areEqual(expectedResult, join(XS_LONG_ARR, XS_LONG_ARR)));
		assertTrue(str(join(XS_LONG_IMARR, XS_LONG_IMARR)), areEqual(expectedResult, join(XS_LONG_IMARR, XS_LONG_IMARR)));
		assertTrue(str(join(XS_LONG_GEN, XS_LONG_GEN)), areEqual(expectedResult, join(XS_LONG_GEN, XS_LONG_GEN)));

		assertTrue(str(join(XS_OBJ_ARR, XS_OBJ_ARR)), areEqual(expectedResult, join(XS_OBJ_ARR, XS_OBJ_ARR)));
		assertTrue(str(join(XS_OBJ_LIST, XS_OBJ_LIST)), areEqual(expectedResult, join(XS_OBJ_LIST, XS_OBJ_LIST)));
		assertTrue(str(join(XS_OBJ_IMLIST, XS_OBJ_IMLIST)), areEqual(expectedResult, join(XS_OBJ_IMLIST, XS_OBJ_IMLIST)));
		assertTrue(str(join(XS_OBJ_GEN, XS_OBJ_GEN)), areEqual(expectedResult, join(XS_OBJ_GEN, XS_OBJ_GEN)));
	}

	@Test
	public void combineTest()
	{
		final int[] expectedResult = {ONE*ONE, TWO*TWO, THREE*THREE};

		assertTrue(str(combine((a, b) -> a*b, XS_INT_ARR, XS_INT_ARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_INT_ARR, XS_INT_ARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_INT_IMARR, XS_INT_IMARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_INT_IMARR, XS_INT_IMARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_INT_GEN, XS_INT_GEN)), areEqual(expectedResult, combine((a, b) -> a*b, XS_INT_GEN, XS_INT_GEN)));

		assertTrue(str(combine((a, b) -> a*b, XS_DOUBLE_ARR, XS_DOUBLE_ARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_DOUBLE_ARR, XS_DOUBLE_ARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_DOUBLE_IMARR, XS_DOUBLE_IMARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_DOUBLE_IMARR, XS_DOUBLE_IMARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_DOUBLE_GEN, XS_DOUBLE_GEN)), areEqual(expectedResult, combine((a, b) -> a*b, XS_DOUBLE_GEN, XS_DOUBLE_GEN)));

		assertTrue(str(combine((a, b) -> a*b, XS_LONG_ARR, XS_LONG_ARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_LONG_ARR, XS_LONG_ARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_LONG_IMARR, XS_LONG_IMARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_LONG_IMARR, XS_LONG_IMARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_LONG_GEN, XS_LONG_GEN)), areEqual(expectedResult, combine((a, b) -> a*b, XS_LONG_GEN, XS_LONG_GEN)));

		assertTrue(str(combine((a, b) -> a*b, XS_OBJ_ARR, XS_OBJ_ARR)), areEqual(expectedResult, combine((a, b) -> a*b, XS_OBJ_ARR, XS_OBJ_ARR)));
		assertTrue(str(combine((a, b) -> a*b, XS_OBJ_LIST, XS_OBJ_LIST)), areEqual(expectedResult, combine((a, b) -> a*b, XS_OBJ_LIST, XS_OBJ_LIST)));
		assertTrue(str(combine((a, b) -> a*b, XS_OBJ_IMLIST, XS_OBJ_IMLIST)), areEqual(expectedResult, combine((a, b) -> a*b, XS_OBJ_IMLIST, XS_OBJ_IMLIST)));
		assertTrue(str(combine((a, b) -> a*b, XS_OBJ_GEN, XS_OBJ_GEN)), areEqual(expectedResult, combine((a, b) -> a*b, XS_OBJ_GEN, XS_OBJ_GEN)));
	}

	// dotProduct implicitly tested by testing other functions.
}