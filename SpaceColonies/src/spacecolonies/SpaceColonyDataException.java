//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

/**
 * This will be thrown if data is incorrect in the input files
 * 
 * @author raghadsalih
 * @version 2022.02.11
 *
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * sends a string for exceptions
     * 
     * @param string 
     *          the message whem exception is thrown
     */
    public SpaceColonyDataException(String string) {
        super(string); 
    }

}
