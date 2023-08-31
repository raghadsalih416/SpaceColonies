//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * This class tests the space colony data exception class
 * 
 * @author raghadsalih
 * @version 2022.07.11
 *
 */
public class SpaceColonyDataExceptionTest extends student.TestCase {

    /**
     * tests the exceptions
     */
    public void testExceptions() {
        SpaceColonyDataException exception = new SpaceColonyDataException(
            "Test");
        assertNotNull(exception);
        assertTrue(exception instanceof SpaceColonyDataException);
    }

}
